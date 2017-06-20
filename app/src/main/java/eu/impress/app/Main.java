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
import org.springframework.scheduling.annotation.EnableAsync;
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
@EnableAsync
public class Main extends SpringBootServletInitializer {

    @Bean
    JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        factory.setReplyPubSubDomain(true);
        factory.setSubscriptionDurable(true);
        factory.setClientId("intl-89823");
        return factory;
    }

    @Bean
    JmsListenerContainerFactory<?> alertJmsContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        factory.setReplyPubSubDomain(true);
        factory.setSubscriptionDurable(true);
        factory.setClientId("intl-89824");
        return factory;
    }

    @Bean
    JmsListenerContainerFactory<?> locationJmsContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        factory.setReplyPubSubDomain(true);
        factory.setSubscriptionDurable(true);
        factory.setClientId("intl-89814");
        return factory;
    }

    public static void main(String... args) throws IOException{
        FileSystemUtils.deleteRecursively(new File("activemq-data"));
        ApplicationContext ctx = SpringApplication.run(Main.class, args);
    
    }

}
