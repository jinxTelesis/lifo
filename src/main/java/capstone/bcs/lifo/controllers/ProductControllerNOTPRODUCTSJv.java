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


//@Controller
public class ProductControllerNOTPRODUCTSJv {

    /**
     * this controller displays specific products when a request is mapped to /product/ and it corresponding
     * number in the database the java version is disabled and the kotlin version is the on currently running
     */

    private ProductService productService;


    @Autowired // intention only
    ProductControllerNOTPRODUCTSJv(ProductService productService){
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