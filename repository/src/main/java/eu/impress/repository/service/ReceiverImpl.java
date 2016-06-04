package eu.impress.repository.service;

import eu.impress.logevo.dao.NuggetDAO;
import eu.impress.logevo.dao.PatientDAO;
import eu.impress.logevo.model.GaugerSymptom;
import eu.impress.logevo.model.Patient;
import eu.impress.logevo.util.Asset;
import eu.impress.logevo.util.LogevoCallsEnvelopeFactory;
import eu.impress.logevo.util.TepParsingUtil;
import eu.impress.repository.dao.Receiver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

@Component
public class ReceiverImpl {
	@Autowired
	PatientDAO patientDAO;
	@Autowired
	NuggetDAO nuggetDAO;
	 @Autowired
	 ConfigurableApplicationContext context;
	// ?consumer.retroactive=true&consumer.prefetchSize=10
	 //@JmsListener(destination = "ActiveMQ.Advisory.Consumer.Topic.IMPRESS.IncidentMgmt.TrackingPatients", containerFactory = "myJmsContainerFactory", subscription = "intl-89890")
	@JmsListener(destination = "IMPRESS.IncidentMgmt.TrackingPatients", containerFactory = "myJmsContainerFactory", subscription = "intl-89890")
	 //@JmsListener(destination = "IMPRESS.IncidentMgmt.Messages", containerFactory = "myJmsContainerFactory", subscription = "intl-89890-55")
	//@JmsListener(destination = "SPRING.TEST", containerFactory = "myJmsContainerFactory", subscription = "intl-89890")
	public void receiveMessage(String message) {
		System.out.println("Received <" + message + ">");
		//Prepare an xml document to parse the TEP Message

			
		//Get Patient Pseudo id & event type
		String eventId = null;
		String patientId = null;
		String timeDiff = null;
		String asset = null;
		String incidentId = null;
		try {
			eventId = TepParsingUtil.getEventType(message);
			patientId = TepParsingUtil.getPatientId(message);
			timeDiff = TepParsingUtil.getSentAndIncidentTimeDiff(message);
			incidentId = TepParsingUtil.getIncidentId(message);
			//timeDiff = "0.1";
			//incidentId = "131313";
		} catch (ParserConfigurationException | SAXException | IOException | ParseException e1) {			
			e1.printStackTrace();
			return;
		}
		//Check if patient exists
		
		try {
			Patient patient = patientDAO.findPatientbyID(patientId);
			if (patient == null ) {
				//new patient
				patient = new Patient();
				patient.setPseudoID(patientId);
				patient.setIncidentId(incidentId);
				nuggetDAO.initiatePatient(patient, eventId, timeDiff);
				List<GaugerSymptom> symptoms = TepParsingUtil.getSymptoms(message);
				//check if symptoms present
				if (symptoms.size() > 0) {
					nuggetDAO.updatePatientWithSymptoms(patient, symptoms);
					nuggetDAO.updatePatientStatScoring(patient);
				}				
			} else {
				//existing patient. Update w SICKEVO
				//1st: Get Asset				
				System.out.println("ReceiverImpl: Found existing patient");
				//System.out.println("Found asset: " + TepParsingUtil.getAsset(message));
				//System.out.println("With Value: " + Asset.getValByName(TepParsingUtil.getAsset(message)));
				String sickevoAsset = null;
				if ( Asset.getValByName(TepParsingUtil.getAsset(message)) != null) {
					sickevoAsset = Asset.getValByName(TepParsingUtil.getAsset(message));
					//patient.setAsset_id( Asset.getValByName(TepParsingUtil.getAsset(message)) );
				} else {
					sickevoAsset = "0";
					//patient.setAsset_id("0");
				}
				nuggetDAO.updatePatient(patient, 
						TepParsingUtil.getSentTime(message), sickevoAsset);
				List<GaugerSymptom> symptoms = TepParsingUtil.getSymptoms(message);
				//check if symptoms present
				if (symptoms.size() > 0) {
					nuggetDAO.updatePatientWithSymptoms(patient, symptoms);
					nuggetDAO.updatePatientStatScoring(patient);
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException | ParseException | SQLException e) {			
			e.printStackTrace();
		}
		/*try {
			LogevoCallsEnvelopeFactory.createAprioriGenfullRequest(eventId);
		} catch (SOAPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		System.out.println("DEBUG: eventId: " + eventId);
		// Save the contents of the message to a file
		//File file = new File(getClass().getClassLoader().getResource(".").getFile()
		//		+ "/TEPmessageReceived_" + new Date().getTime() + ".msg");
		// context.close();
		//try (Writer writer = new BufferedWriter(new FileWriter(file))) {
		//	String contents = message;

		//	writer.write(contents);
		//} catch (IOException e) {
		//	e.printStackTrace();
		//}
		FileSystemUtils.deleteRecursively(new File("activemq-data"));
	}

}
