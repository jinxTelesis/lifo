package capstone.bcs.lifo;

import capstone.bcs.lifo.config.SecurityConfig;
import capstone.bcs.lifo.services.CartProductServiceImpl;
import capstone.bcs.lifo.services.CartServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@ComponentScan("capstone.bcs.lifo")
@SpringBootApplication
public class LifoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifoApplication.class, args);




    }
}
