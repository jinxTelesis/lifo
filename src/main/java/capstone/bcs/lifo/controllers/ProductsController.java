package capstone.bcs.lifo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductsController {

    @RequestMapping("/compare")
    public String getPage(){
        return "compare";
    }
}
