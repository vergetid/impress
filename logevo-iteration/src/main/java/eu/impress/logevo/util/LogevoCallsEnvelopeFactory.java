package eu.impress.logevo.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import eu.impress.logevo.model.PPS;

public class LogevoCallsEnvelopeFactory {
	
	public static SOAPMessage createResOverviewFullRequest(List<String> nuggets) throws SOAPException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://150.146.5.15/webservices/IMPRESS2/services.php";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("imp", "http://150.146.5.15/webservices/IMPRESS2/");        
        SOAPBody soapBody = envelope.getBody();	
        
        SOAPElement soapBodyElem = soapBody.addChildElement("resoverreq", "imp");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("nugget_list");
        for (String nugget : nuggets) {
        	soapBodyElem1.addChildElement("nugget").addTextNode(nugget);
        }


        
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI);

        soapMessage.saveChanges();
        
        try {
        	System.out.println("LogevoCallsEnvelopeFactory.createResOverviewFullRequest:\n");
        	soapMessage.writeTo(System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return soapMessage;
		
	}	
	
	public static SOAPMessage createSickevoFullRequest(String nugget, String asset_id, String deltaT) throws SOAPException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://150.146.5.15/webservices/IMPRESS2/services.php";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("imp", "http://150.146.5.15/webservices/IMPRESS2/");        
        SOAPBody soapBody = envelope.getBody();	
        
        SOAPElement soapBodyElem = soapBody.addChildElement("sickfullreq", "imp");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("nugget");
        soapBodyElem1.addTextNode(nugget);
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("asset_id");
        soapBodyElem2.addTextNode(asset_id);
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("delta_t");
        soapBodyElem3.addTextNode(deltaT);
        
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI);

        soapMessage.saveChanges();
        
        try {
        	System.out.println("LogevoCallsEnvelopeFactory.createSickevoFullRequest:\n");
        	soapMessage.writeTo(System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return soapMessage;
		
	}
	
	public static SOAPMessage createStatscoringRequest(PPS pps) throws SOAPException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://150.146.5.15/webservices/IMPRESS2/services.php";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("imp", "http://150.146.5.15/webservices/IMPRESS2/");        
        SOAPBody soapBody = envelope.getBody();	
        
        SOAPElement soapBodyElem = soapBody.addChildElement("statScoringParameters", "imp");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("pop_status");
        SOAPElement soapBodyElem2 = soapBodyElem1.addChildElement("patient_status");
        
        
        SOAPElement elemxA = soapBodyElem2.addChildElement("x_A");
        elemxA.addTextNode(pps.getX_A());
        SOAPElement elemxB1 = soapBodyElem2.addChildElement("x_B1");
        elemxB1.addTextNode(pps.getX_B1());
        SOAPElement elemxB2 = soapBodyElem2.addChildElement("x_B2");
        elemxB2.addTextNode(pps.getX_B2());
        SOAPElement elemxB3 = soapBodyElem2.addChildElement("x_B3");
        elemxB3.addTextNode(pps.getX_B3());
        SOAPElement elemxC1 = soapBodyElem2.addChildElement("x_C1");
        elemxC1.addTextNode(pps.getX_C1());
        SOAPElement elemxC2 = soapBodyElem2.addChildElement("x_C2");
        elemxC2.addTextNode(pps.getX_C2());
        SOAPElement elemxD1 = soapBodyElem2.addChildElement("x_D1");
        elemxD1.addTextNode(pps.getX_D1());
        SOAPElement elemxD2 = soapBodyElem2.addChildElement("x_D2");
        elemxD2.addTextNode(pps.getX_D2());
        SOAPElement elemxD3 = soapBodyElem2.addChildElement("x_D3");
        elemxD3.addTextNode(pps.getX_D3());
        SOAPElement elexE = soapBodyElem2.addChildElement("x_E");
        elexE.addTextNode(pps.getX_E());        
        SOAPElement elemvA = soapBodyElem2.addChildElement("v_A");
        elemvA.addTextNode(pps.getV_A());
        SOAPElement elemvB1 = soapBodyElem2.addChildElement("v_B1");
        elemvB1.addTextNode(pps.getV_B1());  
        SOAPElement elemvB2 = soapBodyElem2.addChildElement("v_B2");
        elemvB2.addTextNode(pps.getV_B2());
        SOAPElement elemvB3 = soapBodyElem2.addChildElement("v_B3");
        elemvB3.addTextNode(pps.getV_B3());
        SOAPElement elemvC1 = soapBodyElem2.addChildElement("v_C1");
        elemvC1.addTextNode(pps.getV_C1());
        SOAPElement elemvC2 = soapBodyElem2.addChildElement("v_C2");
        elemvC2.addTextNode(pps.getV_C2());
        SOAPElement elemvD1 = soapBodyElem2.addChildElement("v_D1");
        elemvD1.addTextNode(pps.getV_D1());
        SOAPElement elemvD2 = soapBodyElem2.addChildElement("v_D2");
        elemvD2.addTextNode(pps.getV_D2());
        SOAPElement elemvD3 = soapBodyElem2.addChildElement("v_D3");
        elemvD3.addTextNode(pps.getV_D3());
        SOAPElement elemvE = soapBodyElem2.addChildElement("v_E");
        elemvE.addTextNode(pps.getV_E());        
        
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI);

        soapMessage.saveChanges();
        
        try {
        	System.out.println("LogevoCallsEnvelopeFactory.createStatscoringRequest:\n");
        	soapMessage.writeTo(System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return soapMessage;
		
	}	
	public static SOAPMessage createExposePPSRequest(String nugget) throws SOAPException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://150.146.5.15/webservices/IMPRESS2/services.php";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("imp", "http://150.146.5.15/webservices/IMPRESS2/");        
        SOAPBody soapBody = envelope.getBody();	
        
        SOAPElement soapBodyElem = soapBody.addChildElement("expppsreq", "imp");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("nugget");
        soapBodyElem1.addTextNode(nugget);
        
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI);

        soapMessage.saveChanges();
        
        try {
        	System.out.println("LogevoCallsEnvelopeFactory.createExposePPSrequest:\n");
        	soapMessage.writeTo(System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return soapMessage;
		
	}	
	
	public static SOAPMessage createGaugerFullrequest(String nugget, int symptomId, int value) throws SOAPException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://150.146.5.15/webservices/IMPRESS2/services.php";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("imp", "http://150.146.5.15/webservices/IMPRESS2/");        
        SOAPBody soapBody = envelope.getBody();	
        
        SOAPElement soapBodyElem = soapBody.addChildElement("gaugfullreq", "imp");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("nugget");
        soapBodyElem1.addTextNode(nugget);
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("symptom_id");
        soapBodyElem2.addTextNode(Integer.toString(symptomId));
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("symptom_val");
        soapBodyElem3.addTextNode(Integer.toString(value));
        
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI);

        soapMessage.saveChanges();
        
        try {
        	System.out.println("LogevoCallsEnvelopeFactory.createGaugerFullrequest:\n");
        	soapMessage.writeTo(System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return soapMessage;
		
	}	
	public static SOAPMessage createAprioriGenfullRequest(String event_type) throws SOAPException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://150.146.5.15/webservices/IMPRESS2/services.php";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("imp", "http://150.146.5.15/webservices/IMPRESS2/");        
        SOAPBody soapBody = envelope.getBody();
        
        SOAPElement soapBodyElem = soapBody.addChildElement("AprioriGenFullParameters", "imp");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("longitudinal_deviation");
        soapBodyElem1.addTextNode("20");
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("latitudinal_deviation");
        soapBodyElem2.addTextNode("30");
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("event_type");
        soapBodyElem3.addTextNode(event_type);
        
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI);

        soapMessage.saveChanges();
        
        try {
        	System.out.println("LogevoCallsEnvelopeFactory.createAprioriGenfullRequest:\n");
        	soapMessage.writeTo(System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return soapMessage;
	}
    public static void printSOAPResponse(SOAPMessage soapResponse) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        System.out.print("\nResponse SOAP Message = ");
        StreamResult result = new StreamResult(System.out);
        transformer.transform(sourceContent, result);
    }	   
}
