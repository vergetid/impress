package eu.impress.repository.util.incicrowd;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by jim on 24/1/2017.
 */
public class CapParsingUtil {
    public static String getIncidentId(String capMesg) throws ParserConfigurationException, SAXException, IOException {
        Document doc = createXmlDocument(capMesg);
        NodeList nList = doc.getElementsByTagName("identifier");

        System.out.println("CAP Alert Incident ID: " + nList.item(0).getTextContent());

        return nList.item(0).getTextContent();
        //return "3";
    }
    public static String getHeader(String capMesg) throws ParserConfigurationException, SAXException, IOException {
        Document doc = createXmlDocument(capMesg);
        NodeList nList = doc.getElementsByTagName("info");
        Node nNode = nList.item(0);
        Element eElement = (Element) nNode;
        System.out.println("CAP Alert Headline: " + eElement.getElementsByTagName("headline").item(0).getTextContent());

        return eElement.getElementsByTagName("headline").item(0).getTextContent();
    }
    public static String getSender(String capMesg) throws ParserConfigurationException, SAXException, IOException {
        Document doc = createXmlDocument(capMesg);
        NodeList nList = doc.getElementsByTagName("info");
        Node nNode = nList.item(0);
        Element eElement = (Element) nNode;
        System.out.println("CAP Alert Sender: " + eElement.getElementsByTagName("senderName").item(0).getTextContent());

        return eElement.getElementsByTagName("senderName").item(0).getTextContent();
    }
    public static String getDescription(String capMesg) throws ParserConfigurationException, SAXException, IOException {
        Document doc = createXmlDocument(capMesg);
        NodeList nList = doc.getElementsByTagName("info");
        Node nNode = nList.item(0);
        Element eElement = (Element) nNode;
        System.out.println("CAP Alert Description: " + eElement.getElementsByTagName("description").item(0).getTextContent());

        return eElement.getElementsByTagName("description").item(0).getTextContent();
    }
    public static String getArea(String capMesg) throws ParserConfigurationException, SAXException, IOException {
        Document doc = createXmlDocument(capMesg);
        NodeList nList = doc.getElementsByTagName("info");
        Node nNode = nList.item(0);
        NodeList areaAnodeList = ((Element) nNode).getElementsByTagName("area");
        Node areaNode = areaAnodeList.item(0);
        Element pElement = (Element) areaNode;
        System.out.println("CAP Alert area: " + pElement.getElementsByTagName("polygon").item(0).getTextContent());

        return "<polygon>" + pElement.getElementsByTagName("polygon").item(0).getTextContent() + "</polygon>";
    }
    private static Document createXmlDocument(String xmlSource) throws ParserConfigurationException, UnsupportedEncodingException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setNamespaceAware(true);
        DocumentBuilder dBuilder;
        Document doc;
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(xmlSource.getBytes("utf-8"))));

        doc.getDocumentElement().normalize();
        return doc;
    }
}
