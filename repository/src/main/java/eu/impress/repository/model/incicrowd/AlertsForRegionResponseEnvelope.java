package eu.impress.repository.model.incicrowd;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jim on 7/3/2017.
 */
public class AlertsForRegionResponseEnvelope {
    @JsonProperty("getAlertsForRegion")
    GetAlertsForRegionResponseBody getAlertsForRegionResponseBody;

    public AlertsForRegionResponseEnvelope() {
    }

    public GetAlertsForRegionResponseBody getGetAlertsForRegionResponseBody() {

        return getAlertsForRegionResponseBody;
    }

    public void setGetAlertsForRegionResponseBody(GetAlertsForRegionResponseBody getAlertsForRegionResponseBody) {
        this.getAlertsForRegionResponseBody = getAlertsForRegionResponseBody;
    }
}
