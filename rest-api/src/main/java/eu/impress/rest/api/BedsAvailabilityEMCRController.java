package eu.impress.rest.api;

import java.util.Collection;
import eu.impress.repository.dao.BeansTransformation;
import eu.impress.repository.dao.BedsService;
import eu.impress.repository.service.BedAvailabilityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

@RestController
public class BedsAvailabilityEMCRController {
	@Autowired
	private BedsService bedService;
	@Autowired
	private BeansTransformation beansTransformation;

        @Autowired
        BedAvailabilityServiceImpl b;        
        
        @Value("${connections.incimag.emcr.endpoint.message}")
        private String EMCRUrl;        

        private static final Logger log = LoggerFactory.getLogger(eu.impress.rest.api.BedsAvailabilityEMCRController.class);
        
	@RequestMapping(
			value="/publish/beds/available", 
			method=RequestMethod.GET)
	public ResponseEntity<String> getAvailableBedsXML(@RequestParam("hospital") String hospitalName) {	
                String bedavailability;
                String bedavailabilityDEEnvelope;
                String bedavailabilityDE;
                String bedavailabilityJSON;
                try
                {
                    //get HAVE String
                    bedavailability = b.getBedTypeAvailablityHAVE(hospitalName);
                    System.err.println(" - bedAvail: " + bedavailability);
                    
                    //get DE String
                    bedavailabilityDEEnvelope = b.createBedAvailabilityDE();

                    //encapsulate in DE
                    bedavailabilityDE = b.getBedAvailabilityEDXLDE(bedavailabilityDEEnvelope, bedavailability);

                    //produce json message
                    bedavailabilityJSON = b.forwardBedAvailability(bedavailabilityDE);
                    log.info("Json message: " + bedavailabilityJSON);

                    //push message to EMCR
                    RestTemplate restTemplate = new RestTemplate();
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_JSON);

                    HttpEntity<String> entity = new HttpEntity<String>(bedavailabilityJSON ,headers);
                    String answer = restTemplate.postForObject(EMCRUrl, entity, String.class);

                    log.info("EMCR response: " + answer);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
		return new ResponseEntity(HttpStatus.OK);
                
	}

    @RequestMapping(
            value="/publish/beds/available/all",
            method=RequestMethod.GET)
    public ResponseEntity<String> getAvailableBedsAllXML() {
        String bedavailability;
        String bedavailabilityDEEnvelope;
        String bedavailabilityDE;
        String bedavailabilityJSON;
        try
        {
            //get HAVE String
            bedavailability = b.getBedTypeAllAvailablityHAVE();
            System.err.println(" - bedAvail: " + bedavailability);

            //get DE String
            bedavailabilityDEEnvelope = b.createBedAvailabilityDE();

            //encapsulate in DE
            bedavailabilityDE = b.getBedAvailabilityEDXLDE(bedavailabilityDEEnvelope, bedavailability);

            //produce json message
            bedavailabilityJSON = b.forwardBedAvailability(bedavailabilityDE);
            log.info("Json message: " + bedavailabilityJSON);

            //push message to EMCR
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<String>(bedavailabilityJSON ,headers);
            String answer = restTemplate.postForObject(EMCRUrl, entity, String.class);

            log.info("EMCR response: " + answer);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.OK);

    }
}
