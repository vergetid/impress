package eu.impress.repository.model.incicrowd;

import java.util.List;

/**
 * Created by jim on 17/1/2017.
 */
public class GetOffersForRegionResponseBody {
    String response;
    List<PutOffer> offers;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<PutOffer> getOffers() {
        return offers;
    }

    public void setOffers(List<PutOffer> offers) {
        this.offers = offers;
    }

    public GetOffersForRegionResponseBody() {

    }
}
