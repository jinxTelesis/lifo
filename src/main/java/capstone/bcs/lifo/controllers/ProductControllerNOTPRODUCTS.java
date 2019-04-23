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
public class ProductControllerNOTPRODUCTS {

    private ProductService productService;


    @Autowired // intention only
    ProductControllerNOTPRODUCTS(ProductService productService){
        this.productService = productService;
    }

    //@RequestMapping("/product")
    public String getProduct(){

        return "redirect:/index";
    }

    @RequestMapping("/product/{id}")
    public String getProductById(HttpServletRequest request, @PathVariable Integer id, Model model){
        model.addAttribute("product", productService.findById(Integer.toUnsignedLong(id)));
        model.addAttribute("LoginForm", new LoginForm());
        return "redirect:" + "product";
    }



}
