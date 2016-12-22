package eu.impress.rest.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.impress.repository.dao.ObservationDAO;
import eu.impress.repository.model.incicrowd.PutObservationRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by jim on 4/12/2016.
 */

@RestController
@RequestMapping(value="/incicrowd")
public class InciCrowdController {

    @Autowired
    ObservationDAO observationDAO;
    @RequestMapping(
            value="/getAlertDetails",
            method= RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> getAlertDetails() {
        RestTemplate restTemplate = new RestTemplate();

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(
            value="/getAlertForRegion",
            method= RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> getAlertForRegion() {
        RestTemplate restTemplate = new RestTemplate();

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(
            value="/sendObservation",
            method= RequestMethod.POST,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> sendObservation(@RequestBody String request) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        PutObservationRequestBody putObservationRequestBody = null;
        try {
            putObservationRequestBody = objectMapper.readValue(request, PutObservationRequestBody.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            observationDAO.saveObservation(putObservationRequestBody.getPutObservation());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(
            value="/deleteObservation",
            method= RequestMethod.DELETE,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> deleteObservation() {
        RestTemplate restTemplate = new RestTemplate();

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(
            value="/getOffers",
            method= RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> getOffers() {
        RestTemplate restTemplate = new RestTemplate();

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(
            value="/sendOffer",
            method= RequestMethod.POST,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> sendOffer() {
        RestTemplate restTemplate = new RestTemplate();

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(
            value="/deleteOffer",
            method= RequestMethod.DELETE,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> deleteOffer() {
        RestTemplate restTemplate = new RestTemplate();

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(
            value="/getNeeds",
            method= RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> getNeeds() {
        RestTemplate restTemplate = new RestTemplate();

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(
            value="/sendNeed",
            method= RequestMethod.POST,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> sendNeed() {
        RestTemplate restTemplate = new RestTemplate();

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(
            value="/deleteNeed",
            method= RequestMethod.DELETE,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> deleteNeed() {
        RestTemplate restTemplate = new RestTemplate();

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(
            value="/getTextMessages",
            method= RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> getTextMessages() {
        RestTemplate restTemplate = new RestTemplate();

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @RequestMapping(
            value="/sendTextMessage",
            method= RequestMethod.POST,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> sendTextMessage() {
        RestTemplate restTemplate = new RestTemplate();

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
