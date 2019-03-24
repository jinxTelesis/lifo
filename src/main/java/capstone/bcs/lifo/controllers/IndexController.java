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
        return "index2";
    }

    @RequestMapping({"/indexRev"})
    public String getIndexByProductCat(Model model){
        //model.addAttribute("products", productService.getProductsByCategory(4));

        model.addAttribute("products", productService.getProductsDesc());
        return "index2";
    }

    // change this back dude
//    @RequestMapping("/index2/{productCat}")
//    public String getPage(@PathVariable String productCat, Model model){
//        model.addAttribute("products", productService.getProductsByCategory(Integer.valueOf(productCat)));
//        return "index2";
//    }

    @RequestMapping("/index2")
    public String getPage2(Model model){
        model.addAttribute("products", productService.getProducts());
        return "index2";
    }

    @RequestMapping("/frag/1")
    public String fixedFrag1(Model model) {
        model.addAttribute("products",productService.getProducts());
        return "fragments/productdiv2 :: productdiv2";
    }



}
