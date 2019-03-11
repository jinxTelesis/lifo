package capstone.bcs.lifo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    // got mikes change
    @RequestMapping({"/","/index","/.html","/index.html"})
    public String index(){
        return "index";
    }

}
