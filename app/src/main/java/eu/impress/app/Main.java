package eu.impress.app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.util.FileSystemUtils;

import eu.impress.repository.service.SimulateReceiveMessage;

/**
 *
 * @author danae
 */
@ComponentScan({"eu.impress"})
//@ComponentScan
@SpringBootApplication
@EnableJms
public class Main extends SpringBootServletInitializer {
    //@Autowired
    //SimulateReceiveMessage simulateReceiveMessage;
	//Development only
	/*private @Value("${tepfiles.location}") static String tepFileName;*/
    @Bean
    JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        factory.setReplyPubSubDomain(true);
        factory.setSubscriptionDurable(true);        
        factory.setClientId("intl-89823-test");
        return factory;
    }
    @Bean
    JmsListenerContainerFactory<?> alertJmsContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        factory.setReplyPubSubDomain(true);
        factory.setSubscriptionDurable(true);
        factory.setClientId("intl-89824-test");
        return factory;
    }

    public static void main(String... args) throws IOException{
        FileSystemUtils.deleteRecursively(new File("activemq-data"));
    ApplicationContext ctx = SpringApplication.run(Main.class, args);
    File capFile = new File("/home/jim/CAP.xml");
    //File capFile = new File("/home/vergetid/workspace/INTRA/impress tools/CAP.xml");
    String CAPStr = new String(Files.readAllBytes(capFile.toPath()));
    //SimulateReceiveMessage simulateReceiveMessage = new SimulateReceiveMessage();
     //   simulateReceiveMessage.receivCAP(CAPStr);
    //Development only
    //get the contents of the TEP file
    /*System.out.println("Tep file location: " + tepFileName);
    File file = new File("/home/jim/TEPmessageReceived-new.msg");
    String tepMsgStr = new String(Files.readAllBytes(file.toPath()));*/
    
//SimulateReceiveMessage simulateReceiveMessage = new SimulateReceiveMessage();
//simulateReceiveMessage.receiveMessage(tepMsgStr);

    //System.out.println(new String(Files.readAllBytes(file.toPath())));
     // Send a message
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(CAPStr);
            }
        };
        JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);
        System.out.println("Sending a new message for durable consumer #2.");
        jmsTemplate.send("SPRING.TEST", messageCreator);
    
    }

}
