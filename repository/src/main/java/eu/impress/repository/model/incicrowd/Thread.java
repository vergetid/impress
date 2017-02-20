package eu.impress.repository.model.incicrowd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jim on 19/2/2017.
 */
public class Thread implements Serializable {
    String threadId;
    List<Message> messages = new ArrayList<>();

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Thread() {

    }
}
