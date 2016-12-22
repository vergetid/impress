package eu.impress.repository.model.incicrowd;

/**
 * Created by jim on 21/12/2016.
 */
public class PutObservationRequestBody {
    PutObservation putObservation;

    public PutObservationRequestBody() {
        putObservation = new PutObservation();
    }

    public PutObservation getPutObservation() {
        return putObservation;
    }

    public void setPutObservation(PutObservation putObservation) {
        this.putObservation = putObservation;
    }
}
