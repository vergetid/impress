package eu.impress.repository.model.incicrowd;

import java.io.Serializable;

/**
 * Created by jim on 19/2/2017.
 */
public class Message implements Serializable {
    String messageId;
    Long time;
    String messageContent;

    public Message() {
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
