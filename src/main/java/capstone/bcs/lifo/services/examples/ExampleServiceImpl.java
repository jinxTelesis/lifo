package capstone.bcs.lifo.services.examples;

import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl implements ExampleServiceInterface {
    // == shift enter lets you provides skelton implementation of the interface ==

    // == generally a service would provide access to the model, API, WJAR or at least ==
    // == a switch statement to produce specific data for specific input ==
    // == this is the simplest service i can think of, one connected to a model will be implemented soon ==
    // == this service just returns a final string, Don't forget the Service annotation which tells Spring ==
    // == this is a bean ==

    public static  final String SIMPLE_SERVICE_DATA = "A super simple service";

    @Override
    public String simpleService() {
        return SIMPLE_SERVICE_DATA;
    }
}
