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
 * <p>Java class for SpecialClassificationDefaultValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SpecialClassificationDefaultValues">
 *   &lt;restriction base="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLStringType">
 *     &lt;enumeration value="SecuritySupervisionNeeds"/>
 *     &lt;enumeration value="NDMSPatient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SpecialClassificationDefaultValues", namespace = "urn:oasis:names:tc:emergency:EDXL:TEP:1.0")
@XmlEnum
public enum SpecialClassificationDefaultValues {

    @XmlEnumValue("SecuritySupervisionNeeds")
    SECURITY_SUPERVISION_NEEDS("SecuritySupervisionNeeds"),
    @XmlEnumValue("NDMSPatient")
    NDMS_PATIENT("NDMSPatient");
    private final String value;

    SpecialClassificationDefaultValues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SpecialClassificationDefaultValues fromValue(String v) {
        for (SpecialClassificationDefaultValues c: SpecialClassificationDefaultValues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
