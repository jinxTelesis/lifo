package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.model.Account;
import capstone.bcs.lifo.model.CartV2;
import capstone.bcs.lifo.model.CustomerV2;
import capstone.bcs.lifo.repositories.CartV2Repository;
import capstone.bcs.lifo.repositories.ProductRepository;
import capstone.bcs.lifo.services.CartService;
import capstone.bcs.lifo.services.CustomerService;
import capstone.bcs.lifo.services.PasswordEncryptionService;
import capstone.bcs.lifo.util.ValidSessionDataUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginControllerJv {

    private CustomerService customerService;
    private PasswordEncryptionService passwordEncryptionService;
    private CartService cartService;


    LoginControllerJv(CustomerService customerService, PasswordEncryptionService passwordEncryptionService, CartService cartService){
        this.passwordEncryptionService = passwordEncryptionService;
        this.customerService = customerService;
        this.cartService = cartService;
    }

    @RequestMapping("/login")
    public String getPageLoginInvalid(Model model, HttpSession session){
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        model.addAttribute("LoginForm", new LoginForm());
        return "login";
    }

    @RequestMapping(value = "/login_form",method = RequestMethod.POST) // two post methods have mapping issues
    public String validateUser2Invalid(Model model, @Valid LoginForm loginForm, BindingResult bindingResult, HttpSession session){
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());

        model.addAttribute("LoginForm", new LoginForm());
        if(bindingResult.hasErrors())
        {
            System.out.println("login had errors");
            return "login";
        }
        else
        {
            try{

                CustomerV2 localCustV2;
                try {
                    localCustV2 = customerService.getByUserName(loginForm.getUserName());
                } catch (IndexOutOfBoundsException e)
                {
                    System.out.println("the database had zero users in it");
                    return "login";
                }
                System.out.println(loginForm.getUserName());

                if(localCustV2.getpFirstName() == "")
                {
                    System.out.println("it was null");
                }

                Account localAccount = localCustV2.getAccount();

                if(passwordEncryptionService.checkPassword(loginForm.getPasswordPlain(),localAccount.getEncryptedPassword()))
                {
                    System.out.println("Valid user");

                    //ToDO intergrate both
//                    CartV2 cartV2 = null;
//                    cartV2 = (CartV2)session.getAttribute("cart"); // this transfers the session cart
//                    // need to add session cart to any stored cart
//
//                    localCustV2.getAccount();
//                    cartV2.setCustomerV2(localCustV2); // this will set just the customer
//
//                    session.setAttribute("cart",cartV2);
                    //ToDO integrate both

                    CartV2 cartV2 = null;
                    cartV2 = cartService.findByUserName(loginForm.getUserName()); // this part not found?
                    // this is throwing a npe at the wrong point
                    cartV2.setCustomerV2(localCustV2);
                    session.setAttribute("cart",cartV2);
                    return "success";
                }
                else {
                    System.out.println("login password invalid");
                    return "login";
                }

            }
            catch(NullPointerException e)
            {
                System.out.println("User name not found");
                return "login";
            }
        }
    }
}