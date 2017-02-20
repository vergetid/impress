package eu.impress.repository.model.incicrowd;

import java.io.Serializable;

/**
 * Created by jim on 19/2/2017.
 */
public class GetTextMessages implements Serializable {
    String offerNeedID;
    String accessKey;
    String threadId;

    public String getOfferNeedID() {
        return offerNeedID;
    }

    public void setOfferNeedID(String offerNeedID) {
        this.offerNeedID = offerNeedID;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public GetTextMessages() {
    }
}
