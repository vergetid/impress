package eu.impress.logevo.service;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.impress.logevo.dao.NuggetDAO;
import eu.impress.logevo.dao.PatientDAO;
import eu.impress.logevo.model.Patient;
import eu.impress.logevo.util.LogevoCallsEnvelopeFactory;

@Component
public class NuggetDAOImpl implements NuggetDAO {

	@Autowired
	PatientDAO patientDAO;
	
	@Override
	public void initiatePatient(Patient patient, String eventId, String timeDiff) {
		//call Apriorigen
		try {
			System.out.println("NuggetDAO: Calling Envelope creation");
			SOAPMessage soapMessage = LogevoCallsEnvelopeFactory.createAprioriGenfullRequest(eventId);
			
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            String url = "http://biomat1.iasi.cnr.it/webservices/IMPRESS/services.php";
            SOAPMessage soapResponse = soapConnection.call(soapMessage, url);	
            //LogevoCallsEnvelopeFactory.printSOAPResponse(soapResponse);
            //Get returned nugget:
            //System.out.println("NuggetDAOImpl: initiatePatient: NUGGET RETURNED BY APRIORIGET "
            //+ soapResponse.getSOAPBody().getElementsByTagName("nugget").item(0).getTextContent());
            
            String nugget = soapResponse.getSOAPBody().getElementsByTagName("nugget").item(0).getTextContent();
            SOAPMessage sickevoSoapMessage = 
            		LogevoCallsEnvelopeFactory.createSickevoFullRequest(nugget, "0", timeDiff);
            SOAPMessage sickevoSoapResponse = soapConnection.call(sickevoSoapMessage, url);	
            System.out.println("NuggetDAOImpl: initiatePatient: SICKEVO RETURNED WITH:");
            LogevoCallsEnvelopeFactory.printSOAPResponse(sickevoSoapResponse);
            nugget = sickevoSoapResponse.getSOAPBody().getElementsByTagName("nugget").item(0).getTextContent();
            patient.setNugget(nugget);
            patient.setAsset_id("0");
            patientDAO.addPatient(patient);
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
