package eu.impress.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
