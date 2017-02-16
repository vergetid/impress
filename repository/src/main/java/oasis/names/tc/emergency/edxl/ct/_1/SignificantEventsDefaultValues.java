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
 * <p>Java class for SignificantEventsDefaultValues.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SignificantEventsDefaultValues">
 *   &lt;restriction base="{urn:oasis:names:tc:emergency:edxl:ct:1.0}ValueType">
 *     &lt;enumeration value="RoadClosure"/>
 *     &lt;enumeration value="MassNotifications"/>
 *     &lt;enumeration value="Evacuation"/>
 *     &lt;enumeration value="ShelterInPlace"/>
 *     &lt;enumeration value="RoadClosure"/>
 *     &lt;enumeration value="PowerOutage"/>
 *     &lt;enumeration value="TreesDown"/>
 *     &lt;enumeration value="StrandedVehicle(s) "/>
 *     &lt;enumeration value="WaterLineBreak"/>
 *     &lt;enumeration value="WaterShortage"/>
 *     &lt;enumeration value="Quarantine"/>
 *     &lt;enumeration value="BridgeCollapse"/>
 *     &lt;enumeration value="BuildingCollapse"/>
 *     &lt;enumeration value="Deaths"/>
 *     &lt;enumeration value="Injuries"/>
 *     &lt;enumeration value="MassImmunizations"/>
 *     &lt;enumeration value="CleanupComplete"/>
 *     &lt;enumeration value="ResidentRepopulation"/>
 *     &lt;enumeration value="IncidentCommandTransition"/>
 *     &lt;enumeration value="Accomplishments"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SignificantEventsDefaultValues")
@XmlEnum
public enum SignificantEventsDefaultValues {

    @XmlEnumValue("RoadClosure")
    ROAD_CLOSURE("RoadClosure"),
    @XmlEnumValue("MassNotifications")
    MASS_NOTIFICATIONS("MassNotifications"),
    @XmlEnumValue("Evacuation")
    EVACUATION("Evacuation"),
    @XmlEnumValue("ShelterInPlace")
    SHELTER_IN_PLACE("ShelterInPlace"),
    @XmlEnumValue("PowerOutage")
    POWER_OUTAGE("PowerOutage"),
    @XmlEnumValue("TreesDown")
    TREES_DOWN("TreesDown"),
    @XmlEnumValue("StrandedVehicle(s) ")
    STRANDED_VEHICLE_S("StrandedVehicle(s) "),
    @XmlEnumValue("WaterLineBreak")
    WATER_LINE_BREAK("WaterLineBreak"),
    @XmlEnumValue("WaterShortage")
    WATER_SHORTAGE("WaterShortage"),
    @XmlEnumValue("Quarantine")
    QUARANTINE("Quarantine"),
    @XmlEnumValue("BridgeCollapse")
    BRIDGE_COLLAPSE("BridgeCollapse"),
    @XmlEnumValue("BuildingCollapse")
    BUILDING_COLLAPSE("BuildingCollapse"),
    @XmlEnumValue("Deaths")
    DEATHS("Deaths"),
    @XmlEnumValue("Injuries")
    INJURIES("Injuries"),
    @XmlEnumValue("MassImmunizations")
    MASS_IMMUNIZATIONS("MassImmunizations"),
    @XmlEnumValue("CleanupComplete")
    CLEANUP_COMPLETE("CleanupComplete"),
    @XmlEnumValue("ResidentRepopulation")
    RESIDENT_REPOPULATION("ResidentRepopulation"),
    @XmlEnumValue("IncidentCommandTransition")
    INCIDENT_COMMAND_TRANSITION("IncidentCommandTransition"),
    @XmlEnumValue("Accomplishments")
    ACCOMPLISHMENTS("Accomplishments");
    private final String value;

    SignificantEventsDefaultValues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SignificantEventsDefaultValues fromValue(String v) {
        for (SignificantEventsDefaultValues c: SignificantEventsDefaultValues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}