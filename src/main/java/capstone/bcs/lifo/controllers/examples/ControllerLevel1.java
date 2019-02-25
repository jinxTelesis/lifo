package capstone.bcs.lifo.controllers.examples;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerLevel1 {

    // == the html has to be strict because thymeleaf will parse it wrong otherwise ==
    // == you can put it into a website to validate if it is strictly compliant ==

    @RequestMapping({"/","/index","home"}) // == options in browser that map to the return ==
    public String getPage(){
        return "index"; // == page it directs to. You don't need to make the 3 different options ==
        // == the page it directs to will be in resources under templates with the return {fill in return name}.html ==
    }
}
