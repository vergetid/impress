//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.23 at 05:44:00 PM EET 
//


package oasis.names.tc.emergency.edxl.have._1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The container of all of the elements related to the status of the facility.  
 * 
 * <p>Java class for HospitalFacilityStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HospitalFacilityStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HospitalEOCStatus" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Active"/>
 *               &lt;enumeration value="Inactive"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HospitalEOCPlan" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Active"/>
 *               &lt;enumeration value="Inactive"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ClinicalStatus" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Normal"/>
 *               &lt;enumeration value="Full"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DeconCapacity" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DeconCapacityStatus" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="Inactive"/>
 *                         &lt;enumeration value="Open"/>
 *                         &lt;enumeration value="Full"/>
 *                         &lt;enumeration value="Exceeded"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="AmbulatoryPatientsDeconCapacity" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                   &lt;element name="NonAmbulatoryPatientsDeconCapacity" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="MorgueCapacity" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="MorgueCapacityStatus" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="Open"/>
 *                         &lt;enumeration value="Full"/>
 *                         &lt;enumeration value="Exceeded"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="MorgueCapacityUnits" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="FacilityStatus" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Normal"/>
 *               &lt;enumeration value="Compromised"/>
 *               &lt;enumeration value="Evacuating"/>
 *               &lt;enumeration value="Closed"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SecurityStatus" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Normal"/>
 *               &lt;enumeration value="Elevated"/>
 *               &lt;enumeration value="RestrictedAccess"/>
 *               &lt;enumeration value="Lockdown"/>
 *               &lt;enumeration value="Quarantine"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Activity24Hr" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Admissions" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                   &lt;element name="Discharges" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                   &lt;element name="Deaths" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{urn:oasis:names:tc:emergency:EDXL:HAVE:1.0}CommentText" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HospitalFacilityStatus", propOrder = {
    "hospitalEOCStatus",
    "hospitalEOCPlan",
    "clinicalStatus",
    "deconCapacity",
    "morgueCapacity",
    "facilityStatus",
    "securityStatus",
    "activity24Hr",
    "commentText"
})
public class HospitalFacilityStatus {

    @XmlElement(name = "HospitalEOCStatus", defaultValue = "Inactive")
    protected String hospitalEOCStatus;
    @XmlElement(name = "HospitalEOCPlan")
    protected String hospitalEOCPlan;
    @XmlElement(name = "ClinicalStatus")
    protected String clinicalStatus;
    @XmlElement(name = "DeconCapacity")
    protected HospitalFacilityStatus.DeconCapacity deconCapacity;
    @XmlElement(name = "MorgueCapacity")
    protected HospitalFacilityStatus.MorgueCapacity morgueCapacity;
    @XmlElement(name = "FacilityStatus")
    protected String facilityStatus;
    @XmlElement(name = "SecurityStatus")
    protected String securityStatus;
    @XmlElement(name = "Activity24Hr")
    protected HospitalFacilityStatus.Activity24Hr activity24Hr;
    @XmlElement(name = "CommentText")
    protected List<String> commentText;

    /**
     * Gets the value of the hospitalEOCStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHospitalEOCStatus() {
        return hospitalEOCStatus;
    }

    /**
     * Sets the value of the hospitalEOCStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHospitalEOCStatus(String value) {
        this.hospitalEOCStatus = value;
    }

    /**
     * Gets the value of the hospitalEOCPlan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHospitalEOCPlan() {
        return hospitalEOCPlan;
    }

    /**
     * Sets the value of the hospitalEOCPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHospitalEOCPlan(String value) {
        this.hospitalEOCPlan = value;
    }

    /**
     * Gets the value of the clinicalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClinicalStatus() {
        return clinicalStatus;
    }

    /**
     * Sets the value of the clinicalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClinicalStatus(String value) {
        this.clinicalStatus = value;
    }

    /**
     * Gets the value of the deconCapacity property.
     * 
     * @return
     *     possible object is
     *     {@link HospitalFacilityStatus.DeconCapacity }
     *     
     */
    public HospitalFacilityStatus.DeconCapacity getDeconCapacity() {
        return deconCapacity;
    }

    /**
     * Sets the value of the deconCapacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link HospitalFacilityStatus.DeconCapacity }
     *     
     */
    public void setDeconCapacity(HospitalFacilityStatus.DeconCapacity value) {
        this.deconCapacity = value;
    }

    /**
     * Gets the value of the morgueCapacity property.
     * 
     * @return
     *     possible object is
     *     {@link HospitalFacilityStatus.MorgueCapacity }
     *     
     */
    public HospitalFacilityStatus.MorgueCapacity getMorgueCapacity() {
        return morgueCapacity;
    }

    /**
     * Sets the value of the morgueCapacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link HospitalFacilityStatus.MorgueCapacity }
     *     
     */
    public void setMorgueCapacity(HospitalFacilityStatus.MorgueCapacity value) {
        this.morgueCapacity = value;
    }

    /**
     * Gets the value of the facilityStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityStatus() {
        return facilityStatus;
    }

    /**
     * Sets the value of the facilityStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityStatus(String value) {
        this.facilityStatus = value;
    }

    /**
     * Gets the value of the securityStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecurityStatus() {
        return securityStatus;
    }

    /**
     * Sets the value of the securityStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecurityStatus(String value) {
        this.securityStatus = value;
    }

    /**
     * Gets the value of the activity24Hr property.
     * 
     * @return
     *     possible object is
     *     {@link HospitalFacilityStatus.Activity24Hr }
     *     
     */
    public HospitalFacilityStatus.Activity24Hr getActivity24Hr() {
        return activity24Hr;
    }

    /**
     * Sets the value of the activity24Hr property.
     * 
     * @param value
     *     allowed object is
     *     {@link HospitalFacilityStatus.Activity24Hr }
     *     
     */
    public void setActivity24Hr(HospitalFacilityStatus.Activity24Hr value) {
        this.activity24Hr = value;
    }

    /**
     * Gets the value of the commentText property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commentText property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommentText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCommentText() {
        if (commentText == null) {
            commentText = new ArrayList<String>();
        }
        return this.commentText;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Admissions" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *         &lt;element name="Discharges" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *         &lt;element name="Deaths" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "admissions",
        "discharges",
        "deaths"
    })
    public static class Activity24Hr {

        @XmlElement(name = "Admissions")
        protected Object admissions;
        @XmlElement(name = "Discharges")
        protected Object discharges;
        @XmlElement(name = "Deaths")
        protected Object deaths;

        /**
         * Gets the value of the admissions property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getAdmissions() {
            return admissions;
        }

        /**
         * Sets the value of the admissions property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setAdmissions(Object value) {
            this.admissions = value;
        }

        /**
         * Gets the value of the discharges property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getDischarges() {
            return discharges;
        }

        /**
         * Sets the value of the discharges property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setDischarges(Object value) {
            this.discharges = value;
        }

        /**
         * Gets the value of the deaths property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getDeaths() {
            return deaths;
        }

        /**
         * Sets the value of the deaths property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setDeaths(Object value) {
            this.deaths = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DeconCapacityStatus" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="Inactive"/>
     *               &lt;enumeration value="Open"/>
     *               &lt;enumeration value="Full"/>
     *               &lt;enumeration value="Exceeded"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="AmbulatoryPatientsDeconCapacity" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *         &lt;element name="NonAmbulatoryPatientsDeconCapacity" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "deconCapacityStatus",
        "ambulatoryPatientsDeconCapacity",
        "nonAmbulatoryPatientsDeconCapacity"
    })
    public static class DeconCapacity {

        @XmlElement(name = "DeconCapacityStatus")
        protected String deconCapacityStatus;
        @XmlElement(name = "AmbulatoryPatientsDeconCapacity")
        protected Object ambulatoryPatientsDeconCapacity;
        @XmlElement(name = "NonAmbulatoryPatientsDeconCapacity")
        protected Object nonAmbulatoryPatientsDeconCapacity;

        /**
         * Gets the value of the deconCapacityStatus property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDeconCapacityStatus() {
            return deconCapacityStatus;
        }

        /**
         * Sets the value of the deconCapacityStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDeconCapacityStatus(String value) {
            this.deconCapacityStatus = value;
        }

        /**
         * Gets the value of the ambulatoryPatientsDeconCapacity property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getAmbulatoryPatientsDeconCapacity() {
            return ambulatoryPatientsDeconCapacity;
        }

        /**
         * Sets the value of the ambulatoryPatientsDeconCapacity property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setAmbulatoryPatientsDeconCapacity(Object value) {
            this.ambulatoryPatientsDeconCapacity = value;
        }

        /**
         * Gets the value of the nonAmbulatoryPatientsDeconCapacity property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getNonAmbulatoryPatientsDeconCapacity() {
            return nonAmbulatoryPatientsDeconCapacity;
        }

        /**
         * Sets the value of the nonAmbulatoryPatientsDeconCapacity property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setNonAmbulatoryPatientsDeconCapacity(Object value) {
            this.nonAmbulatoryPatientsDeconCapacity = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="MorgueCapacityStatus" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="Open"/>
     *               &lt;enumeration value="Full"/>
     *               &lt;enumeration value="Exceeded"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="MorgueCapacityUnits" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "morgueCapacityStatus",
        "morgueCapacityUnits"
    })
    public static class MorgueCapacity {

        @XmlElement(name = "MorgueCapacityStatus")
        protected String morgueCapacityStatus;
        @XmlElement(name = "MorgueCapacityUnits")
        protected BigInteger morgueCapacityUnits;

        /**
         * Gets the value of the morgueCapacityStatus property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMorgueCapacityStatus() {
            return morgueCapacityStatus;
        }

        /**
         * Sets the value of the morgueCapacityStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMorgueCapacityStatus(String value) {
            this.morgueCapacityStatus = value;
        }

        /**
         * Gets the value of the morgueCapacityUnits property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getMorgueCapacityUnits() {
            return morgueCapacityUnits;
        }

        /**
         * Sets the value of the morgueCapacityUnits property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setMorgueCapacityUnits(BigInteger value) {
            this.morgueCapacityUnits = value;
        }

    }

}
