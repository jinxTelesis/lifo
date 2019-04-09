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

    // change this back if you don't want them sorted

    @RequestMapping("/products")
    public String getPage(Model model){
        //model.addAttribute("products", productService.getProducts());
        model.addAttribute("products",productService.getProductSet());
        return "products";
    }


    @RequestMapping("/products/{productCat}")
    public String getPage(@PathVariable String productCat, Model model){
        model.addAttribute("products", productService.getProductsByCategory(Integer.valueOf(productCat)));
        //model.addAttribute("products",productService.getProducts());
        return "products";
    }

    // == the javascript drops out when the path variable is passed in == investigating changing the thyemeleaf ==
    // == this is temporary hack solution to the problem that will be removed later ==
    // == the products should just be mapped with a category but the javascript issue is why this is done this way
    // == hopefully this will be removed to just /products/{productCat} soon ==

    @RequestMapping("/products_accessories")
    public String getAccessories(Model model)
    {
        model.addAttribute("products", productService.getProductsByCategory(0));
        return "products_accessories";
    }

    @RequestMapping("/products_appliances")
    public String getAppliances(Model model)
    {
        model.addAttribute("products",productService.getProductsByCategory(1));
        return "products_appliances";
    }

    @RequestMapping("/products_cleaning")
    public String getCleaning(Model model)
    {
        model.addAttribute("products",productService.getProductsByCategory(2));
        return "products_cleaning";
    }

    @RequestMapping("/products_hardware")
    public String getHardware(Model model)
    {
        model.addAttribute("products",productService.getProductsByCategory(3));
        return "products_hardware";
    }

    @RequestMapping("/products_health")
    public String getHealth(Model model)
    {
        model.addAttribute("products",productService.getProductsByCategory(4));
        return "products_health";
    }

    @RequestMapping("/products_home")
    public String getHome(Model model)
    {
        model.addAttribute("products",productService.getProductsByCategory(5));
        return "products_home";
    }

    @RequestMapping("/products_toys")
    public String getToys(Model model)
    {
        model.addAttribute("products",productService.getProductsByCategory(6));
        return "products_toys";
    }




}
