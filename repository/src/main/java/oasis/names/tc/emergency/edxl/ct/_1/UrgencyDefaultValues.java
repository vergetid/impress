//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.15 at 12:31:13 PM EET 
//


package oasis.names.tc.emergency.edxl.ct._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UrgencyDefaultValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UrgencyDefaultValues">
 *   &lt;restriction base="{urn:oasis:names:tc:emergency:edxl:ct:1.0}ValueType">
 *     &lt;enumeration value="Immediate"/>
 *     &lt;enumeration value="Expected"/>
 *     &lt;enumeration value="Future"/>
 *     &lt;enumeration value="Past"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UrgencyDefaultValues")
@XmlEnum
public enum UrgencyDefaultValues {

    @XmlEnumValue("Immediate")
    IMMEDIATE("Immediate"),
    @XmlEnumValue("Expected")
    EXPECTED("Expected"),
    @XmlEnumValue("Future")
    FUTURE("Future"),
    @XmlEnumValue("Past")
    PAST("Past"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    UrgencyDefaultValues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UrgencyDefaultValues fromValue(String v) {
        for (UrgencyDefaultValues c: UrgencyDefaultValues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
