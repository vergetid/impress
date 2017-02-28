package eu.impress.repository.util.incicrowd;

import eu.impress.repository.model.incicrowd.Alert;
import eu.impress.repository.model.incicrowd.PutObservation;
import eu.impress.repository.model.incicrowd.SendTextMessage;
import org.apache.commons.codec.binary.Hex;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.CRC32;

/**
 * Created by jim on 24/1/2017.
 */
public class CapUpdateBusMessage {
    public static ByteBuffer pushAlert(Alert alert) {
        ByteBuffer messageToSend = ByteBuffer.allocate(121);
        messageToSend.order(ByteOrder.LITTLE_ENDIAN);
        messageToSend.put((byte) 10);

        byte[] stringBytes = alert.getAlertID().getBytes();
        byte[] dataBytes = new byte[100];
        System.arraycopy(stringBytes, 0, dataBytes,0, Math.min(stringBytes.length, dataBytes.length));
        messageToSend.put(dataBytes);

        messageToSend.putInt( new Double((60.0*alert.getCentroid_lat())).intValue() );
        messageToSend.putInt( new Double((60.0*alert.getCentroid_long())).intValue());
        messageToSend.putInt(6371000);


        CRC32 crc = new CRC32();
        crc.update(messageToSend.array(), 0, messageToSend.position());
        messageToSend.putLong(crc.getValue());
        return messageToSend;
    }

    public static ByteBuffer pushTextMessage(SendTextMessage text) {
        ByteBuffer messageToSend = ByteBuffer.allocate(45);
        messageToSend.order(ByteOrder.LITTLE_ENDIAN);
        messageToSend.put((byte) 13);

        byte[] stringBytes = text.getOfferNeedID().getBytes();
        byte[] dataBytes = new byte[18];
        System.arraycopy(stringBytes, 0, dataBytes,0, Math.min(stringBytes.length, dataBytes.length));
        messageToSend.put(dataBytes);

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
    public static ByteBuffer pushObservation(PutObservation observation) {
        ByteBuffer messageToSend = ByteBuffer.allocate(53);
        messageToSend.order(ByteOrder.LITTLE_ENDIAN);
        messageToSend.put((byte) 12);
        byte[] idBytes = observation.getObservationID().getBytes();
        byte[] idDataBytes = new byte[36];
        System.arraycopy(idBytes, 0, idDataBytes, 0, Math.min(idBytes.length, idDataBytes.length));
        messageToSend.put(idDataBytes);

        /*System.out.println("pushObservation: will push epoch: " + System.currentTimeMillis() / 1000L);
        //byte[] millisBytes = ByteBuffer.allocate(Long.SIZE / Byte.SIZE).putLong(System.currentTimeMillis()).array();
        byte[] millisBytes = Long.toString(new Long(System.currentTimeMillis() / 1000L)).getBytes();
        byte[] milliDataBytes = new byte[8];
        System.arraycopy(millisBytes, 0, milliDataBytes, 0, Math.min(millisBytes.length, milliDataBytes.length));
        messageToSend.put(milliDataBytes);
        for (int j=0; j<milliDataBytes.length; j++) {
            System.out.format("%02X ", milliDataBytes[j]);
        }
        System.out.println();*/
        messageToSend.putLong(System.currentTimeMillis());

        CRC32 crc = new CRC32();
        crc.update(messageToSend.array(), 0, messageToSend.position());
        messageToSend.putLong(crc.getValue());
        System.out.println("Message that will be send to bus:");
        byte[] testOutput = messageToSend.array();
        for (int j = 0; j < testOutput.length; j++) {
            System.out.format("%02x ", testOutput[j]);
        }

        return messageToSend;
    }
}
