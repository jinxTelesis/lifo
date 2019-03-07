package capstone.bcs.lifo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//@RequestMapping("realprojectpages")
@Controller
public class PartnersPageController {

    @RequestMapping("/partnerspage") // == options in browser that map to the return ==
    public String getPage(){
        return "partnerspage"; // == page it directs to. You don't need to make the 3 different options ==
        // == the page it directs to will be in resources under templates with the return {fill in return name}.html ==
    }
}
