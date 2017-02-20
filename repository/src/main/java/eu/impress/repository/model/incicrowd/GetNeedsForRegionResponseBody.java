package eu.impress.repository.model.incicrowd;

import java.util.List;

/**
 * Created by jim on 19/2/2017.
 */
public class GetNeedsForRegionResponseBody {
    String response;
    List<PutNeed> needs;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<PutNeed> getNeeds() {
        return needs;
    }

    public void setNeeds(List<PutNeed> needs) {
        this.needs = needs;
    }

    public GetNeedsForRegionResponseBody() {

    }
}
