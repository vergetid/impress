package eu.impress.repository.model.incicrowd;

import java.util.List;

/**
 * Created by jim on 7/3/2017.
 */
public class GetAlertsForRegionResponseBody {
    String response;
    List<Alert> alerts;

    public GetAlertsForRegionResponseBody() {
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    public GetAlertsForRegionResponseBody(String response, List<Alert> alerts) {

        this.response = response;
        this.alerts = alerts;
    }
}
