/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.impress.repository.util;

import static org.apache.commons.lang.StringEscapeUtils.escapeHtml;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import oasis.names.tc.emergency.EDXL.DE._1.*;

/**
 *
 * @author danae
 */
public class EDXLlib {
    
    //constructs EDXLDEmessage
    public static String DEEncapsulation(String DEString, String EDXLHave) throws DatatypeConfigurationException{
        
        EDXLHave = escapeHtml(EDXLHave);                
        String finalDEString = DEString.replace("<xmlContent/>", "<xmlContent><embeddedXMLContent><any>"+EDXLHave+"</any></embeddedXMLContent></xmlContent>");
        return finalDEString;
    
    }
    
    /*
    Creates the EDXL-DE envelope with empty EmbeddedXMLContent
    */
    public static EDXLDistribution createEDXLEnvelope(String countryParam) throws DatatypeConfigurationException{
        
        List<String> country = new ArrayList<String>();
        List<TargetAreaType> targetArea = new ArrayList<TargetAreaType>();
        TargetAreaType tatype = new TargetAreaType();
        
        List<ValueSchemeType> explicitAddress = new ArrayList<ValueSchemeType>();
        ValueSchemeType vstype = new ValueSchemeType();
        List<String> explicitAddressValue = new ArrayList<String>();
        
        List<ContentObjectType> contentObject = new ArrayList<ContentObjectType>();
        ContentObjectType ct = new ContentObjectType();
        XmlContentType xt = new XmlContentType();
        
        String uuid = UUID.randomUUID().toString();
               
        EDXLDistribution ed = new EDXLDistribution();
        ed.setDistributionID("impress_dhc_"+uuid); //this must be defined
        ed.setSenderID("urn://impress/dhc/bedavailability");
        
        //country.add("GR");
        if (countryParam == null) {
            country.add("GR");
        } else {
            country.add(countryParam);
        }
        tatype.setCountry(country);
        targetArea.add(tatype);
        ed.setTargetArea(targetArea);
        
        ed.setDateTimeSent(getXMLGregorianCalendar());
        ed.setDistributionStatus(StatusValues.ACTUAL);
        ed.setDistributionType(TypeValues.REPORT);
        ed.setCombinedConfidentiality("Unclassified");
        
        vstype.setExplicitAddressScheme("urn");
        //explicitAddressValue.add("urn://agency/keelpno");
        explicitAddressValue.add("urn://me.gov.incimag");
        vstype.setExplicitAddressValue(explicitAddressValue);
        explicitAddress.add(vstype);
        ed.setExplicitAddress(explicitAddress);
      
        xt.setEmbeddedXMLContent(null);
        ct.setXmlContent(xt);
        contentObject.add(ct);
        ed.setContentObject(contentObject);
        
        return ed; 
    
    
    }
    
    public static EDXLDistribution createEDXLEnvelopeSitRep() throws DatatypeConfigurationException{
        
        List<String> country = new ArrayList<String>();
        List<TargetAreaType> targetArea = new ArrayList<TargetAreaType>();
        TargetAreaType tatype = new TargetAreaType();
        
        List<ValueSchemeType> explicitAddress = new ArrayList<ValueSchemeType>();
        ValueSchemeType vstype = new ValueSchemeType();
        List<String> explicitAddressValue = new ArrayList<String>();
        
        List<ContentObjectType> contentObject = new ArrayList<ContentObjectType>();
        ContentObjectType ct = new ContentObjectType();
        XmlContentType xt = new XmlContentType();
        
        String uuid = UUID.randomUUID().toString();
               
        EDXLDistribution ed = new EDXLDistribution();
        ed.setDistributionID("impress_incicrowd_"+uuid); //this must be defined
        ed.setSenderID("urn://impress/incicrowd/observations");
        
        //country.add("GR");
        country.add("BG");
        tatype.setCountry(country);
        targetArea.add(tatype);
        ed.setTargetArea(targetArea);
        
        ed.setDateTimeSent(getXMLGregorianCalendar());
        ed.setDistributionStatus(StatusValues.ACTUAL);
        ed.setDistributionType(TypeValues.REPORT);
        ed.setCombinedConfidentiality("Unclassified");
        
        vstype.setExplicitAddressScheme("urn");
        //explicitAddressValue.add("urn://agency/keelpno");
        explicitAddressValue.add("urn://me.gov.incimag");
        vstype.setExplicitAddressValue(explicitAddressValue);
        explicitAddress.add(vstype);
        ed.setExplicitAddress(explicitAddress);
      
        xt.setEmbeddedXMLContent(null);
        ct.setXmlContent(xt);
        contentObject.add(ct);
        ed.setContentObject(contentObject);
        
        return ed; 
    
    
    }
    
    public static XMLGregorianCalendar getXMLGregorianCalendar() throws DatatypeConfigurationException {

        try {

            Date now = new Date();
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(now);
            XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            return date2;

        } catch (DatatypeConfigurationException c) {

            return null;

        }

    }

    
}
