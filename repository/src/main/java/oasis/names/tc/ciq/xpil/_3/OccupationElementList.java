//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.23 at 05:44:00 PM EET 
//


package oasis.names.tc.ciq.xpil._3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OccupationElementList.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OccupationElementList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="Role"/>
 *     &lt;enumeration value="PositionTitle"/>
 *     &lt;enumeration value="ReportsTo"/>
 *     &lt;enumeration value="EmploymentType"/>
 *     &lt;enumeration value="CostCentre"/>
 *     &lt;enumeration value="Rank"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OccupationElementList")
@XmlEnum
public enum OccupationElementList {


    /**
     * The actual role the person carries out.
     * 
     */
    @XmlEnumValue("Role")
    ROLE("Role"),
    @XmlEnumValue("PositionTitle")
    POSITION_TITLE("PositionTitle"),

    /**
     * Name, role or position who the person reports to.
     * 
     */
    @XmlEnumValue("ReportsTo")
    REPORTS_TO("ReportsTo"),

    /**
     * E.g. full-time, part-time, temporary, contract, etc.
     * 
     */
    @XmlEnumValue("EmploymentType")
    EMPLOYMENT_TYPE("EmploymentType"),

    /**
     * Commonly used identifier for accounting purposes.
     * 
     */
    @XmlEnumValue("CostCentre")
    COST_CENTRE("CostCentre"),

    /**
     * A rank in some ranking system, e.g. private, major, superintendant, Justice, etc.This is different from role
     * 
     */
    @XmlEnumValue("Rank")
    RANK("Rank");
    private final String value;

    OccupationElementList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OccupationElementList fromValue(String v) {
        for (OccupationElementList c: OccupationElementList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
