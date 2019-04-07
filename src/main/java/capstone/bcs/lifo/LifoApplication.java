package capstone.bcs.lifo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan("capstone.bcs.lifo")
@SpringBootApplication
public class LifoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifoApplication.class, args);
    }
}
