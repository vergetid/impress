package eu.impress.rest.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.impress.repository.dao.AlertDAO;
import eu.impress.repository.dao.ObservationDAO;
import eu.impress.repository.dao.ObservationService;
import eu.impress.repository.dao.OfferDAO;
import eu.impress.repository.model.incicrowd.*;
import eu.impress.repository.service.SimulateReceiveMessage;
import eu.impress.repository.util.incicrowd.CapParsingUtil;
import eu.impress.repository.util.incicrowd.CapUpdateBusMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by jim on 4/12/2016.
 */

@RestController
@RequestMapping(value="/incicrowd")
public class InciCrowdController {

    @Autowired
    ObservationService observationService;
    @Autowired
    ObservationDAO observationDAO;
    @Autowired
    OfferDAO offerDAO;
    @Autowired
    AlertDAO alertDAO;
    @Autowired
    private ApplicationContext ctx;
    @RequestMapping(
            value="/getAlertDetails",
            method= RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<GetAlertResponseBody> getAlertDetails(@RequestParam String param) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        GetAlertRequestBody getAlertRequestBody = null;
        GetAlertResponseBody response = new GetAlertResponseBody();
        try {
            getAlertRequestBody = objectMapper.readValue(param, GetAlertRequestBody.class);
        } catch (IOException e) {
            e.printStackTrace();

        }
        try {
            //observationDAO.saveObservation(putObservationRequestBody.getPutObservation());
            response = alertDAO.getAlert(getAlertRequestBody.getGetAlert().getAlertID());
            if (response == null) {
                return new ResponseEntity<GetAlertResponseBody>(HttpStatus.NOT_FOUND);
            } else {
                response.setResponse("SUCCESS");
                return new ResponseEntity<GetAlertResponseBody>(response, HttpStatus.OK);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return new ResponseEntity<GetAlertResponseBody>(response, HttpStatus.OK);
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
    public ResponseEntity<String> sendObservation(@RequestBody String request) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        PutObservationRequestBody putObservationRequestBody = null;
        try {
            putObservationRequestBody = objectMapper.readValue(request, PutObservationRequestBody.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(PutObservationError.PUTOBSERVATION_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {
            observationDAO.saveObservation(putObservationRequestBody.getPutObservation());

            //forward to EMCR


            //forward to activemq
            publishToTopic("IMPRESS.InciCrowd.Observation", CapUpdateBusMessage.pushObservation(putObservationRequestBody.getPutObservation()));
        } catch (SQLException e) {
            e.printStackTrace();

            return new ResponseEntity<String>(PutObservationError.PUTOBSERVATION_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(PutObservationSuccess.PUTOBSERVATION_SUCCESS, HttpStatus.OK);
    }

    @RequestMapping(
            value="/deleteObservation",
            method= RequestMethod.DELETE,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> deleteObservation(@RequestBody String request) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        DeleteObservationRequestBody deleteObservationRequestBody = null;
        try {
            deleteObservationRequestBody = objectMapper.readValue(request, DeleteObservationRequestBody.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        try {
            observationDAO.deleteObservation(deleteObservationRequestBody.getDeleteObservation().getObservationID());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(
            value="/getOffers",
            method= RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<GetOffersForRegionResponseBody> getOffers(@RequestParam String param) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        GetOffersForRegionRequestBody getOffersForRegionRequestBody = null;
        GetOffersForRegionResponseBody response = new GetOffersForRegionResponseBody();
        try {
            getOffersForRegionRequestBody = objectMapper.readValue(param, GetOffersForRegionRequestBody.class);
        } catch (IOException e) {
            e.printStackTrace();

        }
        try {
            //observationDAO.saveObservation(putObservationRequestBody.getPutObservation());
            response = offerDAO.getOfferList(getOffersForRegionRequestBody.getGetOffersForRegion());
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return new ResponseEntity<GetOffersForRegionResponseBody>(response, HttpStatus.OK);
    }

    @RequestMapping(
            value="/sendOffer",
            method= RequestMethod.POST,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> sendOffer(@RequestBody String request) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        PutOfferRequestBody putOfferRequestBody = null;
        try {
            putOfferRequestBody = objectMapper.readValue(request, PutOfferRequestBody.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(PutOfferError.PUT_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {
            offerDAO.saveOffer(putOfferRequestBody.getPutOffer());
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(PutObservationError.PUTOBSERVATION_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(PutObservationSuccess.PUTOBSERVATION_SUCCESS, HttpStatus.OK);
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

    private void publishToTopic(String topicName, ByteBuffer msg)
    {
        FileSystemUtils.deleteRecursively(new File("activemq-data"));

        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                BytesMessage bytesMessage = session.createBytesMessage();
                bytesMessage.writeBytes(msg.array());
                return bytesMessage;
            }
        };

        JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);
        Logger.getLogger(SimulateReceiveMessage.class.getName()).log(Level.INFO, "Sending message down the topic");
        jmsTemplate.send(topicName, messageCreator);
    }
}
