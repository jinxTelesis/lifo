package capstone.bcs.lifo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpecialOffer {

    @RequestMapping("/special_offer")
    public String getPage(){
        return "special_offer";
    }
}
