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
 * <p>Java class for PatientEvacuationDestinationRequiredDefaultValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PatientEvacuationDestinationRequiredDefaultValues">
 *   &lt;restriction base="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLStringType">
 *     &lt;enumeration value="ICU "/>
 *     &lt;enumeration value="Floor"/>
 *     &lt;enumeration value="DischargeReady"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PatientEvacuationDestinationRequiredDefaultValues")
@XmlEnum
public enum PatientEvacuationDestinationRequiredDefaultValues {

    @XmlEnumValue("ICU ")
    ICU("ICU "),
    @XmlEnumValue("Floor")
    FLOOR("Floor"),
    @XmlEnumValue("DischargeReady")
    DISCHARGE_READY("DischargeReady");
    private final String value;

    PatientEvacuationDestinationRequiredDefaultValues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PatientEvacuationDestinationRequiredDefaultValues fromValue(String v) {
        for (PatientEvacuationDestinationRequiredDefaultValues c: PatientEvacuationDestinationRequiredDefaultValues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
