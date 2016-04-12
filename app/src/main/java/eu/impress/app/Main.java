package eu.impress.app;

import java.io.File;
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

/**
 *
 * @author danae
 */
@ComponentScan({"eu.impress"})
//@ComponentScan
@SpringBootApplication
@EnableJms
public class Main extends SpringBootServletInitializer {
    
    @Bean
    JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
	factory.setReplyPubSubDomain(true);
        factory.setSubscriptionDurable(true);        
        factory.setClientId("intl-89890");
        return factory;
    }
    
    public static void main(String... args){
        FileSystemUtils.deleteRecursively(new File("activemq-data"));
    ApplicationContext ctx = SpringApplication.run(Main.class, args);
    
     // Send a message
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("ping durable consumer #2!");
            }
        };
        JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);
        System.out.println("Sending a new message for durable consumer #2.");
        //jmsTemplate.send("SPRING.TEST", messageCreator);
    
    }
    
}
