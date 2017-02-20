package eu.impress.repository.model.incicrowd;

/**
 * Created by jim on 19/2/2017.
 */
public class SendTextRequestBody {
    SendTextMessage putText;

    public SendTextMessage getPutText() {
        return putText;
    }

    public void setPutText(SendTextMessage putText) {
        this.putText = putText;
    }

    public SendTextRequestBody() {

    }
}
