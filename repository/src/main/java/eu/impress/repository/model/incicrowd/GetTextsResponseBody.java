package eu.impress.repository.model.incicrowd;

import java.util.List;

/**
 * Created by jim on 19/2/2017.
 */
public class GetTextsResponseBody {
    String response;
    List<Thread> threads;

    public List<Thread> getThreads() {
        return threads;
    }

    public void setThreads(List<Thread> threads) {
        this.threads = threads;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public GetTextsResponseBody() {

    }
}
