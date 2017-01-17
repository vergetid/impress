package eu.impress.repository.model.incicrowd;

import java.io.Serializable;

/**
 * Created by jim on 17/1/2017.
 */
public class DeleteObservation implements Serializable{
    String observationID;
    String accessKey;

    public DeleteObservation() {
    }

    public String getObservationID() {
        return observationID;
    }

    public void setObservationID(String observationID) {
        this.observationID = observationID;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }
}
