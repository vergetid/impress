//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.01 at 06:02:17 PM EEST 
//


package oasis.names.tc.emergency.edxl.ct._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WeatherDescriptorType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WeatherDescriptorType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Shallow"/>
 *     &lt;enumeration value="Blowing"/>
 *     &lt;enumeration value="Patches"/>
 *     &lt;enumeration value="Showers"/>
 *     &lt;enumeration value="Partial"/>
 *     &lt;enumeration value="Drifting"/>
 *     &lt;enumeration value="Thunderstorm"/>
 *     &lt;enumeration value="Freezing"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WeatherDescriptorType")
@XmlEnum
public enum WeatherDescriptorType {

    @XmlEnumValue("Shallow")
    SHALLOW("Shallow"),
    @XmlEnumValue("Blowing")
    BLOWING("Blowing"),
    @XmlEnumValue("Patches")
    PATCHES("Patches"),
    @XmlEnumValue("Showers")
    SHOWERS("Showers"),
    @XmlEnumValue("Partial")
    PARTIAL("Partial"),
    @XmlEnumValue("Drifting")
    DRIFTING("Drifting"),
    @XmlEnumValue("Thunderstorm")
    THUNDERSTORM("Thunderstorm"),
    @XmlEnumValue("Freezing")
    FREEZING("Freezing");
    private final String value;

    WeatherDescriptorType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WeatherDescriptorType fromValue(String v) {
        for (WeatherDescriptorType c: WeatherDescriptorType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
