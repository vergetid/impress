package eu.impress.rest.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.impress.repository.dao.*;
import eu.impress.repository.model.incicrowd.*;
import eu.impress.repository.service.SimulateReceiveMessage;
import eu.impress.repository.util.incicrowd.CapParsingUtil;
import eu.impress.repository.util.incicrowd.CapUpdateBusMessage;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.*;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.xml.datatype.DatatypeConfigurationException;
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
    NeedDAO needDAO;
    @Autowired
    AlertDAO alertDAO;
    @Autowired
    TextDAO textDAO;
    @Autowired
    private ApplicationContext ctx;
    @Value("${connections.incimag.emcr.endpoint.message}")
    private String EMCRUrl;

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(eu.impress.rest.api.InciCrowdController.class);

    @RequestMapping(
            value="/deleteAlert/{alertId}",
            method= RequestMethod.POST,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> deleteAlert(@PathVariable String alertId) {
        try {
            alertDAO.deleteAlert(alertId);
        } catch (SQLException ex) {
            Logger.getLogger(InciCrowdController.class.getName()).log(Level.SEVERE, null, ex);
        }
        publishToTopic("IMPRESS.InciCrowd.Alerts", CapUpdateBusMessage.removeAlert(alertId));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @RequestMapping(
            value="/getAlert",
            method= RequestMethod.POST,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AlertResponseEnvelope> getAlertDetails(@RequestBody String param) {
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
                response = new GetAlertResponseBody();
                response.setResponse("NOTFOUND");
                AlertResponseEnvelope alertResponseEnvelope = new AlertResponseEnvelope();
                alertResponseEnvelope.setGetAlertResponseBody(response);
                return new ResponseEntity<>(alertResponseEnvelope, HttpStatus.OK);
            } else {
                AlertResponseEnvelope alertResponseEnvelope = new AlertResponseEnvelope();
                alertResponseEnvelope.setGetAlertResponseBody(response);
                return new ResponseEntity<>(alertResponseEnvelope, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = new GetAlertResponseBody();
            response.setResponse("ERROR");
            AlertResponseEnvelope alertResponseEnvelope = new AlertResponseEnvelope();
            alertResponseEnvelope.setGetAlertResponseBody(response);
            return new ResponseEntity<>(alertResponseEnvelope, HttpStatus.OK);

        }
    }

    @RequestMapping(
            value="/getAlertsForRegion",
            method= RequestMethod.POST,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AlertsForRegionResponseEnvelope> getAlertForRegion(@RequestBody String param) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        GetAlertsForRegionRequestBody getAlertsForRegionRequestBody = null;
        GetAlertsForRegionResponseBody response = new GetAlertsForRegionResponseBody();
        try {
            getAlertsForRegionRequestBody = objectMapper.readValue(param, GetAlertsForRegionRequestBody.class);
        } catch (IOException e) {
            e.printStackTrace();

        }
        try {
            //observationDAO.saveObservation(putObservationRequestBody.getPutObservation());
            response = alertDAO.getAlertsForRegion(getAlertsForRegionRequestBody.getGetAlertsForRegion());
        } catch (Exception e) {
            e.printStackTrace();
            response = new GetAlertsForRegionResponseBody();
            response.setResponse("ERROR");
            AlertsForRegionResponseEnvelope alertsForRegionResponseEnvelope = new AlertsForRegionResponseEnvelope();
            alertsForRegionResponseEnvelope.setGetAlertsForRegionResponseBody(response);
            return new ResponseEntity<>(alertsForRegionResponseEnvelope, HttpStatus.OK);

        }
        AlertsForRegionResponseEnvelope alertsForRegionResponseEnvelope = new AlertsForRegionResponseEnvelope();
        if (response.getAlerts().size() == 0) {
            response.setResponse("NONE");
        }
        alertsForRegionResponseEnvelope.setGetAlertsForRegionResponseBody(response);
        return new ResponseEntity<>(alertsForRegionResponseEnvelope, HttpStatus.OK);
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


            //get SITREP String
            String sitRepStr = observationService.getObservationSitrep(putObservationRequestBody.getPutObservation());
            log.info("SitrepStr: " + sitRepStr);

            //get DE Envelope for Sitrep
            String sitRepEnvelopeStr = observationService.createObservationDE();

            //encapsulate in DE
            String observationDEStr = observationService.getSitrepEDXLDE(sitRepEnvelopeStr, sitRepStr);

            //produce JSON message
            String observationJson = observationService.forwardSitrep(observationDEStr);
            log.info("Will send to EMCR Json: " + observationJson);

            //push message to EMCR
            RestTemplate restTemplateSitrep = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<String>(observationJson ,headers);
            String answer = restTemplateSitrep.postForObject(EMCRUrl, entity, String.class);

            log.info("EMCR response: " + answer);


            //forward to activemq
            publishToTopic("IMPRESS.InciCrowd.Observation", CapUpdateBusMessage.pushObservation(putObservationRequestBody.getPutObservation()));
        } catch (SQLException e) {
            e.printStackTrace();

            return new ResponseEntity<String>(PutObservationError.PUTOBSERVATION_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>(PutObservationSuccess.PUTOBSERVATION_SUCCESS, HttpStatus.OK);
    }

    @RequestMapping(
            value="/deleteObservation",
            method= RequestMethod.POST,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> deleteObservation(@RequestBody String request) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        DeleteObservationRequestBody deleteObservationRequestBody = null;
        try {
            deleteObservationRequestBody = objectMapper.readValue(request, DeleteObservationRequestBody.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>(DeleteObservationResponses.PUT_ERROR, HttpStatus.OK);
        }
        try {
            observationDAO.deleteObservation(deleteObservationRequestBody.getDeleteObservation().getObservationID());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>(DeleteObservationResponses.PUT_ERROR, HttpStatus.OK);
        }

        return new ResponseEntity<String>(DeleteObservationResponses.PUT_SUCCESS, HttpStatus.OK);
    }

    @RequestMapping(
            value="/getOffer",
            method= RequestMethod.POST,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<OffersResponseEnvelope> getOffers(@RequestBody String param) {
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
            response = new GetOffersForRegionResponseBody();
            response.setResponse("ERROR");
            OffersResponseEnvelope offersResponseEnvelope = new OffersResponseEnvelope();
            offersResponseEnvelope.setGetOffersForRegionResponseBody(response);
            return new ResponseEntity<>(offersResponseEnvelope, HttpStatus.OK);

        }
        OffersResponseEnvelope offersResponseEnvelope = new OffersResponseEnvelope();
        if (response.getOffers().size() == 0) {
            response.setResponse("NONE");
        }
        offersResponseEnvelope.setGetOffersForRegionResponseBody(response);
        return new ResponseEntity<>(offersResponseEnvelope, HttpStatus.OK);
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
            return new ResponseEntity<String>(PutOfferError.PUT_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(PutOfferSuccess.PUT_SUCCESS, HttpStatus.OK);
    }

    @RequestMapping(
            value="/deleteOffer",
            method= RequestMethod.POST,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> deleteOffer() {
        RestTemplate restTemplate = new RestTemplate();

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(
            value="/getNeed",
            method= RequestMethod.POST,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<NeedsResponseEnvelope> getNeeds(@RequestBody String param) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        GetNeedsForRegionRequestBody getNeedsForRegionRequestBody = null;
        GetNeedsForRegionResponseBody response = new GetNeedsForRegionResponseBody();
        try {
            getNeedsForRegionRequestBody = objectMapper.readValue(param, GetNeedsForRegionRequestBody.class);
        } catch (IOException e) {
            e.printStackTrace();

        }
        try {
            //observationDAO.saveObservation(putObservationRequestBody.getPutObservation());
            response = needDAO.getNeedList(getNeedsForRegionRequestBody.getGetNeedsForRegion());
        } catch (SQLException e) {
            e.printStackTrace();

        }
        NeedsResponseEnvelope needsResponseEnvelope = new NeedsResponseEnvelope();
        needsResponseEnvelope.setGetNeedsForRegionResponseBody(response);
        return new ResponseEntity<NeedsResponseEnvelope>(needsResponseEnvelope, HttpStatus.OK);
    }

    @RequestMapping(
            value="/sendNeed",
            method= RequestMethod.POST,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> sendNeed(@RequestBody String request) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        PutNeedRequestBody putNeedRequestBody = null;
        try {
            putNeedRequestBody = objectMapper.readValue(request, PutNeedRequestBody.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(PutNeedError.PUT_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {
            needDAO.saveNeed(putNeedRequestBody.getPutNeed());
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(PutNeedError.PUT_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(PutNeedSuccess.PUT_SUCCESS, HttpStatus.OK);
    }

    @RequestMapping(
            value="/deleteNeed",
            method= RequestMethod.POST,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> deleteNeed() {
        RestTemplate restTemplate = new RestTemplate();

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(
            value="/getTextMessage",
            method= RequestMethod.POST,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TextsResponseEnvelope> getTextMessages(@RequestBody String param) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        GetTextsRequestBody getTextsRequestBody = null;
        GetTextsResponseBody response = new GetTextsResponseBody();
        try {
            getTextsRequestBody = objectMapper.readValue(param, GetTextsRequestBody.class);
        } catch (IOException e) {
            e.printStackTrace();

        }
        try {
            //observationDAO.saveObservation(putObservationRequestBody.getPutObservation());
            response = textDAO.getTexts(getTextsRequestBody.getGetTextMessages());
        } catch (SQLException e) {
            e.printStackTrace();

        }
        TextsResponseEnvelope textsResponseEnvelope = new TextsResponseEnvelope();
        textsResponseEnvelope.setGetTextsResponseBody(response);
        return new ResponseEntity<>(textsResponseEnvelope, HttpStatus.OK);
    }


    @RequestMapping(
            value="/sendTextMessage",
            method= RequestMethod.POST,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> sendTextMessage(@RequestBody String request) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        SendTextRequestBody putTextRequestBody = null;
        try {
            putTextRequestBody = objectMapper.readValue(request, SendTextRequestBody.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(SendTextError.PUT_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {
            textDAO.saveText(putTextRequestBody.getPutText());

            //forward to activemq
            publishToTopic("IMPRESS.InciCrowd.TextMessaging",
                    CapUpdateBusMessage.pushTextMessage(putTextRequestBody.getPutText()));
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(SendTextError.PUT_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(SendTextSuccess.PUT_SUCCESS, HttpStatus.OK);
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
