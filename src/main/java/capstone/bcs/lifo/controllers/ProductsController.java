package capstone.bcs.lifo.controllers;

import capstone.bcs.lifo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductsController {

    private ProductService productService;

    @Autowired
    ProductsController(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String getPage(Model model){
        model.addAttribute("products", productService.getProducts());
        return "products";
    }


    @RequestMapping("/products/{productCat}")
    public String getPage(@PathVariable String productCat, Model model){
        model.addAttribute("products", productService.getProductsByCategory(Integer.valueOf(productCat)));
        //model.addAttribute("products",productService.getProducts());
        return "products";
    }

}
