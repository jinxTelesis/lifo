package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.commands.RegistrationForm;
import capstone.bcs.lifo.model.*;
import capstone.bcs.lifo.repositories.CartV2Repository;
import capstone.bcs.lifo.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;
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
    public String oldCustomer(Model model){
        System.out.println("the general page got called");
        model.addAttribute("registrationForm", new RegistrationForm());
        model.addAttribute("LoginForm", new LoginForm());
        return "register";
    }

    @RequestMapping("/products/register")
    public String oldCustomerHotFix(Model model){
        System.out.println("the general page got called");
        model.addAttribute("registrationForm", new RegistrationForm());
        model.addAttribute("LoginForm", new LoginForm());
        return "register";
    }

    @RequestMapping("/register/{id}")
    public String getPageVar(HttpServletRequest request, @PathVariable("id") Integer id, Model model) {
        model.addAttribute("LoginForm", new LoginForm());
        model.addAttribute("registrationForm", new RegistrationForm());
        return "redirect:" + "register";
    }


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String saveOrUpdate(Model model,@Valid RegistrationForm registrationForm, BindingResult bindingResult) {
        model.addAttribute("LoginForm", new LoginForm());
        System.out.println("general post got called");

        if(bindingResult.hasErrors())
        {
            System.out.println("the form return got called");
            return "register";
        }
        else
        {
            System.out.println("The new customer form got called");
            CustomerV2 customerV2 = customerService.saveOrUpdateRegistrationForm(registrationForm);
            CartV2 cartV2 = new CartV2();// this is the outer
            //customerV2.setCartV2(cartV2);
            //cartV2.setCustomerV2(customerV2);
            // this is a blank productset
            Set<CartProductV2> productSet = new HashSet<>();
            CartProductV2 cartProductV2 = new CartProductV2();
            cartProductV2.setCartV2(cartV2);
            productSet.add(cartProductV2);

            // here we set the customer in cart but not the other way around

            cartV2.setProductSet(productSet);
            cartV2.setCustomerV2(customerV2);
            cartV2Repository.save(cartV2);

            return "product_summary"; // this needs to be a new page for success
        }
    }


}
