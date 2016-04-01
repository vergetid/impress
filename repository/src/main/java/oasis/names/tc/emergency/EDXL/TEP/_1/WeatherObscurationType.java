//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.01 at 06:03:54 PM EEST 
//


package oasis.names.tc.emergency.EDXL.TEP._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WeatherObscurationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WeatherObscurationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Mist"/>
 *     &lt;enumeration value="Sand"/>
 *     &lt;enumeration value="Smoke"/>
 *     &lt;enumeration value="Haze"/>
 *     &lt;enumeration value="Volcanic Ash"/>
 *     &lt;enumeration value="Spray"/>
 *     &lt;enumeration value="Widespread Dust"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WeatherObscurationType", namespace = "urn:oasis:names:tc:emergency:edxl:ct:1.0")
@XmlEnum
public enum WeatherObscurationType {

    @XmlEnumValue("Mist")
    MIST("Mist"),
    @XmlEnumValue("Sand")
    SAND("Sand"),
    @XmlEnumValue("Smoke")
    SMOKE("Smoke"),
    @XmlEnumValue("Haze")
    HAZE("Haze"),
    @XmlEnumValue("Volcanic Ash")
    VOLCANIC_ASH("Volcanic Ash"),
    @XmlEnumValue("Spray")
    SPRAY("Spray"),
    @XmlEnumValue("Widespread Dust")
    WIDESPREAD_DUST("Widespread Dust"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    WeatherObscurationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WeatherObscurationType fromValue(String v) {
        for (WeatherObscurationType c: WeatherObscurationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
