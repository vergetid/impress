//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.01 at 06:02:17 PM EEST 
//


package oasis.names.tc.emergency.edxl.tep._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GenderDefaultValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GenderDefaultValues">
 *   &lt;restriction base="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLStringType">
 *     &lt;enumeration value="Male"/>
 *     &lt;enumeration value="Female"/>
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="ExtensionValue"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GenderDefaultValues")
@XmlEnum
public enum GenderDefaultValues {

    @XmlEnumValue("Male")
    MALE("Male"),
    @XmlEnumValue("Female")
    FEMALE("Female"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("ExtensionValue")
    EXTENSION_VALUE("ExtensionValue");
    private final String value;

    GenderDefaultValues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GenderDefaultValues fromValue(String v) {
        for (GenderDefaultValues c: GenderDefaultValues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
