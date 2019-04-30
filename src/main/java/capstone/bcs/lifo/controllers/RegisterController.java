package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.commands.RegistrationForm;
import capstone.bcs.lifo.model.*;
import capstone.bcs.lifo.repositories.CartV2Repository;
import capstone.bcs.lifo.services.CustomerService;
import capstone.bcs.lifo.util.SessionTransitionUtil;
import capstone.bcs.lifo.util.ValidSessionDataUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class RegisterController {


    private CustomerService customerService;
    private CartV2Repository cartV2Repository;

    RegisterController(CustomerService customerService, CartV2Repository cartV2Repository) {
        this.customerService = customerService;
        this.cartV2Repository = cartV2Repository;
    }


    @RequestMapping("/register")
    public String oldCustomer(Model model, HttpSession session){
        model.addAttribute("registrationForm", new RegistrationForm());
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "register";
    }

    @RequestMapping("/products/register")
    public String oldCustomerHotFix(Model model, HttpSession session){
        model.addAttribute("registrationForm", new RegistrationForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        model.addAttribute("LoginForm", new LoginForm());
        return "register";
    }

    @RequestMapping("/register/{id}")
    public String getPageVar(HttpServletRequest request, HttpSession session,@PathVariable("id") Integer id, Model model) {
        model.addAttribute("LoginForm", new LoginForm());
        model.addAttribute("registrationForm", new RegistrationForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "redirect:" + "register";
    }


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String saveOrUpdate(Model model,@Valid RegistrationForm registrationForm, BindingResult bindingResult, HttpSession session) {
        SessionTransitionUtil sU = new SessionTransitionUtil();
        session = sU.AnonSession(session);


        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());

        if(bindingResult.hasErrors())
        {
            System.out.println("the form return got called");
            return "register";
        }
        else
        {
            System.out.println("The new customer form got called");

            // the registration form is being altered to save session data

            CustomerV2 customerV2 = customerService.saveOrUpdateRegistrationForm(registrationForm);
            
            // get session cart and pull cart details from it
            CartV2 localCart = (CartV2)session.getAttribute("cart");
            localCart.setAnnonoymousAccount(false);
            localCart.setCustomerV2(customerV2);

            // saves the session again
            session.setAttribute("cart",localCart); // after registration we go to cart
            // session now have user details

            cartV2Repository.save(localCart);

            return "product_summary"; // this needs to be a new page for success
        }
    }


}