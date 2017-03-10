package eu.impress.repository.model.incicrowd;

import java.io.Serializable;

/**
 * Created by jim on 7/3/2017.
 */
public class GetAlertsForRegion implements Serializable{
    String locale;
    Double latitude;
    Double longitude;
    Integer radius;

    public GetAlertsForRegion() {
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

    public void setLongitude(Double longitutde) {
        this.longitude = longitutde;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public String getLocale() {

        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
