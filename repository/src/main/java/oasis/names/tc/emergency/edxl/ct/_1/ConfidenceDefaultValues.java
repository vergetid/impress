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
 * <p>Java class for ConfidenceDefaultValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConfidenceDefaultValues">
 *   &lt;restriction base="{urn:oasis:names:tc:emergency:edxl:ct:1.0}ValueType">
 *     &lt;enumeration value="HighlyConfident "/>
 *     &lt;enumeration value="SomewhatConfident"/>
 *     &lt;enumeration value="Unsure"/>
 *     &lt;enumeration value="NoConfidence"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConfidenceDefaultValues")
@XmlEnum
public enum ConfidenceDefaultValues {

    @XmlEnumValue("HighlyConfident ")
    HIGHLY_CONFIDENT("HighlyConfident "),
    @XmlEnumValue("SomewhatConfident")
    SOMEWHAT_CONFIDENT("SomewhatConfident"),
    @XmlEnumValue("Unsure")
    UNSURE("Unsure"),
    @XmlEnumValue("NoConfidence")
    NO_CONFIDENCE("NoConfidence");
    private final String value;

    ConfidenceDefaultValues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ConfidenceDefaultValues fromValue(String v) {
        for (ConfidenceDefaultValues c: ConfidenceDefaultValues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
