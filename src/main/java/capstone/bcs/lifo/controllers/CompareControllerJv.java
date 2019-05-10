package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.model.*;
import capstone.bcs.lifo.repositories.CartProductV2Repository;
import capstone.bcs.lifo.repositories.CartV2Repository;
import capstone.bcs.lifo.repositories.CustomerV2Repository;
import capstone.bcs.lifo.services.ProductService;
import capstone.bcs.lifo.util.CartUtil;
import capstone.bcs.lifo.util.SessionTransitionUtil;
import capstone.bcs.lifo.util.ValidSessionDataUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

//@Controller
public class CompareControllerJv {

    private CartV2Repository cartV2Repository;
    private CustomerV2Repository customerV2Repository;
    private CartProductV2Repository cartProductV2Repository;
    private ProductService productService;

    CompareControllerJv(CartV2Repository cartV2Repository, CustomerV2Repository customerV2Repository,
                      CartProductV2Repository cartProductV2Repository, ProductService productService){
        this.cartV2Repository = cartV2Repository;
        this.customerV2Repository = customerV2Repository;
        this.cartProductV2Repository = cartProductV2Repository;
        this.productService = productService;

    }

    @RequestMapping("/compare")
    public String getPage(Model model, HttpSession session){
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());

        SessionTransitionUtil sU = new SessionTransitionUtil();
        session = sU.AnonSession(session);
        return "compare";
    }


    @RequestMapping("/products/compare")
    public String getPageHotFix(Model model, HttpSession session){
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "compare";
    }

}