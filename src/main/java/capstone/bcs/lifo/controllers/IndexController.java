package capstone.bcs.lifo.controllers;

import capstone.bcs.lifo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    // == the main page should have /.html
    //@RequestMapping({"/","/index","/.html","/index.html"})
    public String index(){
        return "index";
    }

    private ProductService productService;

    @Autowired // intention
    IndexController(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping({"/","/index","/.html","/index.html"})
    public String getIndex(Model model){
        model.addAttribute("products", productService.getProductsAsce());
        return "index";
    }

    @RequestMapping({"/indexRev"})
    public String getIndexByProductCat(Model model){
        //model.addAttribute("products", productService.getProductsByCategory(4));

        model.addAttribute("products", productService.getProductsDesc());
        return "index";
    }

    @RequestMapping("index/{productCat}")
    public String getPage(@PathVariable String productCat, Model model){
        model.addAttribute("products", productService.getProductsByCategory(Integer.valueOf(productCat)));
        return "index";
    }

}
