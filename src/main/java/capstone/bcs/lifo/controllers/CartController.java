package capstone.bcs.lifo.controllers;

import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CartController {

    @RequestMapping({"/cart"})
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
        return "product_summary.html";
    }

    // == the redirect is needed or it will map deeper // //

    @RequestMapping("/cart/{id}")
    public String getPageVar(HttpServletRequest request,@PathVariable("id") Integer id, Model model) {
        String referer = request.getHeader("Referer");
        model.addAttribute("LoginForm", new LoginForm());
        //return "/product_summary";
        return "redirect:" + referer;
    }

    @RequestMapping("/cart/{id}/{id}")
    public String getPageVarVar(HttpServletRequest request,@PathVariable("id") Integer id, Model model) {
        String referer = request.getHeader("Referer");
        model.addAttribute("LoginForm", new LoginForm());
        //return "/product_summary";
        return "redirect:" + referer;
    }

    @RequestMapping("/cart/{id}/{id}/{id}")
    public String getPageVarVarVar(HttpServletRequest request,@PathVariable("id") Integer id, Model model) {
        String referer = request.getHeader("Referer");
        model.addAttribute("LoginForm", new LoginForm());
        //return "/product_summary";
        return "redirect:" + referer;
    }



}
