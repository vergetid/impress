package eu.impress.repository.service;

import eu.impress.repository.dao.BeansTransformation;
import eu.impress.repository.dao.ObservationService;
import eu.impress.repository.model.incicrowd.PutObservation;
import eu.impress.repository.util.EDXLlib;
import oasis.names.tc.emergency.EDXL.DE._1.EDXLDistribution;
import oasis.names.tc.emergency.edxl.sitrep._1.SitRep;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import java.io.StringWriter;

/**
 * Created by jim on 21/12/2016.
 */
@Component
public class ObservationServiceImpl implements ObservationService {
    @Autowired
    BeansTransformation beansTransformation;

    @Override
    public void saveObservation(PutObservation observation) {

    }

    @Override
    public String createObservationDE() throws DatatypeConfigurationException {
        String DEmessageenvelope="";
        String DEmessage="";

        EDXLDistribution ed = EDXLlib.createEDXLEnvelopeSitRep();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(EDXLDistribution.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            StringWriter sw = new StringWriter();
            //marshal the envelope
            jaxbMarshaller.marshal(ed, sw);
            DEmessageenvelope = sw.toString();

            //could not unescape characters no matter what!
            //encapsulate the edxl have message into DE by avoiding jaxb
            //DEmessage = EDXLlib.DEEncapsulation(DEmessageenvelope, edxlhave);
            DEmessage = DEmessageenvelope;

        } catch (JAXBException e) {
            e.printStackTrace();
            return "Error Marshalling XML Object";
        }

        return DEmessage;
    }

    @Override
    public String getSitrepEDXLDE(String edxlde, String edxlSitrep) throws DatatypeConfigurationException{

        return EDXLlib.DEEncapsulation(edxlde, edxlSitrep);

    }

    @Override
    public String forwardSitrep(String DEmessage){

        JSONObject message = new JSONObject();
        JSONObject content = new JSONObject();

        message.put("message", content);
        message.put("token", "7e72d619-3896-49d8-a598-6227a9c38557");

        content.put("content", DEmessage);

        return message.toString().replace("\\/", "/");

    }

    @Override
    public String getObservationSitrep(PutObservation observation) {
        String observationSitrepStr;
        SitRep observationSitrep = beansTransformation.ObservationToEDLXL(observation);
        //BedStats bedStats = bedService.getHospitalAvailableBeds(hospitalname);
        //HospitalStatus hospitalStatus = beansTransformation.BedStatstoHAVE(bedStats);


        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(SitRep.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            StringWriter sw = new StringWriter();
            //marshal the envelope
            jaxbMarshaller.marshal(observationSitrep, sw);
            observationSitrepStr = sw.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
            return "Error Marshalling XML Object";
        }

        return observationSitrepStr;
    }
}
