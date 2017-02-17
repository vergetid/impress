package eu.impress.repository.dao;

import eu.impress.repository.model.incicrowd.PutObservation;

import javax.xml.datatype.DatatypeConfigurationException;

/**
 * Created by jim on 21/12/2016.
 */
public interface ObservationService {
    public void saveObservation(PutObservation observation);
    public String createObservationDE() throws DatatypeConfigurationException;

    String getSitrepEDXLDE(String edxlde, String edxlSitrep) throws DatatypeConfigurationException;

    String forwardSitrep(String DEmessage);

    public String getObservationSitrep(PutObservation observation);
}
