package capstone.bcs.lifo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ComponentsController {

    @RequestMapping("/components")
    public String getPage(){
        return "examples/components";
    }
}
