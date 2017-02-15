package eu.impress.repository.service;

import eu.impress.repository.dao.ObservationService;
import eu.impress.repository.model.incicrowd.PutObservation;
import eu.impress.repository.util.EDXLlib;
import oasis.names.tc.emergency.EDXL.DE._1.EDXLDistribution;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import java.io.StringWriter;

/**
 * Created by jim on 21/12/2016.
 */
public class ObservationServiceImpl implements ObservationService {
    @Override
    public void saveObservation(PutObservation observation) {

    }

    @Override
    public String createObservationDE() throws DatatypeConfigurationException {
        String DEmessageenvelope="";
        String DEmessage="";

        EDXLDistribution ed = EDXLlib.createEDXLEnvelope();

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
    public String getObservationSitrep(PutObservation observation) {
        String observationSitrep = null;
        //BedStats bedStats = bedService.getHospitalAvailableBeds(hospitalname);
        //HospitalStatus hospitalStatus = beansTransformation.BedStatstoHAVE(bedStats);


        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(EDXLDistribution.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            StringWriter sw = new StringWriter();
            //marshal the envelope
            jaxbMarshaller.marshal(observationSitrep, sw);
            observationSitrep = sw.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
            return "Error Marshalling XML Object";
        }

        return observationSitrep;
    }
}
