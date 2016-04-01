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
 * <p>Java class for WeatherAddlPhenomType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WeatherAddlPhenomType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Squall"/>
 *     &lt;enumeration value="Funnel Cloud"/>
 *     &lt;enumeration value="Sandstorm"/>
 *     &lt;enumeration value="Tornado"/>
 *     &lt;enumeration value="Waterspout"/>
 *     &lt;enumeration value="Duststorm"/>
 *     &lt;enumeration value="Dust Whirls"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WeatherAddlPhenomType")
@XmlEnum
public enum WeatherAddlPhenomType {

    @XmlEnumValue("Squall")
    SQUALL("Squall"),
    @XmlEnumValue("Funnel Cloud")
    FUNNEL_CLOUD("Funnel Cloud"),
    @XmlEnumValue("Sandstorm")
    SANDSTORM("Sandstorm"),
    @XmlEnumValue("Tornado")
    TORNADO("Tornado"),
    @XmlEnumValue("Waterspout")
    WATERSPOUT("Waterspout"),
    @XmlEnumValue("Duststorm")
    DUSTSTORM("Duststorm"),
    @XmlEnumValue("Dust Whirls")
    DUST_WHIRLS("Dust Whirls");
    private final String value;

    WeatherAddlPhenomType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WeatherAddlPhenomType fromValue(String v) {
        for (WeatherAddlPhenomType c: WeatherAddlPhenomType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
