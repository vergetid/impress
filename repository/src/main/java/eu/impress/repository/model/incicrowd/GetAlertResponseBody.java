package eu.impress.repository.model.incicrowd;

/**
 * Created by jim on 24/1/2017.
 */
public class GetAlertResponseBody {
    String response;
    String alertID;
    Long time;
    String sender;
    String headline;
    String description;
    //TODO: check the time for area. String in response string but internal representation may be list of points
    String area;

    public GetAlertResponseBody(String alertID, Long time, String sender, String headline, String description, String area) {
        this.response = response;
        this.alertID = alertID;
        this.time = time;
        this.sender = sender;
        this.headline = headline;
        this.description = description;
        this.area = area;
    }

    public GetAlertResponseBody() {
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

}
