package eu.impress.logevo.service;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.impress.logevo.dao.GaugerSymptomDAO;
import eu.impress.logevo.dao.NuggetDAO;
import eu.impress.logevo.dao.PatientDAO;
import eu.impress.logevo.model.GaugerSymptom;
import eu.impress.logevo.model.PPS;
import eu.impress.logevo.model.Patient;
import eu.impress.logevo.util.DateUtils;
import eu.impress.logevo.util.LogevoCallsEnvelopeFactory;

@Component
public class NuggetDAOImpl implements NuggetDAO {

	@Autowired
	PatientDAO patientDAO;
	@Autowired
	GaugerSymptomDAO gaugerSymptomDAO;
	
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
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            Long timeInMillis = gregorianCalendar.getTimeInMillis();
            //patient.setLastUpdateTime(timeInMillis.toString());
            Long timeInMillisLong = System.currentTimeMillis();
            patient.setLastUpdateTime(timeInMillisLong.toString());
           
            
            patientDAO.addPatient(patient);
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void updatePatient(Patient patient, String TEPTime, String sickevoAsset) {
        
        try {
        	SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();
			String url = "http://biomat1.iasi.cnr.it/webservices/IMPRESS/services.php";	
			Long millisNow = System.currentTimeMillis();
			Long patientLastUpdateEpoch = Long.parseLong(patient.getLastUpdateTime());
			//Long deltaT = (Long.parseLong(TEPTime) 
			//		- Long.parseLong(patient.getLastUpdateTime()));
			System.out.println("NuggetDAOImpl: updatePatient: MillisNow and PatientLastUpdate");
			System.out.println("\t millisNow: " + millisNow);
			System.out.println("\t patientLastUpdateEpoch: " + patientLastUpdateEpoch);
			Long deltaT = millisNow - patientLastUpdateEpoch;
			System.out.println("\t deltaT: " + deltaT);
			System.out.println("\t deltaT in Hours: " + DateUtils.millisToHours(deltaT));
			System.out.println("NUGGETDAOIMPL: UPDATE PATIENT: ");
			//System.out.println("\t got TEP Time: " + TEPTime);
			//System.out.println("\t Patient last update time: " + patient.getLastUpdateTime());
            SOAPMessage sickevoSoapMessage = 
            		LogevoCallsEnvelopeFactory.createSickevoFullRequest(
            				patient.getNugget(), 
            				patient.getAsset_id(), 
            				DateUtils.millisToHours(deltaT));
            SOAPMessage sickevoSoapResponse = soapConnection.call(sickevoSoapMessage, url);	
            System.out.println("NuggetDAOImpl: updatePatient: SICKEVO RETURNED WITH:");
            LogevoCallsEnvelopeFactory.printSOAPResponse(sickevoSoapResponse);
            
            String nugget = sickevoSoapResponse.getSOAPBody().getElementsByTagName("nugget").item(0).getTextContent();
            patient.setNugget(nugget);
            patient.setAsset_id(sickevoAsset);
            //Long updateTime = Long.parseLong(DateUtils.XmlGregorianDateStringtoEpoch(TEPTime));
            //patient.setLastUpdateTime(DateUtils.XmlGregorianDateStringtoEpoch(updateTime.toString()));
            patient.setLastUpdateTime(millisNow.toString());
            patientDAO.updatePatient(patient);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void updatePatientWithSymptoms(Patient patient, List<GaugerSymptom> symptoms) {
		for (GaugerSymptom symptom : symptoms) {
			int symptomId = gaugerSymptomDAO.getSymptomIdbySymtomDescription(
					symptom.getLocation(), symptom.getSymptomType());
				try {
	        	SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
				SOAPConnection soapConnection = soapConnectionFactory.createConnection();
				String url = "http://biomat1.iasi.cnr.it/webservices/IMPRESS/services.php";	
	            SOAPMessage sickevoSoapMessage = 
	            		LogevoCallsEnvelopeFactory.createGaugerFullrequest(
	            				patient.getNugget(), symptomId, symptom.getValue());
	            SOAPMessage sickevoSoapResponse = soapConnection.call(sickevoSoapMessage, url);	
	            System.out.println("NuggetDAOImpl: updatePatient: GAUGER RETURNED WITH:");
	            LogevoCallsEnvelopeFactory.printSOAPResponse(sickevoSoapResponse);
	            
	            String nugget = sickevoSoapResponse.getSOAPBody().getElementsByTagName("nugget").item(0).getTextContent();
	            patient.setNugget(nugget);
	            patientDAO.updatePatient(patient);
				} catch (Exception e) {
					e.printStackTrace();
				}
	             			
		}
	}

	@Override
	public void updatePatientStatScoring(Patient patient) {
		PPS pps = getPPSFromNugget(patient.getNugget());
		
	}
	
	private PPS getPPSFromNugget(String nugget) {
		try {
        	SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();
			String url = "http://biomat1.iasi.cnr.it/webservices/IMPRESS/services.php";	
            SOAPMessage sickevoSoapMessage = 
            		LogevoCallsEnvelopeFactory.createExposePPSrequest(nugget);
            SOAPMessage sickevoSoapResponse = soapConnection.call(sickevoSoapMessage, url);	
            System.out.println("NuggetDAOImpl: updatePatient: GAUGER RETURNED WITH:");
            LogevoCallsEnvelopeFactory.printSOAPResponse(sickevoSoapResponse);
            PPS pps = new PPS();
            pps.setX_A(sickevoSoapResponse.getSOAPBody().getElementsByTagName("x_A").item(0).getTextContent());
            pps.setX_B1(sickevoSoapResponse.getSOAPBody().getElementsByTagName("x_B1").item(0).getTextContent());
            pps.setX_B2(sickevoSoapResponse.getSOAPBody().getElementsByTagName("x_B2").item(0).getTextContent());
            pps.setX_B3(sickevoSoapResponse.getSOAPBody().getElementsByTagName("x_B3").item(0).getTextContent());
            pps.setX_C1(sickevoSoapResponse.getSOAPBody().getElementsByTagName("x_C1").item(0).getTextContent());
            pps.setX_C2(sickevoSoapResponse.getSOAPBody().getElementsByTagName("x_C2").item(0).getTextContent());
            pps.setX_D1(sickevoSoapResponse.getSOAPBody().getElementsByTagName("x_D1").item(0).getTextContent());
            pps.setX_D2(sickevoSoapResponse.getSOAPBody().getElementsByTagName("x_D2").item(0).getTextContent());
            pps.setX_D3(sickevoSoapResponse.getSOAPBody().getElementsByTagName("x_D3").item(0).getTextContent());
            pps.setX_E(sickevoSoapResponse.getSOAPBody().getElementsByTagName("x_E").item(0).getTextContent());
            pps.setV_A(sickevoSoapResponse.getSOAPBody().getElementsByTagName("v_A").item(0).getTextContent());
            pps.setV_B1(sickevoSoapResponse.getSOAPBody().getElementsByTagName("v_B1").item(0).getTextContent());
            pps.setV_B2(sickevoSoapResponse.getSOAPBody().getElementsByTagName("v_B2").item(0).getTextContent());
            pps.setV_B3(sickevoSoapResponse.getSOAPBody().getElementsByTagName("v_B3").item(0).getTextContent());
            pps.setV_C1(sickevoSoapResponse.getSOAPBody().getElementsByTagName("v_C1").item(0).getTextContent());
            pps.setV_C2(sickevoSoapResponse.getSOAPBody().getElementsByTagName("v_C2").item(0).getTextContent());
            pps.setV_D1(sickevoSoapResponse.getSOAPBody().getElementsByTagName("v_D1").item(0).getTextContent());
            pps.setV_D2(sickevoSoapResponse.getSOAPBody().getElementsByTagName("v_D2").item(0).getTextContent());
            pps.setV_D3(sickevoSoapResponse.getSOAPBody().getElementsByTagName("v_D3").item(0).getTextContent());
            pps.setV_E(sickevoSoapResponse.getSOAPBody().getElementsByTagName("v_E").item(0).getTextContent());

            return pps;
			} catch (Exception e) {
				e.printStackTrace();
			}		
		
	return null;
	}
	

}
