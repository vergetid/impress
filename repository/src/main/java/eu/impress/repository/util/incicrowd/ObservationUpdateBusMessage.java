package eu.impress.repository.util.incicrowd;

import eu.impress.repository.model.incicrowd.PutObservation;

import java.util.zip.CRC32;

/**
 * Created by jim on 17/1/2017.
 */
public class ObservationUpdateBusMessage {
    public static String busMessage(PutObservation Observation) {
        String message = null;
        message = "12";
        message += Observation.getObservationID();
        message += Long.toString(Observation.getTime());
        CRC32 crc = new CRC32();
        crc.update(message.getBytes());
        message+=Long.toString(crc.getValue());
        return message;
    }
}
