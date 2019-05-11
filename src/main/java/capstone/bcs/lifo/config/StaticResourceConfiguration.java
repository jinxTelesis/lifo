package capstone.bcs.lifo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


//@Configuration
public class StaticResourceConfiguration extends WebMvcConfigurerAdapter {

    // this resource configurer is not being used right now, spring is using the default resource paths
    // this is for testing only but was part of the development process

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources","classpath:/resources/",
            "classpath:/static","classpath:/public","../classpath:/META-INF/resources"};


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }
}
