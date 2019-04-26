package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.model.*;
import capstone.bcs.lifo.services.CustomerService;
import capstone.bcs.lifo.services.PasswordEncryptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ProductSummaryController {

    private CustomerService customerService;
    private PasswordEncryptionService passwordEncryptionService;


    ProductSummaryController(CustomerService customerService, PasswordEncryptionService passwordEncryptionService){
        this.passwordEncryptionService = passwordEncryptionService;
        this.customerService = customerService;
    }


    @RequestMapping("/product_summary")
    public String getPageInalid(Model model){
        model.addAttribute("LoginForm", new LoginForm());
        return "product_summary";
    }

    // == test controller remove after ==
//    @RequestMapping("/product_summary/{id}")
//    public String getPageVar(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("LoginForm", new LoginForm());
//        return "product_summary";
//    }

    @RequestMapping("/loginproduct_summary")
    public String getPageLoginInvalid(Model model){
        model.addAttribute("LoginForm", new LoginForm());
        return "product_summary";
    }


    @RequestMapping(value = "/loginproduct_summary",method = RequestMethod.POST) // two post methods have mapping issues
    public String validateUser2Invalid(Model model, @Valid LoginForm loginForm, BindingResult bindingResult, HttpSession session){

        model.addAttribute("LoginForm", new LoginForm());
        if(bindingResult.hasErrors())
        {
            System.out.println("login had errors");
            return "product_summary";
        }
        else
        {
            // this threw a npe v
            try{
                // in the database just called username

                CustomerV2 localCustV2;
                localCustV2 = customerService.getByUserName(loginForm.getUserName());
                System.out.println(loginForm.getUserName());




                if(localCustV2.getpFirstName() == "")
                {
                    System.out.println("it was null");
                }


                Account localAccount = localCustV2.getAccount();

                if(passwordEncryptionService.checkPassword(loginForm.getPasswordPlain(),localAccount.getEncryptedPassword()))
                {
                    System.out.println("Valid user");
                    CartV2 cartV2 = new CartV2(); // this is just an empty cart right now dingus
                    localCustV2.getAccount();
                    System.out.println(localCustV2.getAccount().getUsername() + " nothing printed"); // curious is this has any data
                    cartV2.setCustomerV2(localCustV2); // this will set just the customer

                    session.setAttribute("cart",cartV2);

                    // retrevial of data attempt
                    CartV2 cart3 = new CartV2();
                    cart3 = (CartV2)session.getAttribute("cart");

                    System.out.println(cart3.getCustomerV2().getpFirstName() + " this is the session information in the password service");

                    // make a real save to cart here???
                    return "success";
                }
                else {
                    System.out.println("login password invalid");
                    return "product_summary";
                }

            }
            catch(NullPointerException e)
            {
                System.out.println("User name not found");
                return "product_summary";
            }
        }
    }
}
