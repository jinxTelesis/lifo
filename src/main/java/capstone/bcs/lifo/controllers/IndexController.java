package capstone.bcs.lifo.controllers;

import capstone.bcs.lifo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    // == the main page should have /.html
    //@RequestMapping({"/","/index","/.html","/index.html"})
    public String index(){
        return "index3";
    }

    private ProductService productService;

    @Autowired // intention
    IndexController(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping({"/","/index","/.html","/index.html"})
    public String getIndex(Model model){
        model.addAttribute("products", productService.getProducts());
        return "index3";
    }

}
