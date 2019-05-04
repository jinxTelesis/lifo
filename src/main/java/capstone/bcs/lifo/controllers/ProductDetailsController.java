package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.services.ProductService;
import capstone.bcs.lifo.util.ValidSessionDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ProductDetailsController {


    private ProductService productService;

    @Autowired
    ProductDetailsController(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping("/product_details")
    public String getPage(Model model, HttpSession session){
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "product_details";
    }

    @RequestMapping("/products/product_details")
    public String getPageHotFix(Model model,HttpSession session){
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "product_details";
    }

    @RequestMapping("/products/products/product_details")
    public String getPageHotFix2(Model model,HttpSession session){
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "product_details";
    }


    @RequestMapping("/product_details/{productID}")
    public String getPageOrder(HttpServletRequest request, @PathVariable String productID, Model model, HttpSession session){
        model.addAttribute("product", productService.findById(Long.valueOf(productID)));
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        String referer = request.getHeader("Referer");
        return "product_details";
    }

}