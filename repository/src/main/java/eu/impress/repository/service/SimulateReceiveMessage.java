package eu.impress.repository.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.xml.sax.SAXException;

import eu.impress.logevo.dao.NuggetDAO;
import eu.impress.logevo.dao.PatientDAO;
import eu.impress.logevo.model.Patient;
import eu.impress.logevo.service.NuggetDAOImpl;
import eu.impress.logevo.service.PatientDAOImpl;
import eu.impress.logevo.util.Asset;
import eu.impress.logevo.util.TepParsingUtil;

//Method used for development:
//Simulates the interception of a TEP Message
//Can work without a connection to the ActiveMQ


public class SimulateReceiveMessage {

	// @Autowired
	// ConfigurableApplicationContext context;
	// ?consumer.retroactive=true&consumer.prefetchSize=10
	//@JmsListener(destination = "IMPRESS.IncidentMgmt.TrackingPatients", containerFactory = "myJmsContainerFactory", subscription = "intl-89890")	
	public void receiveMessage(String message) {
		//System.out.println("Received <" + message + ">");
		//Prepare an xml document to parse the TEP Message
System.err.println("SIMULATION: RECEIVED: " + message);
			
		//Get Patient Pseudo id & event type
		String eventId;
		String patientId;
		String timeDiff;
		String asset;
		PatientDAO patientDAO = new PatientDAOImpl();
		NuggetDAO nuggetDAO = new NuggetDAOImpl();
		try {
			eventId = TepParsingUtil.getEventType(message);
			patientId = TepParsingUtil.getPatientId(message);
			timeDiff = TepParsingUtil.getSentAndIncidentTimeDiff(message);
		} catch (ParserConfigurationException | SAXException | IOException | ParseException e1) {
			// TODO Auto-generated catch block
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
				nuggetDAO.initiatePatient(patient, eventId, timeDiff);
			} else {
				//existing patient. Update w SICKEVO
				//1st: Get Asset				
				System.out.println("ReceiverImpl: Found existing patient");
				//System.out.println("Found asset: " + TepParsingUtil.getAsset(message));
				//System.out.println("With Value: " + Asset.getValByName(TepParsingUtil.getAsset(message)));
				patient.setAsset_id(Asset.getValByName(TepParsingUtil.getAsset(message)));
				nuggetDAO.updatePatient(patient, 
						TepParsingUtil.getSentTime(message));
				//Check if patient has Symptoms
				TepParsingUtil.getSymptoms(message);
			}
		} catch (ParserConfigurationException | SAXException | IOException | ParseException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			LogevoCallsEnvelopeFactory.createAprioriGenfullRequest(eventId);
		} catch (SOAPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		/*System.out.println("DEBUG: eventId: " + eventId);
		// Save the contents of the message to a file
		File file = new File(getClass().getClassLoader().getResource(".").getFile()
				+ "/TEPmessageReceived_" + new Date().getTime() + ".msg");
		// context.close();
		try (Writer writer = new BufferedWriter(new FileWriter(file))) {
			String contents = message;

			writer.write(contents);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		FileSystemUtils.deleteRecursively(new File("activemq-data"));
	}

}