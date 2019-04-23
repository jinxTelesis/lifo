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

import javax.servlet.http.HttpServletRequest;
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


    @RequestMapping({"/indexRev"})
    public String getIndexByProductCat(Model model){
        //model.addAttribute("products", productService.getProductsByCategory(4));

        model.addAttribute("products", productService.getProductsDesc());
        model.addAttribute("LoginForm", new LoginForm());
        return "index";
    }

    @RequestMapping({"/products/indexRev"})
    public String getIndexByProductCatHotFix(Model model){
        //model.addAttribute("products", productService.getProductsByCategory(4));

        model.addAttribute("products", productService.getProductsDesc());
        model.addAttribute("LoginForm", new LoginForm());
        return "index";
    }

//    @RequestMapping("/indexRev/{id}")
//    public String getPageVar(HttpServletRequest request,@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("LoginForm", new LoginForm());
//        return "indexRev";
//    }



}
