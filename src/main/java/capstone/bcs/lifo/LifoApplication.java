package capstone.bcs.lifo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LifoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(LifoApplication.class, args);
    }

    protected SpringApplicationBuilder configure (SpringApplicationBuilder builder){
        return builder.sources(LifoApplication.class);
    }
}
