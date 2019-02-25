package capstone.bcs.lifo.services.examples;

public interface ExampleServiceInterface {

    // == an interface is a good practice to outline ==
    // == what you want to implement in your classes ==
    // == the class that implements this service will ==
    // == have to provide a concrete method ==
    // == in this case ExampleServiceImpl ==
    String simpleService();
}
