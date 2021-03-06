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
 * <p>Java class for IncidentLifecycleDefaultValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IncidentLifecycleDefaultValues">
 *   &lt;restriction base="{urn:oasis:names:tc:emergency:edxl:ct:1.0}ValueType">
 *     &lt;enumeration value="Preparedness"/>
 *     &lt;enumeration value="Response"/>
 *     &lt;enumeration value="Mitigation"/>
 *     &lt;enumeration value="Recovery"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IncidentLifecycleDefaultValues")
@XmlEnum
public enum IncidentLifecycleDefaultValues {

    @XmlEnumValue("Preparedness")
    PREPAREDNESS("Preparedness"),
    @XmlEnumValue("Response")
    RESPONSE("Response"),
    @XmlEnumValue("Mitigation")
    MITIGATION("Mitigation"),
    @XmlEnumValue("Recovery")
    RECOVERY("Recovery");
    private final String value;

    IncidentLifecycleDefaultValues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IncidentLifecycleDefaultValues fromValue(String v) {
        for (IncidentLifecycleDefaultValues c: IncidentLifecycleDefaultValues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
