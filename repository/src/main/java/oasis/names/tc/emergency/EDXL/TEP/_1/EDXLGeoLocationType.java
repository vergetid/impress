//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.01 at 06:03:54 PM EEST 
//


package oasis.names.tc.emergency.EDXL.TEP._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EDXLGeoLocationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EDXLGeoLocationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.opengis.net/gml/3.2}Point"/>
 *         &lt;element ref="{http://www.opengis.net/gml/3.2}CircleByCenterPoint"/>
 *         &lt;element ref="{http://www.opengis.net/gml/3.2}Polygon"/>
 *         &lt;element ref="{http://www.opengis.net/gml/3.2}Envelope"/>
 *         &lt;element ref="{http://www.opengis.net/gml/3.2}LineString"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EDXLGeoLocationType", namespace = "urn:oasis:names:tc:emergency:edxl:gsf:1.0", propOrder = {
    "point",
    "circleByCenterPoint",
    "polygon",
    "envelope",
    "lineString"
})
public class EDXLGeoLocationType {

    @XmlElement(name = "Point", namespace = "http://www.opengis.net/gml/3.2")
    protected PointType point;
    @XmlElement(name = "CircleByCenterPoint", namespace = "http://www.opengis.net/gml/3.2")
    protected CircleByCenterPointType circleByCenterPoint;
    @XmlElement(name = "Polygon", namespace = "http://www.opengis.net/gml/3.2")
    protected PolygonType polygon;
    @XmlElement(name = "Envelope", namespace = "http://www.opengis.net/gml/3.2")
    protected EnvelopeType envelope;
    @XmlElement(name = "LineString", namespace = "http://www.opengis.net/gml/3.2")
    protected LineStringType lineString;

    /**
     * Gets the value of the point property.
     * 
     * @return
     *     possible object is
     *     {@link PointType }
     *     
     */
    public PointType getPoint() {
        return point;
    }

    /**
     * Sets the value of the point property.
     * 
     * @param value
     *     allowed object is
     *     {@link PointType }
     *     
     */
    public void setPoint(PointType value) {
        this.point = value;
    }

    /**
     * Gets the value of the circleByCenterPoint property.
     * 
     * @return
     *     possible object is
     *     {@link CircleByCenterPointType }
     *     
     */
    public CircleByCenterPointType getCircleByCenterPoint() {
        return circleByCenterPoint;
    }

    /**
     * Sets the value of the circleByCenterPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link CircleByCenterPointType }
     *     
     */
    public void setCircleByCenterPoint(CircleByCenterPointType value) {
        this.circleByCenterPoint = value;
    }

    /**
     * Gets the value of the polygon property.
     * 
     * @return
     *     possible object is
     *     {@link PolygonType }
     *     
     */
    public PolygonType getPolygon() {
        return polygon;
    }

    /**
     * Sets the value of the polygon property.
     * 
     * @param value
     *     allowed object is
     *     {@link PolygonType }
     *     
     */
    public void setPolygon(PolygonType value) {
        this.polygon = value;
    }

    /**
     * Gets the value of the envelope property.
     * 
     * @return
     *     possible object is
     *     {@link EnvelopeType }
     *     
     */
    public EnvelopeType getEnvelope() {
        return envelope;
    }

    /**
     * Sets the value of the envelope property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnvelopeType }
     *     
     */
    public void setEnvelope(EnvelopeType value) {
        this.envelope = value;
    }

    /**
     * Gets the value of the lineString property.
     * 
     * @return
     *     possible object is
     *     {@link LineStringType }
     *     
     */
    public LineStringType getLineString() {
        return lineString;
    }

    /**
     * Sets the value of the lineString property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineStringType }
     *     
     */
    public void setLineString(LineStringType value) {
        this.lineString = value;
    }

}
