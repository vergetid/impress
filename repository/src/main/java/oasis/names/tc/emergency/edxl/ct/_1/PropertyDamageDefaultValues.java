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
 * <p>Java class for PropertyDamageDefaultValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PropertyDamageDefaultValues">
 *   &lt;restriction base="{urn:oasis:names:tc:emergency:edxl:ct:1.0}ValueType">
 *     &lt;enumeration value="ThreatenedWithin72Hours"/>
 *     &lt;enumeration value="Damaged"/>
 *     &lt;enumeration value="Destroyed"/>
 *     &lt;enumeration value="Value"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PropertyDamageDefaultValues")
@XmlEnum
public enum PropertyDamageDefaultValues {

    @XmlEnumValue("ThreatenedWithin72Hours")
    THREATENED_WITHIN_72_HOURS("ThreatenedWithin72Hours"),
    @XmlEnumValue("Damaged")
    DAMAGED("Damaged"),
    @XmlEnumValue("Destroyed")
    DESTROYED("Destroyed"),
    @XmlEnumValue("Value")
    VALUE("Value");
    private final String value;

    PropertyDamageDefaultValues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PropertyDamageDefaultValues fromValue(String v) {
        for (PropertyDamageDefaultValues c: PropertyDamageDefaultValues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
