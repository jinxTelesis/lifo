package capstone.bcs.lifo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class FaqController {

    @RequestMapping("/faq")
    public String getPage(){
        return "faq";
    }
}
