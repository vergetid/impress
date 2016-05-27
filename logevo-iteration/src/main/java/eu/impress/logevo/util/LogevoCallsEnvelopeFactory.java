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

public class LogevoCallsEnvelopeFactory {
	
	public static SOAPMessage createResOverviewFullRequest(List<String> nuggets) throws SOAPException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://biomat1.iasi.cnr.it/webservices/IMPRESS/services.php";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("imp", "http://biomat1.iasi.cnr.it/webservices/IMPRESS/");        
        SOAPBody soapBody = envelope.getBody();	
        
        SOAPElement soapBodyElem = soapBody.addChildElement("resoverreq", "imp");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("nugget_list");
        for (String nugget : nuggets) {
        	soapBodyElem1.addChildElement("nugget").addTextNode(nugget);
        }


        
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI);

        soapMessage.saveChanges();
        
        /*try {
        	soapMessage.writeTo(System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        
        return soapMessage;
		
	}	
	
	public static SOAPMessage createSickevoFullRequest(String nugget, String asset_id, String deltaT) throws SOAPException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://biomat1.iasi.cnr.it/webservices/IMPRESS/services.php";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("imp", "http://biomat1.iasi.cnr.it/webservices/IMPRESS/");        
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
        
        /*try {
        	soapMessage.writeTo(System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        
        return soapMessage;
		
	}
	public static SOAPMessage createGaugerFullrequest(String nugget, int symptomId, int value) throws SOAPException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://biomat1.iasi.cnr.it/webservices/IMPRESS/services.php";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("imp", "http://biomat1.iasi.cnr.it/webservices/IMPRESS/");        
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
        
        /*try {
        	soapMessage.writeTo(System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        
        return soapMessage;
		
	}	
	public static SOAPMessage createAprioriGenfullRequest(String event_type) throws SOAPException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://biomat1.iasi.cnr.it/webservices/IMPRESS/services.php";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("imp", "http://biomat1.iasi.cnr.it/webservices/IMPRESS/");        
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
        
        /*try {
        	soapMessage.writeTo(System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

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
