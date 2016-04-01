//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.01 at 06:03:54 PM EEST 
//


package oasis.names.tc.emergency.EDXL.TEP._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for METARType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="METARType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StationID">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[A-Z]{4}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ObservationTime" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLDateTimeType"/>
 *         &lt;element name="TempC" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}DegreesCType" minOccurs="0"/>
 *         &lt;element name="DewpointC" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}DegreesCType" minOccurs="0"/>
 *         &lt;element name="WindDirDegrees" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}DegreesCircleType" minOccurs="0"/>
 *         &lt;element name="WindSpeedkt" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="300"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WindGustkt" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="300"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="VisibilityStatuteMI" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}float">
 *               &lt;minInclusive value="0.0"/>
 *               &lt;maxInclusive value="10.0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AltimeterHP" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="800"/>
 *               &lt;maxInclusive value="1200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SeaLevelPressuremb" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="800"/>
 *               &lt;maxInclusive value="1200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WeatherPhenomenaReport" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Qualifier" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}WeatherQualifierType" minOccurs="0"/>
 *                   &lt;element name="Descriptor" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}WeatherDescriptorType" minOccurs="0"/>
 *                   &lt;element name="Precipitation" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}WeatherPrecipitationType" minOccurs="0"/>
 *                   &lt;element name="Obscuration" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}WeatherObscurationType" minOccurs="0"/>
 *                   &lt;element name="Additional" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}WeatherAddlPhenomType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SkyCondition" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}SkyConditionType" minOccurs="0"/>
 *         &lt;element name="Precip1HrIn" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}float">
 *               &lt;pattern value="[0-9][0-9].[0-9][0-9]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Precip3HrIn" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}float">
 *               &lt;pattern value="[0-9][0-9].[0-9][0-9]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Precip6HrIn" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}float">
 *               &lt;pattern value="[0-9][0-9].[0-9][0-9]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Precip24HrIn" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}float">
 *               &lt;pattern value="[0-9][0-9].[0-9][0-9]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "METARType", namespace = "urn:oasis:names:tc:emergency:edxl:ct:1.0", propOrder = {
    "stationID",
    "observationTime",
    "tempC",
    "dewpointC",
    "windDirDegrees",
    "windSpeedkt",
    "windGustkt",
    "visibilityStatuteMI",
    "altimeterHP",
    "seaLevelPressuremb",
    "weatherPhenomenaReport",
    "skyCondition",
    "precip1HrIn",
    "precip3HrIn",
    "precip6HrIn",
    "precip24HrIn"
})
public class METARType {

    @XmlElement(name = "StationID", required = true)
    protected String stationID;
    @XmlElement(name = "ObservationTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar observationTime;
    @XmlElement(name = "TempC")
    protected Float tempC;
    @XmlElement(name = "DewpointC")
    protected Float dewpointC;
    @XmlElement(name = "WindDirDegrees")
    protected Float windDirDegrees;
    @XmlElement(name = "WindSpeedkt")
    protected Integer windSpeedkt;
    @XmlElement(name = "WindGustkt")
    protected Integer windGustkt;
    @XmlElement(name = "VisibilityStatuteMI")
    protected Float visibilityStatuteMI;
    @XmlElement(name = "AltimeterHP")
    protected Integer altimeterHP;
    @XmlElement(name = "SeaLevelPressuremb")
    protected Integer seaLevelPressuremb;
    @XmlElement(name = "WeatherPhenomenaReport")
    protected METARType.WeatherPhenomenaReport weatherPhenomenaReport;
    @XmlElement(name = "SkyCondition")
    @XmlSchemaType(name = "string")
    protected SkyConditionType skyCondition;
    @XmlElement(name = "Precip1HrIn")
    protected Float precip1HrIn;
    @XmlElement(name = "Precip3HrIn")
    protected Float precip3HrIn;
    @XmlElement(name = "Precip6HrIn")
    protected Float precip6HrIn;
    @XmlElement(name = "Precip24HrIn")
    protected Float precip24HrIn;

    /**
     * Gets the value of the stationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStationID() {
        return stationID;
    }

    /**
     * Sets the value of the stationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStationID(String value) {
        this.stationID = value;
    }

    /**
     * Gets the value of the observationTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getObservationTime() {
        return observationTime;
    }

    /**
     * Sets the value of the observationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setObservationTime(XMLGregorianCalendar value) {
        this.observationTime = value;
    }

    /**
     * Gets the value of the tempC property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTempC() {
        return tempC;
    }

    /**
     * Sets the value of the tempC property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTempC(Float value) {
        this.tempC = value;
    }

    /**
     * Gets the value of the dewpointC property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getDewpointC() {
        return dewpointC;
    }

    /**
     * Sets the value of the dewpointC property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setDewpointC(Float value) {
        this.dewpointC = value;
    }

    /**
     * Gets the value of the windDirDegrees property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getWindDirDegrees() {
        return windDirDegrees;
    }

    /**
     * Sets the value of the windDirDegrees property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setWindDirDegrees(Float value) {
        this.windDirDegrees = value;
    }

    /**
     * Gets the value of the windSpeedkt property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWindSpeedkt() {
        return windSpeedkt;
    }

    /**
     * Sets the value of the windSpeedkt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWindSpeedkt(Integer value) {
        this.windSpeedkt = value;
    }

    /**
     * Gets the value of the windGustkt property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWindGustkt() {
        return windGustkt;
    }

    /**
     * Sets the value of the windGustkt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWindGustkt(Integer value) {
        this.windGustkt = value;
    }

    /**
     * Gets the value of the visibilityStatuteMI property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getVisibilityStatuteMI() {
        return visibilityStatuteMI;
    }

    /**
     * Sets the value of the visibilityStatuteMI property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setVisibilityStatuteMI(Float value) {
        this.visibilityStatuteMI = value;
    }

    /**
     * Gets the value of the altimeterHP property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAltimeterHP() {
        return altimeterHP;
    }

    /**
     * Sets the value of the altimeterHP property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAltimeterHP(Integer value) {
        this.altimeterHP = value;
    }

    /**
     * Gets the value of the seaLevelPressuremb property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSeaLevelPressuremb() {
        return seaLevelPressuremb;
    }

    /**
     * Sets the value of the seaLevelPressuremb property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSeaLevelPressuremb(Integer value) {
        this.seaLevelPressuremb = value;
    }

    /**
     * Gets the value of the weatherPhenomenaReport property.
     * 
     * @return
     *     possible object is
     *     {@link METARType.WeatherPhenomenaReport }
     *     
     */
    public METARType.WeatherPhenomenaReport getWeatherPhenomenaReport() {
        return weatherPhenomenaReport;
    }

    /**
     * Sets the value of the weatherPhenomenaReport property.
     * 
     * @param value
     *     allowed object is
     *     {@link METARType.WeatherPhenomenaReport }
     *     
     */
    public void setWeatherPhenomenaReport(METARType.WeatherPhenomenaReport value) {
        this.weatherPhenomenaReport = value;
    }

    /**
     * Gets the value of the skyCondition property.
     * 
     * @return
     *     possible object is
     *     {@link SkyConditionType }
     *     
     */
    public SkyConditionType getSkyCondition() {
        return skyCondition;
    }

    /**
     * Sets the value of the skyCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link SkyConditionType }
     *     
     */
    public void setSkyCondition(SkyConditionType value) {
        this.skyCondition = value;
    }

    /**
     * Gets the value of the precip1HrIn property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPrecip1HrIn() {
        return precip1HrIn;
    }

    /**
     * Sets the value of the precip1HrIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPrecip1HrIn(Float value) {
        this.precip1HrIn = value;
    }

    /**
     * Gets the value of the precip3HrIn property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPrecip3HrIn() {
        return precip3HrIn;
    }

    /**
     * Sets the value of the precip3HrIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPrecip3HrIn(Float value) {
        this.precip3HrIn = value;
    }

    /**
     * Gets the value of the precip6HrIn property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPrecip6HrIn() {
        return precip6HrIn;
    }

    /**
     * Sets the value of the precip6HrIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPrecip6HrIn(Float value) {
        this.precip6HrIn = value;
    }

    /**
     * Gets the value of the precip24HrIn property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPrecip24HrIn() {
        return precip24HrIn;
    }

    /**
     * Sets the value of the precip24HrIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPrecip24HrIn(Float value) {
        this.precip24HrIn = value;
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
     *         &lt;element name="Qualifier" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}WeatherQualifierType" minOccurs="0"/>
     *         &lt;element name="Descriptor" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}WeatherDescriptorType" minOccurs="0"/>
     *         &lt;element name="Precipitation" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}WeatherPrecipitationType" minOccurs="0"/>
     *         &lt;element name="Obscuration" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}WeatherObscurationType" minOccurs="0"/>
     *         &lt;element name="Additional" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}WeatherAddlPhenomType" minOccurs="0"/>
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
        "qualifier",
        "descriptor",
        "precipitation",
        "obscuration",
        "additional"
    })
    public static class WeatherPhenomenaReport {

        @XmlElement(name = "Qualifier", namespace = "urn:oasis:names:tc:emergency:edxl:ct:1.0")
        @XmlSchemaType(name = "string")
        protected WeatherQualifierType qualifier;
        @XmlElement(name = "Descriptor", namespace = "urn:oasis:names:tc:emergency:edxl:ct:1.0")
        @XmlSchemaType(name = "string")
        protected WeatherDescriptorType descriptor;
        @XmlElement(name = "Precipitation", namespace = "urn:oasis:names:tc:emergency:edxl:ct:1.0")
        @XmlSchemaType(name = "string")
        protected WeatherPrecipitationType precipitation;
        @XmlElement(name = "Obscuration", namespace = "urn:oasis:names:tc:emergency:edxl:ct:1.0")
        @XmlSchemaType(name = "string")
        protected WeatherObscurationType obscuration;
        @XmlElement(name = "Additional", namespace = "urn:oasis:names:tc:emergency:edxl:ct:1.0")
        @XmlSchemaType(name = "string")
        protected WeatherAddlPhenomType additional;

        /**
         * Gets the value of the qualifier property.
         * 
         * @return
         *     possible object is
         *     {@link WeatherQualifierType }
         *     
         */
        public WeatherQualifierType getQualifier() {
            return qualifier;
        }

        /**
         * Sets the value of the qualifier property.
         * 
         * @param value
         *     allowed object is
         *     {@link WeatherQualifierType }
         *     
         */
        public void setQualifier(WeatherQualifierType value) {
            this.qualifier = value;
        }

        /**
         * Gets the value of the descriptor property.
         * 
         * @return
         *     possible object is
         *     {@link WeatherDescriptorType }
         *     
         */
        public WeatherDescriptorType getDescriptor() {
            return descriptor;
        }

        /**
         * Sets the value of the descriptor property.
         * 
         * @param value
         *     allowed object is
         *     {@link WeatherDescriptorType }
         *     
         */
        public void setDescriptor(WeatherDescriptorType value) {
            this.descriptor = value;
        }

        /**
         * Gets the value of the precipitation property.
         * 
         * @return
         *     possible object is
         *     {@link WeatherPrecipitationType }
         *     
         */
        public WeatherPrecipitationType getPrecipitation() {
            return precipitation;
        }

        /**
         * Sets the value of the precipitation property.
         * 
         * @param value
         *     allowed object is
         *     {@link WeatherPrecipitationType }
         *     
         */
        public void setPrecipitation(WeatherPrecipitationType value) {
            this.precipitation = value;
        }

        /**
         * Gets the value of the obscuration property.
         * 
         * @return
         *     possible object is
         *     {@link WeatherObscurationType }
         *     
         */
        public WeatherObscurationType getObscuration() {
            return obscuration;
        }

        /**
         * Sets the value of the obscuration property.
         * 
         * @param value
         *     allowed object is
         *     {@link WeatherObscurationType }
         *     
         */
        public void setObscuration(WeatherObscurationType value) {
            this.obscuration = value;
        }

        /**
         * Gets the value of the additional property.
         * 
         * @return
         *     possible object is
         *     {@link WeatherAddlPhenomType }
         *     
         */
        public WeatherAddlPhenomType getAdditional() {
            return additional;
        }

        /**
         * Sets the value of the additional property.
         * 
         * @param value
         *     allowed object is
         *     {@link WeatherAddlPhenomType }
         *     
         */
        public void setAdditional(WeatherAddlPhenomType value) {
            this.additional = value;
        }

    }

}
