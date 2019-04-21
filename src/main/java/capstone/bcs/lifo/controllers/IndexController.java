package capstone.bcs.lifo.controllers;

import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.model.Account;
import capstone.bcs.lifo.model.Customer;
import capstone.bcs.lifo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

// start a registration page -


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
        model.addAttribute("LoginForm", new LoginForm());
        return "index";
    }

//    @RequestMapping(value = "/")
//    public String getIndex3(Model model){
//        //model.addAttribute("products", productService.getProductsAsce());
//        model.addAttribute("LofinForm", new LoginForm());
//        return "index :: navigation";
//    }


//    @RequestMapping(value = "/logintestfrag", method = RequestMethod.GET)
//    public String getIndex2(Model model){
//        return "index :: navigation";
//    }


    @RequestMapping({"/indexRev"})
    public String getIndexByProductCat(Model model){
        //model.addAttribute("products", productService.getProductsByCategory(4));

        model.addAttribute("products", productService.getProductsDesc());
        model.addAttribute("LoginForm", new LoginForm());
        return "index2";
    }



    // == does it but turns off javascript?? wtf ==
//    @RequestMapping({"/index/{product}"})
//    public String getPage(@PathVariable String product, Model model) {
//        model.addAttribute("products",productService.getProductsByCategory(Integer.valueOf(product)));
//        return "index2";
//    }


//    @RequestMapping("/index/{productCat}")
//    public String getPage(@PathVariable String productCat, Model model){
//        model.addAttribute("products", productService.getProductsByCategory(Integer.valueOf(productCat)));
//        return "index";
//    }





}
