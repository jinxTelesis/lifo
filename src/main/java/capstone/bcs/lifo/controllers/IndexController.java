package capstone.bcs.lifo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    // == the main page should have /.html
    @RequestMapping({"/","/index","/.html","/index.html"})
    public String index(){
        return "index2";
    }

}
