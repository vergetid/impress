package eu.impress.logevo.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class TepParsingUtil {
	public static String getEventType(String tepMsgEnvelopeStr) throws ParserConfigurationException, SAXException, IOException {
		String tepMsgStr = decapsulateTEP(tepMsgEnvelopeStr);
		Document doc = createXmlDocument(tepMsgStr);
		NodeList nList = doc.getElementsByTagName("incidentID");
		Node nNode = nList.item(0);
		Element eElement = (Element) nNode;
		System.out.println("TEP UTIL getEventType: Incident ID: " + eElement.getElementsByTagName("ID").item(0).getTextContent());

		return eElement.getElementsByTagName("ID").item(0).getTextContent();
	}
	
	public static String decapsulateTEP(String tepMsgEnvelopeStr) throws ParserConfigurationException, UnsupportedEncodingException, SAXException, IOException {
		Document doc = createXmlDocument(tepMsgEnvelopeStr);
		
		NodeList nList = doc.getElementsByTagName("any");
		Node nNode = nList.item(0);
		return nNode.getTextContent();
	}
	
	public static String getSentAndIncidentTimeDiff(String tepMsgEnvelopeStr) throws UnsupportedEncodingException, ParserConfigurationException, SAXException, IOException, ParseException {
		
		Document doc = createXmlDocument(tepMsgEnvelopeStr);
		NodeList nList = doc.getElementsByTagName("dateTimeSent");
		String dateSent = nList.item(0).getTextContent();
		System.out.println("TepParsingUtil: getTimeDiff: TEP Sent time: " + nList.item(0).getTextContent());
		
		String tepMsgStr = decapsulateTEP(tepMsgEnvelopeStr);
		doc = createXmlDocument(tepMsgStr);		
		nList = doc.getElementsByTagName("incidentStartDateTime");
		String dateIncident = nList.item(0).getTextContent();
		System.out.println("TepParsingUtil: getTimeDiff: Incident Sent time: " + nList.item(0).getTextContent());
		
		try {
			XMLGregorianCalendar dateSentGc = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateSent);
			XMLGregorianCalendar dateIncidentGc = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateIncident);
			System.out.println("TepParsingUtil: getTimeDiff: parsed Sent Datetime: " + dateSentGc);
			System.out.println("TepParsingUtil: getTimeDiff: parsed Incident Datetime: " + dateIncidentGc);
			Long timeDiff = dateSentGc.toGregorianCalendar().getTimeInMillis() - 
					dateIncidentGc.toGregorianCalendar().getTimeInMillis();
			System.out.println("TepParsingUtil: getTimeDiff: Diff computed in Millis: " + timeDiff);
			Double timeDiffIHours = 2.77777778*timeDiff.floatValue()*1e-7;
			System.out.println("TepParsingUtil: getTimeDiff: Diff computed in Hours: " + timeDiffIHours);
			return timeDiffIHours.toString();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
				
		return "";
	
	}
	public static String getPatientId(String tepMsgEnvelopeStr) throws UnsupportedEncodingException, ParserConfigurationException, SAXException, IOException {
		String tepMsgStr = decapsulateTEP(tepMsgEnvelopeStr);
		Document doc = createXmlDocument(tepMsgStr);
		NodeList nList = doc.getElementsByTagName("patientID");
		Node nNode = nList.item(0);
		Element eElement = (Element) nNode;
		System.out.println("TEP UTIL getPatientCode: Patient ID: " + eElement.getElementsByTagName("ID").item(0).getTextContent());		
		return eElement.getElementsByTagName("ID").item(0).getTextContent();
	}
	
	private static Document createXmlDocument(String xmlSource) throws ParserConfigurationException, UnsupportedEncodingException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		Document doc;
		dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(xmlSource.getBytes("utf-8"))));	
		
		doc.getDocumentElement().normalize();	
		return doc;
	}
}
