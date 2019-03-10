package capstone.bcs.lifo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductSummaryController {

    @RequestMapping("/product_summary")
    public String getPage(){
        return "product_summary";
    }
}
