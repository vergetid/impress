package eu.impress.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author danae
 */
@ComponentScan({"eu.impress"})
//@ComponentScan
@SpringBootApplication
public class Main extends SpringBootServletInitializer {
    
    public static void main(String... args){
    ApplicationContext ctx = SpringApplication.run(Main.class, args);
    
    }
    
}
