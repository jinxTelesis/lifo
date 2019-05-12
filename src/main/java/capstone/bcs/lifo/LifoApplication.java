package capstone.bcs.lifo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan("capstone.bcs.lifo")
@SpringBootApplication
public class LifoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifoApplication.class, args);

        /** this is the context that runs the application
         * @SpringBootApplication tells the comelier where to start that it is not a normal main
         */
    }

}
