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
public class ProductControllerNOTPRODUCTS {

    private ProductService productService;


    @Autowired // intention only
    ProductControllerNOTPRODUCTS(ProductService productService){
        this.productService = productService;
    }


    @RequestMapping("/product/{id}")
    public String getProductByIdHotFix(HttpServletRequest request, @PathVariable String id, Model model, HttpSession session){
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        if(id.equals("product"))
        {
            model.addAttribute("product",productService.findById(1l));
            return "product";
        }
        model.addAttribute("product", productService.findById(Integer.toUnsignedLong(Integer.parseInt(id))));
        model.addAttribute("LoginForm", new LoginForm());
        return "product";
    }



}