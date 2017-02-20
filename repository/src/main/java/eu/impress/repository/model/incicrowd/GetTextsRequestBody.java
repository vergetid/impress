package eu.impress.repository.model.incicrowd;

/**
 * Created by jim on 19/2/2017.
 */
public class GetTextsRequestBody {
    GetTextMessages getTextMessages;

    public GetTextsRequestBody() {
    }

    public GetTextMessages getGetTextMessages() {
        return getTextMessages;
    }

    public void setGetTextMessages(GetTextMessages getTextMessages) {
        this.getTextMessages = getTextMessages;
    }
}
