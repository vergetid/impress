package eu.impress.repository.util.incicrowd;

import eu.impress.repository.model.incicrowd.Alert;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.CRC32;

/**
 * Created by jim on 24/1/2017.
 */
public class CapUpdateBusMessage {
    public static ByteBuffer pushAlert(Alert alert) {
        ByteBuffer messageToSend = ByteBuffer.allocate(39);
        messageToSend.order(ByteOrder.LITTLE_ENDIAN);
        messageToSend.put((byte) 10);

        byte[] stringBytes = alert.getAlertID().getBytes();
        byte[] dataBytes = new byte[18];
        System.arraycopy(stringBytes, 0, dataBytes,0, Math.min(stringBytes.length, dataBytes.length));
        messageToSend.put(dataBytes);

        messageToSend.putInt(235322);
        messageToSend.putInt(543212);
        messageToSend.putInt(345432);


        CRC32 crc = new CRC32();
        crc.update(messageToSend.array(), 0, messageToSend.position());
        messageToSend.putLong(crc.getValue());
        return messageToSend;
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
