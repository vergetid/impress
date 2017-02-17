package eu.impress.logevo.service;

import java.util.List;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import eu.impress.logevo.dao.PatientDAO;
import eu.impress.logevo.dao.ResOverviewDAO;
import eu.impress.logevo.model.ResOverview;
import eu.impress.logevo.util.DateUtils;
import eu.impress.logevo.util.LogevoCallsEnvelopeFactory;

@Service
public class ResOverviewDAOImpl implements ResOverviewDAO {

	@Autowired
	PatientDAO patientDAO;
	
	@Override
	public ResOverview getResOverview(String incidentid) {
        try {
        	SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();
			String url = "http://biomat1.iasi.cnr.it/webservices/IMPRESS/services.php";
			List<String> nuggets = patientDAO.getNuggetsPerIncidentId(incidentid);
            SOAPMessage resOverviewSoapMessage = 
            		LogevoCallsEnvelopeFactory.createResOverviewFullRequest(nuggets);
            SOAPMessage resOverviewSoapResponse = soapConnection.call(resOverviewSoapMessage, url);	
            System.out.println("ResOverviewDAOImpl: getResOverview: RESOVERVIEW RETURNED WITH:");
            LogevoCallsEnvelopeFactory.printSOAPResponse(resOverviewSoapResponse);
            
            //String nugget = sickevoSoapResponse.getSOAPBody().getElementsByTagName("nugget").item(0).getTextContent();
            Node desirableAssetsNode = resOverviewSoapResponse.getSOAPBody().
            		getElementsByTagName("desirable_assets").item(0);
            NodeList desirableAssetsNodes = desirableAssetsNode.getChildNodes();

            ResOverview resOverview = new ResOverview();
            for (int i = 0; i < desirableAssetsNodes.getLength(); i++) {
            	Node desirableAsset = desirableAssetsNodes.item(i);
            	String dStr = desirableAsset.getTextContent();
            	resOverview.getDesirableAssets().add(dStr);
            	System.out.println("ResOverviewDAOImpl: getResOverview: Desirable Asset value: " + dStr);
            }
            
            Node balancedAssetsNode = resOverviewSoapResponse.getSOAPBody().
            		getElementsByTagName("balanced_assets").item(0);
            NodeList balancedAssetsNodes = balancedAssetsNode.getChildNodes();

            for (int i = 0; i < balancedAssetsNodes.getLength(); i++) {
            	Node balancedAsset = balancedAssetsNodes.item(i);
            	String bStr = balancedAsset.getTextContent();
            	resOverview.getBalancedAssets().add(bStr);
            	System.out.println("ResOverviewDAOImpl: getResOverview: Balanced Asset value: " + bStr);
            }      
            return resOverview;
            //patient.setNugget(nugget);
            //patient.setLastUpdateTime(DateUtils.XmlGregorianDateStringtoEpoch(TEPTime)); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
        
	}

}
