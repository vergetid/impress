package eu.impress.repository.model.incicrowd;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jim on 1/3/2017.
 */
public class OffersResponseEnvelope {
    @JsonProperty("getOffersForRegion")
    GetOffersForRegionResponseBody getOffersForRegionResponseBody;

    public GetOffersForRegionResponseBody getGetOffersForRegionResponseBody() {
        return getOffersForRegionResponseBody;
    }

    public void setGetOffersForRegionResponseBody(GetOffersForRegionResponseBody getOffersForRegionResponseBody) {
        this.getOffersForRegionResponseBody = getOffersForRegionResponseBody;
    }

    public OffersResponseEnvelope() {

    }
}
