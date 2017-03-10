package eu.impress.logevo.util;

import eu.impress.logevo.dao.NuggetDAO;
import eu.impress.logevo.dao.PatientDAO;
import eu.impress.logevo.model.GaugerSymptom;
import eu.impress.logevo.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by jim on 10/3/2017.
 */
@Component
public class PatevoCall {
    @Autowired
    NuggetDAO nuggetDAO;
    @Autowired
    PatientDAO patientDAO;

    @Async
    public void patevoLoop(String message) {
        //Get Patient Pseudo id & event type
        String eventId = null;
        String patientId = null;
        String timeDiff = null;
        String asset = null;
        String incidentId = null;
        try {
            eventId = TepParsingUtil.getEventType(message);
            patientId = TepParsingUtil.getPatientId(message);
            timeDiff = TepParsingUtil.getSentAndIncidentTimeDiff(message);
            incidentId = TepParsingUtil.getIncidentId(message);
            //timeDiff = "0.1";
            //incidentId = "131313";
        } catch (ParserConfigurationException | SAXException | IOException | ParseException e1) {
            e1.printStackTrace();
            return;
        }
        //Check if patient exists

        try {
            Patient patient = patientDAO.findPatientbyID(patientId);
            if (patient == null ) {
                //new patient
                patient = new Patient();
                patient.setPseudoID(patientId);
                patient.setIncidentId(incidentId);
                nuggetDAO.initiatePatient(patient, eventId, timeDiff);
                List<GaugerSymptom> symptoms = TepParsingUtil.getSymptoms(message);
                //check if symptoms present
                if (symptoms.size() > 0) {
                    nuggetDAO.updatePatientWithSymptoms(patient, symptoms);
                    nuggetDAO.updatePatientStatScoring(patient);
                }
            } else {
                //existing patient. Update w SICKEVO
                //1st: Get Asset
                System.out.println("ReceiverImpl: Found existing patient");
                //System.out.println("Found asset: " + TepParsingUtil.getAsset(message));
                //System.out.println("With Value: " + Asset.getValByName(TepParsingUtil.getAsset(message)));
                String sickevoAsset = null;
                if ( Asset.getValByName(TepParsingUtil.getAsset(message)) != null) {
                    sickevoAsset = Asset.getValByName(TepParsingUtil.getAsset(message));
                    //patient.setAsset_id( Asset.getValByName(TepParsingUtil.getAsset(message)) );
                } else {
                    sickevoAsset = "0";
                    //patient.setAsset_id("0");
                }
                nuggetDAO.updatePatient(patient,
                        TepParsingUtil.getSentTime(message), sickevoAsset);
                List<GaugerSymptom> symptoms = TepParsingUtil.getSymptoms(message);
                //check if symptoms present
                if (symptoms.size() > 0) {
                    nuggetDAO.updatePatientWithSymptoms(patient, symptoms);
                    nuggetDAO.updatePatientStatScoring(patient);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException | ParseException | SQLException e) {
            e.printStackTrace();
        }
    }
}
