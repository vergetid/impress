package eu.impress.repository.util.incicrowd;

import eu.impress.repository.model.incicrowd.Alert;
import eu.impress.repository.model.incicrowd.PutObservation;

import java.util.zip.CRC32;

/**
 * Created by jim on 24/1/2017.
 */
public class CapUpdateBusMessage {
    public static String pushAlert(Alert alert) {
        String message = null;
        message = "10";
        message += alert.getAlertID();
        CRC32 crc = new CRC32();
        crc.update(message.getBytes());
        message+=Long.toString(crc.getValue());
        return message;
    }
    public static String revokeAlert(Alert alert) {
        String message = null;
        message = "11";
        message += alert.getAlertID();
        CRC32 crc = new CRC32();
        crc.update(message.getBytes());
        message+=Long.toString(crc.getValue());
        return message;
    }
}
