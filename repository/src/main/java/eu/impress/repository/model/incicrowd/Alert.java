package eu.impress.repository.model.incicrowd;

import java.io.Serializable;

/**
 * Created by jim on 4/12/2016.
 */
public class Alert implements Serializable {
    String response;
    String alertID;
    Long time;
    String sender;
    String headline;
    String description;
    //TODO: check the time for area. String in response string but internal representation may be list of points
    String area;
    Double centroid_lat;
    Double centroid_long;

    public Alert(String alertID, Long time, String sender, String headline, String description, String area) {
        this.response = response;
        this.alertID = alertID;
        this.time = time;
        this.sender = sender;
        this.headline = headline;
        this.description = description;
        this.area = area;
    }

    public Double getCentroid_lat() {
        return centroid_lat;
    }

    public void setCentroid_lat(Double centroid_lat) {
        this.centroid_lat = centroid_lat;
    }

    public Double getCentroid_long() {
        return centroid_long;
    }

    public void setCentroid_long(Double centroid_long) {
        this.centroid_long = centroid_long;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getAlertID() {
        return alertID;
    }

    public void setAlertID(String alertID) {
        this.alertID = alertID;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Alert() {

    }
}
