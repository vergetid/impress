package eu.impress.rest.api;

import eu.impress.logevo.model.Patient;
import eu.impress.repository.model.NuggetDescription;
import eu.impress.repository.service.NuggetServiceImpl;
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
    NuggetServiceImpl nuggetServiceImpl;
    
    private static final Logger log = LoggerFactory.getLogger(eu.impress.rest.api.NuggetManagementController.class);
        
    @RequestMapping(
		value="/nugget", 
		method=RequestMethod.POST,
                consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<String>  insertNugget(@RequestBody NuggetDescription nugget)
    {	        
        nuggetServiceImpl.insertNewNugget(nugget);
                
	return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(
		value="/nugget", 
		method=RequestMethod.GET,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Patient>  getLatestNuggetByPatientPseudoID(@RequestParam("id") String id)
    {	        
        Patient patient = nuggetServiceImpl.getPatientStateByPatientID(id);
                
	return new ResponseEntity<Patient>(patient,HttpStatus.OK);
    }    
}
