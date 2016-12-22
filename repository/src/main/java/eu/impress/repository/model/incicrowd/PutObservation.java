package eu.impress.repository.model.incicrowd;

import java.io.Serializable;

/**
 * Created by jim on 21/12/2016.
 */
public class PutObservation implements Serializable{
    String observationID;
    String accessKey;
    Long time;
    Double latitude;
    Double longitude;
    String text;
    //TODO: String in schema. But may need to convert to byte array
    String image;

    public PutObservation() {
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

    public void setAccessKey(String accesskey) {
        this.accessKey = accesskey;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
