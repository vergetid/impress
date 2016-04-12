package eu.impress.repository.service;

import eu.impress.repository.dao.Receiver;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

@Component
public class ReceiverImpl{
    //@Autowired
    //ConfigurableApplicationContext context;
    //?consumer.retroactive=true&consumer.prefetchSize=10
    @JmsListener(destination = "SPRING.TEST", containerFactory = "myJmsContainerFactory", subscription = "intl-89890")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        //context.close();
        FileSystemUtils.deleteRecursively(new File("activemq-data"));
    }
    
    
}
