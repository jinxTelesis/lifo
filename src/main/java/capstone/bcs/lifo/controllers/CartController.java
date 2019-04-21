package capstone.bcs.lifo.controllers;

import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
public class CartController {

    @RequestMapping("/cart")
    public String getPageLogin(Model model, HttpSession session){
        System.out.println("cart button worked!");
        model.addAttribute("LoginForm", new LoginForm());

//        String printString = "";
//        printString = (String)session.getAttribute("turkey");


        if(session.getAttribute("cart") != null)
        {
            Cart cart = null;
            cart = (Cart)session.getAttribute("cart");
            System.out.println("got the cart!!!!");
        }else{
            System.out.println("you need to login first buddy!");
            return "invalid_product_summary";
        }
        return "product_summary";
    }

}
