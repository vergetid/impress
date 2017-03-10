package eu.impress.app;

import java.io.File;
import java.io.IOException;

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

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.FileSystemUtils;

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
        factory.setClientId("intl-89823");
        return factory;
    }


    public static void main(String... args) throws IOException{
        FileSystemUtils.deleteRecursively(new File("activemq-data"));
    ApplicationContext ctx = SpringApplication.run(Main.class, args);
    
    }

}
