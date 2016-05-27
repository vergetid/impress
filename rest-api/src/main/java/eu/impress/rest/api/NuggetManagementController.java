package eu.impress.rest.api;

import eu.impress.logevo.dao.NuggetDAO;
import eu.impress.logevo.dao.PatientDAO;
import eu.impress.logevo.model.Patient;
import eu.impress.repository.dao.NuggetService;
import eu.impress.repository.model.NuggetDescription;
import eu.impress.repository.service.NuggetServiceImpl;

import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NuggetManagementController
{    
    @Autowired
    NuggetService nuggetService;
    @Autowired
    PatientDAO patientDAO;

    
    private static final Logger log = LoggerFactory.getLogger(eu.impress.rest.api.NuggetManagementController.class);
        
    @RequestMapping(
		value="/nugget", 
		method=RequestMethod.POST,
                consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<String>  insertNugget(@RequestBody Patient patient)
    {	  
    	try {
    		Patient patientToUpdate = patientDAO.findPatientbyID(patient.getPseudoID());
			if (patientToUpdate == null) {
				return new ResponseEntity<String>("Patient not found", HttpStatus.NOT_FOUND);
			} else {
				patientToUpdate.setNugget(patient.getNugget());
				nuggetService.updatePatientDirect(patientToUpdate);
				return new ResponseEntity<String>("Patient Updated", HttpStatus.NOT_FOUND);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //nuggetService.insertNewNugget(nugget);
                
	return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(
		value="/nugget", 
		method=RequestMethod.GET,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Patient>  getLatestNuggetByPatientPseudoID(@RequestParam("patientID") String id)
    {	        
        Patient patient = nuggetService.getPatientStateByPatientID(id);
        if (patient == null) {
        	System.out.println("NUGGET REST CONTROLLER: Not found w PatientId " + id);
        	return new ResponseEntity<Patient>(patient, HttpStatus.NOT_FOUND);
        } else {
        	System.out.println("NUGGET REST CONTROLLER: Found Patient w Id: " + id);
        }
                
	return new ResponseEntity<Patient>(patient,HttpStatus.OK);
    }    
}
