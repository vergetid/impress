package eu.impress.repository.model.incicrowd;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jim on 9/3/2017.
 */
public class TextsResponseEnvelope {
    @JsonProperty("getTextMessages")
    GetTextsResponseBody getTextsResponseBody;

    public GetTextsResponseBody getGetTextsResponseBody() {
        return getTextsResponseBody;
    }

    public void setGetTextsResponseBody(GetTextsResponseBody getTextsResponseBody) {
        this.getTextsResponseBody = getTextsResponseBody;
    }

    public TextsResponseEnvelope() {

    }
}
