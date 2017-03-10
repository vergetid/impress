package eu.impress.repository.model.incicrowd;

import java.io.Serializable;

/**
 * Created by jim on 24/1/2017.
 */
public class GetAlert implements Serializable{
    String alertID;
    String locale;

    public String getAlertID() {
        return alertID;
    }

    public void setAlertID(String alertID) {
        this.alertID = alertID;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public GetAlert() {

    }
}
