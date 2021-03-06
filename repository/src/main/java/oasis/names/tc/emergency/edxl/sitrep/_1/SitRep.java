//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.15 at 12:31:13 PM EET 
//


package oasis.names.tc.emergency.edxl.sitrep._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import oasis.names.tc.emergency.edxl.ct._1.EDXLLocationType;
import oasis.names.tc.emergency.edxl.ct._1.PersonTimePairType;
import oasis.names.tc.emergency.edxl.ct._1.TimePeriodType;


/**
 * <p>Java class for SitRep complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SitRep">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageID" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLStringType"/>
 *         &lt;element name="PreparedBy" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}PersonTimePairType"/>
 *         &lt;element name="AuthorizedBy" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}PersonTimePairType"/>
 *         &lt;element name="ReportPurpose" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLStringType"/>
 *         &lt;element name="ReportNumber" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLStringType"/>
 *         &lt;element name="ReportVersion" type="{urn:oasis:names:tc:emergency:EDXL:SitRep:1.0}ReportVersionType"/>
 *         &lt;element name="ForTimePeriod" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}TimePeriodType"/>
 *         &lt;element name="ReportTitle" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLStringType" minOccurs="0"/>
 *         &lt;element name="IncidentID" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLStringType" maxOccurs="unbounded"/>
 *         &lt;element name="IncidentLifecyclePhase" type="{urn:oasis:names:tc:emergency:EDXL:SitRep:1.0}IncidentLifecycleType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OriginatingMessageID" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLStringType" minOccurs="0"/>
 *         &lt;element name="PrecedingMessageID" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLStringType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Urgency" type="{urn:oasis:names:tc:emergency:EDXL:SitRep:1.0}UrgencyType" minOccurs="0"/>
 *         &lt;element name="ReportConfidence" type="{urn:oasis:names:tc:emergency:EDXL:SitRep:1.0}ConfidenceType"/>
 *         &lt;element name="Severity" type="{urn:oasis:names:tc:emergency:EDXL:SitRep:1.0}SeverityType"/>
 *         &lt;element name="ReportingLocation" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLLocationType" minOccurs="0"/>
 *         &lt;element name="ActionPlan" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLStringType" minOccurs="0"/>
 *         &lt;element name="NextContact" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLDateTimeType" minOccurs="0"/>
 *         &lt;element name="Report" type="{urn:oasis:names:tc:emergency:EDXL:SitRep:1.0}IReport"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SitRep", propOrder = {
    "messageID",
    "preparedBy",
    "authorizedBy",
    "reportPurpose",
    "reportNumber",
    "reportVersion",
    "forTimePeriod",
    "reportTitle",
    "incidentID",
    "incidentLifecyclePhase",
    "originatingMessageID",
    "precedingMessageID",
    "urgency",
    "reportConfidence",
    "severity",
    "reportingLocation",
    "actionPlan",
    "nextContact",
    "report"
})

@XmlRootElement(name = "SitRep")
public class SitRep {

    @XmlElement(name = "MessageID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String messageID;
    @XmlElement(name = "PreparedBy", required = true)
    protected PersonTimePairType preparedBy;
    @XmlElement(name = "AuthorizedBy", required = true)
    protected PersonTimePairType authorizedBy;
    @XmlElement(name = "ReportPurpose", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String reportPurpose;
    @XmlElement(name = "ReportNumber", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String reportNumber;
    @XmlElement(name = "ReportVersion", required = true)
    protected ReportVersionType reportVersion;
    @XmlElement(name = "ForTimePeriod", required = true)
    protected TimePeriodType forTimePeriod;
    @XmlElement(name = "ReportTitle")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String reportTitle;
    @XmlElement(name = "IncidentID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected List<String> incidentID;
    @XmlElement(name = "IncidentLifecyclePhase")
    protected List<IncidentLifecycleType> incidentLifecyclePhase;
    @XmlElement(name = "OriginatingMessageID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String originatingMessageID;
    @XmlElement(name = "PrecedingMessageID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected List<String> precedingMessageID;
    @XmlElement(name = "Urgency")
    protected UrgencyType urgency;
    @XmlElement(name = "ReportConfidence", required = true)
    protected ConfidenceType reportConfidence;
    @XmlElement(name = "Severity", required = true)
    protected SeverityType severity;
    @XmlElement(name = "ReportingLocation")
    protected EDXLLocationType reportingLocation;
    @XmlElement(name = "ActionPlan")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String actionPlan;
    @XmlElement(name = "NextContact")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar nextContact;
    @XmlElement(name = "Report", required = true)
    protected IReport report;

    /**
     * Gets the value of the messageID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageID() {
        return messageID;
    }

    /**
     * Sets the value of the messageID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageID(String value) {
        this.messageID = value;
    }

    /**
     * Gets the value of the preparedBy property.
     * 
     * @return
     *     possible object is
     *     {@link PersonTimePairType }
     *     
     */
    public PersonTimePairType getPreparedBy() {
        return preparedBy;
    }

    /**
     * Sets the value of the preparedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonTimePairType }
     *     
     */
    public void setPreparedBy(PersonTimePairType value) {
        this.preparedBy = value;
    }

    /**
     * Gets the value of the authorizedBy property.
     * 
     * @return
     *     possible object is
     *     {@link PersonTimePairType }
     *     
     */
    public PersonTimePairType getAuthorizedBy() {
        return authorizedBy;
    }

    /**
     * Sets the value of the authorizedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonTimePairType }
     *     
     */
    public void setAuthorizedBy(PersonTimePairType value) {
        this.authorizedBy = value;
    }

    /**
     * Gets the value of the reportPurpose property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportPurpose() {
        return reportPurpose;
    }

    /**
     * Sets the value of the reportPurpose property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportPurpose(String value) {
        this.reportPurpose = value;
    }

    /**
     * Gets the value of the reportNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportNumber() {
        return reportNumber;
    }

    /**
     * Sets the value of the reportNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportNumber(String value) {
        this.reportNumber = value;
    }

    /**
     * Gets the value of the reportVersion property.
     * 
     * @return
     *     possible object is
     *     {@link ReportVersionType }
     *     
     */
    public ReportVersionType getReportVersion() {
        return reportVersion;
    }

    /**
     * Sets the value of the reportVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportVersionType }
     *     
     */
    public void setReportVersion(ReportVersionType value) {
        this.reportVersion = value;
    }

    /**
     * Gets the value of the forTimePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodType }
     *     
     */
    public TimePeriodType getForTimePeriod() {
        return forTimePeriod;
    }

    /**
     * Sets the value of the forTimePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodType }
     *     
     */
    public void setForTimePeriod(TimePeriodType value) {
        this.forTimePeriod = value;
    }

    /**
     * Gets the value of the reportTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportTitle() {
        return reportTitle;
    }

    /**
     * Sets the value of the reportTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportTitle(String value) {
        this.reportTitle = value;
    }

    /**
     * Gets the value of the incidentID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the incidentID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncidentID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIncidentID() {
        if (incidentID == null) {
            incidentID = new ArrayList<String>();
        }
        return this.incidentID;
    }

    /**
     * Gets the value of the incidentLifecyclePhase property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the incidentLifecyclePhase property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncidentLifecyclePhase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IncidentLifecycleType }
     * 
     * 
     */
    public List<IncidentLifecycleType> getIncidentLifecyclePhase() {
        if (incidentLifecyclePhase == null) {
            incidentLifecyclePhase = new ArrayList<IncidentLifecycleType>();
        }
        return this.incidentLifecyclePhase;
    }

    /**
     * Gets the value of the originatingMessageID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginatingMessageID() {
        return originatingMessageID;
    }

    /**
     * Sets the value of the originatingMessageID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginatingMessageID(String value) {
        this.originatingMessageID = value;
    }

    /**
     * Gets the value of the precedingMessageID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the precedingMessageID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrecedingMessageID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPrecedingMessageID() {
        if (precedingMessageID == null) {
            precedingMessageID = new ArrayList<String>();
        }
        return this.precedingMessageID;
    }

    /**
     * Gets the value of the urgency property.
     * 
     * @return
     *     possible object is
     *     {@link UrgencyType }
     *     
     */
    public UrgencyType getUrgency() {
        return urgency;
    }

    /**
     * Sets the value of the urgency property.
     * 
     * @param value
     *     allowed object is
     *     {@link UrgencyType }
     *     
     */
    public void setUrgency(UrgencyType value) {
        this.urgency = value;
    }

    /**
     * Gets the value of the reportConfidence property.
     * 
     * @return
     *     possible object is
     *     {@link ConfidenceType }
     *     
     */
    public ConfidenceType getReportConfidence() {
        return reportConfidence;
    }

    /**
     * Sets the value of the reportConfidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfidenceType }
     *     
     */
    public void setReportConfidence(ConfidenceType value) {
        this.reportConfidence = value;
    }

    /**
     * Gets the value of the severity property.
     * 
     * @return
     *     possible object is
     *     {@link SeverityType }
     *     
     */
    public SeverityType getSeverity() {
        return severity;
    }

    /**
     * Sets the value of the severity property.
     * 
     * @param value
     *     allowed object is
     *     {@link SeverityType }
     *     
     */
    public void setSeverity(SeverityType value) {
        this.severity = value;
    }

    /**
     * Gets the value of the reportingLocation property.
     * 
     * @return
     *     possible object is
     *     {@link EDXLLocationType }
     *     
     */
    public EDXLLocationType getReportingLocation() {
        return reportingLocation;
    }

    /**
     * Sets the value of the reportingLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link EDXLLocationType }
     *     
     */
    public void setReportingLocation(EDXLLocationType value) {
        this.reportingLocation = value;
    }

    /**
     * Gets the value of the actionPlan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionPlan() {
        return actionPlan;
    }

    /**
     * Sets the value of the actionPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionPlan(String value) {
        this.actionPlan = value;
    }

    /**
     * Gets the value of the nextContact property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNextContact() {
        return nextContact;
    }

    /**
     * Sets the value of the nextContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNextContact(XMLGregorianCalendar value) {
        this.nextContact = value;
    }

    /**
     * Gets the value of the report property.
     * 
     * @return
     *     possible object is
     *     {@link IReport }
     *     
     */
    public IReport getReport() {
        return report;
    }

    /**
     * Sets the value of the report property.
     * 
     * @param value
     *     allowed object is
     *     {@link IReport }
     *     
     */
    public void setReport(IReport value) {
        this.report = value;
    }

}
