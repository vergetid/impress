//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.01 at 03:33:45 PM EET 
//


package oasis.names.tc.emergency.EDXL.DE._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <p>Java class for contentObjectType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contentObjectType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contentDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contentKeyword" type="{urn:oasis:names:tc:emergency:EDXL:DE:1.0}valueListType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="incidentID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="incidentDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="originatorRole" type="{urn:oasis:names:tc:emergency:EDXL:DE:1.0}valueListType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="consumerRole" type="{urn:oasis:names:tc:emergency:EDXL:DE:1.0}valueListType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="confidentiality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="nonXMLContent" type="{urn:oasis:names:tc:emergency:EDXL:DE:1.0}nonXMLContentType"/>
 *           &lt;element name="xmlContent" type="{urn:oasis:names:tc:emergency:EDXL:DE:1.0}xmlContentType"/>
 *         &lt;/choice>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contentObjectType", propOrder = {
    "contentDescription",
    "contentKeyword",
    "incidentID",
    "incidentDescription",
    "originatorRole",
    "consumerRole",
    "confidentiality",
    "nonXMLContent",
    "xmlContent",
    "any"
})
public class ContentObjectType {

    protected String contentDescription;
    protected List<ValueListType> contentKeyword;
    protected String incidentID;
    protected String incidentDescription;
    protected List<ValueListType> originatorRole;
    protected List<ValueListType> consumerRole;
    protected String confidentiality;
    protected NonXMLContentType nonXMLContent;
    protected XmlContentType xmlContent;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the contentDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentDescription() {
        return contentDescription;
    }

    /**
     * Sets the value of the contentDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentDescription(String value) {
        this.contentDescription = value;
    }

    /**
     * Gets the value of the contentKeyword property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contentKeyword property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContentKeyword().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValueListType }
     * 
     * 
     */
    public List<ValueListType> getContentKeyword() {
        if (contentKeyword == null) {
            contentKeyword = new ArrayList<ValueListType>();
        }
        return this.contentKeyword;
    }

    /**
     * Gets the value of the incidentID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncidentID() {
        return incidentID;
    }

    /**
     * Sets the value of the incidentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncidentID(String value) {
        this.incidentID = value;
    }

    /**
     * Gets the value of the incidentDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncidentDescription() {
        return incidentDescription;
    }

    /**
     * Sets the value of the incidentDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncidentDescription(String value) {
        this.incidentDescription = value;
    }

    /**
     * Gets the value of the originatorRole property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the originatorRole property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOriginatorRole().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValueListType }
     * 
     * 
     */
    public List<ValueListType> getOriginatorRole() {
        if (originatorRole == null) {
            originatorRole = new ArrayList<ValueListType>();
        }
        return this.originatorRole;
    }

    /**
     * Gets the value of the consumerRole property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consumerRole property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsumerRole().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValueListType }
     * 
     * 
     */
    public List<ValueListType> getConsumerRole() {
        if (consumerRole == null) {
            consumerRole = new ArrayList<ValueListType>();
        }
        return this.consumerRole;
    }

    /**
     * Gets the value of the confidentiality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfidentiality() {
        return confidentiality;
    }

    /**
     * Sets the value of the confidentiality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfidentiality(String value) {
        this.confidentiality = value;
    }

    /**
     * Gets the value of the nonXMLContent property.
     * 
     * @return
     *     possible object is
     *     {@link NonXMLContentType }
     *     
     */
    public NonXMLContentType getNonXMLContent() {
        return nonXMLContent;
    }

    /**
     * Sets the value of the nonXMLContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonXMLContentType }
     *     
     */
    public void setNonXMLContent(NonXMLContentType value) {
        this.nonXMLContent = value;
    }

    /**
     * Gets the value of the xmlContent property.
     * 
     * @return
     *     possible object is
     *     {@link XmlContentType }
     *     
     */
    public XmlContentType getXmlContent() {
        return xmlContent;
    }

    /**
     * Sets the value of the xmlContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlContentType }
     *     
     */
    public void setXmlContent(XmlContentType value) {
        this.xmlContent = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * {@link Element }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}
