package eu.impress.repository.model.incicrowd;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jim on 26/2/2017.
 */
public class NeedsResponseEnvelope {
    @JsonProperty("getNeedsForRegion")
    GetNeedsForRegionResponseBody getNeedsForRegionResponseBody;

    public GetNeedsForRegionResponseBody getGetNeedsForRegionResponseBody() {
        return getNeedsForRegionResponseBody;
    }

    public void setGetNeedsForRegionResponseBody(GetNeedsForRegionResponseBody getNeedsForRegionResponseBody) {
        this.getNeedsForRegionResponseBody = getNeedsForRegionResponseBody;
    }

    public NeedsResponseEnvelope() {

    }
}
