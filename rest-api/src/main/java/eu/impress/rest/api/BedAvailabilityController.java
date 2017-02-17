/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.impress.rest.api;

import eu.impress.repository.service.BedAvailabilityServiceImpl;
import javax.xml.datatype.DatatypeConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author danae
 */
@RestController
public class BedAvailabilityController {

    @Autowired
    BedAvailabilityServiceImpl b;

    @Value("${connections.incimag.emcr.endpoint.message}")
    private String EMCRUrl;

    private static final Logger log = LoggerFactory.getLogger(eu.impress.rest.api.BedAvailabilityController.class);

    @RequestMapping(
            value = "/bedavailability/hospital/{hospitalName}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> sendAvailableBeds(@PathVariable("hospitalName") String hospitalName)  throws DatatypeConfigurationException{

        String bedavailability;
        String bedavailabilityDEEnvelope;
        String bedavailabilityDE;
        String bedavailabilityJSON;

        //get HAVE String
        bedavailability = b.getBedAvailablityHAVE(hospitalName);

        //get DE String
        bedavailabilityDEEnvelope = b.createBedAvailabilityDE("GR");

        //encapsulate in DE
        bedavailabilityDE = b.getBedAvailabilityEDXLDE(bedavailabilityDEEnvelope, bedavailability);

        //produce json message
        bedavailabilityJSON = b.forwardBedAvailability(bedavailabilityDE);
        log.info("Json message: " + bedavailabilityJSON);

        //push message to EMCR
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(bedavailabilityJSON, headers);
        String answer = restTemplate.postForObject(EMCRUrl, entity, String.class);

        log.info("EMCR response: " + answer);
        
        return new ResponseEntity<String>(answer, HttpStatus.OK);

    }

}
