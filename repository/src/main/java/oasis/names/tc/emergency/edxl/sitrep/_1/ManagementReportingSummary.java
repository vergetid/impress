//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.15 at 12:31:13 PM EET 
//


package oasis.names.tc.emergency.edxl.sitrep._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ManagementReportingSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ManagementReportingSummary">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oasis:names:tc:emergency:EDXL:SitRep:1.0}IReport">
 *       &lt;sequence>
 *         &lt;element name="SituationSummary" type="{urn:oasis:names:tc:emergency:EDXL:SitRep:1.0}SituationSummary" minOccurs="0"/>
 *         &lt;element name="DecisionSupportInformation" type="{urn:oasis:names:tc:emergency:EDXL:SitRep:1.0}IncidentDecisionSupportInformation" minOccurs="0"/>
 *         &lt;element name="JurisdictionInformation" type="{urn:oasis:names:tc:emergency:EDXL:SitRep:1.0}Jurisdiction" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManagementReportingSummary", propOrder = {
    "situationSummary",
    "decisionSupportInformation",
    "jurisdictionInformation"
})
public class ManagementReportingSummary
    extends IReport
{

    @XmlElement(name = "SituationSummary")
    protected SituationSummary situationSummary;
    @XmlElement(name = "DecisionSupportInformation")
    protected IncidentDecisionSupportInformation decisionSupportInformation;
    @XmlElement(name = "JurisdictionInformation")
    protected List<Jurisdiction> jurisdictionInformation;

    /**
     * Gets the value of the situationSummary property.
     * 
     * @return
     *     possible object is
     *     {@link SituationSummary }
     *     
     */
    public SituationSummary getSituationSummary() {
        return situationSummary;
    }

    /**
     * Sets the value of the situationSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link SituationSummary }
     *     
     */
    public void setSituationSummary(SituationSummary value) {
        this.situationSummary = value;
    }

    /**
     * Gets the value of the decisionSupportInformation property.
     * 
     * @return
     *     possible object is
     *     {@link IncidentDecisionSupportInformation }
     *     
     */
    public IncidentDecisionSupportInformation getDecisionSupportInformation() {
        return decisionSupportInformation;
    }

    /**
     * Sets the value of the decisionSupportInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncidentDecisionSupportInformation }
     *     
     */
    public void setDecisionSupportInformation(IncidentDecisionSupportInformation value) {
        this.decisionSupportInformation = value;
    }

    /**
     * Gets the value of the jurisdictionInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jurisdictionInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJurisdictionInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Jurisdiction }
     * 
     * 
     */
    public List<Jurisdiction> getJurisdictionInformation() {
        if (jurisdictionInformation == null) {
            jurisdictionInformation = new ArrayList<Jurisdiction>();
        }
        return this.jurisdictionInformation;
    }

}
