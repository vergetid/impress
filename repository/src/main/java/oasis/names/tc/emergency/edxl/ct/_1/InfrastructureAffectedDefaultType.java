//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.15 at 12:31:13 PM EET 
//


package oasis.names.tc.emergency.edxl.ct._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InfrastructureAffectedDefaultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfrastructureAffectedDefaultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{urn:oasis:names:tc:emergency:edxl:ct:1.0}ValueKeyStringPairType">
 *       &lt;sequence>
 *         &lt;element name="ValueKeyURI" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}InfrastructureAffectedDefaultValueKey"/>
 *         &lt;element name="PairValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfrastructureAffectedDefaultType")
public class InfrastructureAffectedDefaultType
    extends ValueKeyStringPairType
{


}