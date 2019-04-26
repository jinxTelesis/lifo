package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.model.*;
import capstone.bcs.lifo.repositories.CartProductV2Repository;
import capstone.bcs.lifo.repositories.CartV2Repository;
import capstone.bcs.lifo.repositories.CustomerV2Repository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class CompareController {

    private CartV2Repository cartV2Repository;
    private CustomerV2Repository customerV2Repository;
    private CartProductV2Repository cartProductV2Repository;

    CompareController(CartV2Repository cartV2Repository, CustomerV2Repository customerV2Repository,
    CartProductV2Repository cartProductV2Repository){
        this.cartV2Repository = cartV2Repository;
        this.customerV2Repository = customerV2Repository;
        this.cartProductV2Repository = cartProductV2Repository;

    }

    @RequestMapping("/compare")
    public String getPage(Model model){
        model.addAttribute("LoginForm", new LoginForm());

//        CartV2 cartV2 = new CartV2();
//        CustomerV2 customerV2 = new CustomerV2();
//        customerV2.setpLastName("ted");
//        customerV2.setpFirstName("dead");
//        customerV2.setpDoB("tuesday");
//
//        customerV2.setCartV2(cartV2); // will this cause errors
//        Set<CartProductV2> productSet = new HashSet<>();
//        CartProductV2 cartProductV2 = new CartProductV2();
//        cartProductV2.setProductId(1);
//        cartProductV2.setProductPrice(9.99);
//        cartProductV2.setProductNumber(3);
//        cartProductV2.setCartV2(cartV2);
//        productSet.add(cartProductV2);
//
//        cartV2.setProductSet(productSet);
//        cartV2.setCustomerV2(customerV2);
//        cartV2Repository.save(cartV2);



//        Optional<CartV2> cart = cartV2Repository.findById(1l);
//        CartV2 normCart = cart.get();

        //System.out.println(normCart.getCustomerV2().getpFirstName());



        return "compare";
    }

    @RequestMapping("/compare.html")
    public String getPage2(Model model){
        model.addAttribute("LoginForm", new LoginForm());
        return "compare";
    }

    @RequestMapping("/products/compare")
    public String getPageHotFix(Model model){
        model.addAttribute("LoginForm", new LoginForm());





        return "compare";
    }


    // == test remove right away == //
//    @RequestMapping("/compare/{id}")
//    public String getPageVar(HttpServletRequest request, @PathVariable("id") Integer id, Model model) {
//        model.addAttribute("LoginForm", new LoginForm());
//        return "redirect:" + "/compare";
//    }


}
