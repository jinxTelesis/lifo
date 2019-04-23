package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.model.Account;
import capstone.bcs.lifo.model.Cart;
import capstone.bcs.lifo.model.Customer;
import capstone.bcs.lifo.model.SimpleCart;
import capstone.bcs.lifo.services.CustomerService;
import capstone.bcs.lifo.services.PasswordEncryptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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

                Customer localCust;
                localCust = customerService.getByUserName(loginForm.getUserName());
                System.out.println(loginForm.getUserName()); // valid here form works


                if(localCust.getpFirstName() == "")
                {
                    System.out.println("it was null");
                }

                Account localAccount = localCust.getAccount();

                if(passwordEncryptionService.checkPassword(loginForm.getPasswordPlain(),localAccount.getEncryptedPassword()))
                {
                    System.out.println("Valid user");


                    //Cart cart = new Cart();
                    //session.setAttribute("cart", cart);

                    SimpleCart cart = new SimpleCart();
                    session.setAttribute("cart",cart);



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
