package eu.impress.repository.model.incicrowd;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jim on 9/3/2017.
 */
public class AlertResponseEnvelope {
    @JsonProperty("getAlert")
    GetAlertResponseBody getAlertResponseBody;

    public GetAlertResponseBody getGetAlertResponseBody() {
        return getAlertResponseBody;
    }

    public void setGetAlertResponseBody(GetAlertResponseBody getAlertResponseBody) {
        this.getAlertResponseBody = getAlertResponseBody;
    }

    public AlertResponseEnvelope() {
    }
}
