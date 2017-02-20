package eu.impress.repository.model.incicrowd;

import java.io.Serializable;

/**
 * Created by jim on 19/2/2017.
 */
public class SendTextMessage implements Serializable {
    String offerNeedID;
    String threadId;
    String messageId;
    Long time;
    String messageContent;

    public SendTextMessage() {
    }

    public String getOfferNeedID() {
        return offerNeedID;
    }

    public void setOfferNeedID(String offerNeedID) {
        this.offerNeedID = offerNeedID;
    }

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
