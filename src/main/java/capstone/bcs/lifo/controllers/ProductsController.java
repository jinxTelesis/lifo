package capstone.bcs.lifo.controllers;

import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
        // == second model might cause issues
        model.addAttribute("LoginForm", new LoginForm());
        return "products";
    }


    @RequestMapping("/products/{productCat}")
    public String getPage(HttpServletRequest request,@PathVariable String productCat, Model model){
        model.addAttribute("products", productService.getProductsByCategory(Integer.valueOf(productCat)));
        model.addAttribute("LoginForm", new LoginForm());
        String referer = request.getHeader("Referer");
        //model.addAttribute("products",productService.getProducts());
        return "products";
        //return "redirect:" +referer;
    }


//    @RequestMapping("/products_accessories")
//    public String getAccessories(Model model)
//    {
//        // == second model might cause issues
//        model.addAttribute("products", productService.getProductsByCategory(0));
//        model.addAttribute("LoginForm", new LoginForm());
//
//
//        return "products_accessories";
//    }
//
//    @RequestMapping("/products_appliances")
//    public String getAppliances(Model model)
//    {
//        // == second model might cause issues
//        model.addAttribute("products",productService.getProductsByCategory(1));
//        model.addAttribute("LoginForm", new LoginForm());
//        return "products_appliances";
//    }
//
//    @RequestMapping("/products_cleaning")
//    public String getCleaning(Model model)
//    {
//        // == second model might cause issues
//        model.addAttribute("products",productService.getProductsByCategory(2));
//        model.addAttribute("LoginForm", new LoginForm());
//        return "products_cleaning";
//    }
//
//    @RequestMapping("/products_hardware")
//    public String getHardware(Model model)
//    {
//        // == second model might cause issues
//        model.addAttribute("products",productService.getProductsByCategory(3));
//        model.addAttribute("LoginForm", new LoginForm());
//        return "products_hardware";
//    }
//
//    @RequestMapping("/products_health")
//    public String getHealth(Model model)
//    {
//        // == second model might cause issues
//        model.addAttribute("products",productService.getProductsByCategory(4));
//        model.addAttribute("LoginForm", new LoginForm());
//        return "products_health";
//    }
//
//    @RequestMapping("/products_home")
//    public String getHome(Model model)
//    {
//        // == second model might cause issues
//        model.addAttribute("products",productService.getProductsByCategory(5));
//        model.addAttribute("LoginForm", new LoginForm());
//        return "products_home";
//    }
//
//    @RequestMapping("/products_toys")
//    public String getToys(Model model)
//    {
//        // == second model might cause issues
//        model.addAttribute("products",productService.getProductsByCategory(6));
//        model.addAttribute("LoginForm", new LoginForm());
//        return "products_toys";
//    }




}
