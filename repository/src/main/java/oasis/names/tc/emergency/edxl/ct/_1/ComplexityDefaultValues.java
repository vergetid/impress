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
 * <p>Java class for ComplexityDefaultValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ComplexityDefaultValues">
 *   &lt;restriction base="{urn:oasis:names:tc:emergency:edxl:ct:1.0}ValueType">
 *     &lt;enumeration value="Complex"/>
 *     &lt;enumeration value="ModerateComplex"/>
 *     &lt;enumeration value="Moderate"/>
 *     &lt;enumeration value="Low"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ComplexityDefaultValues")
@XmlEnum
public enum ComplexityDefaultValues {

    @XmlEnumValue("Complex")
    COMPLEX("Complex"),
    @XmlEnumValue("ModerateComplex")
    MODERATE_COMPLEX("ModerateComplex"),
    @XmlEnumValue("Moderate")
    MODERATE("Moderate"),
    @XmlEnumValue("Low")
    LOW("Low");
    private final String value;

    ComplexityDefaultValues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ComplexityDefaultValues fromValue(String v) {
        for (ComplexityDefaultValues c: ComplexityDefaultValues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
