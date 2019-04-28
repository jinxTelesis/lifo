package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.model.*;
import capstone.bcs.lifo.repositories.ProductRepository;
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
public class ProductSummaryController {

    private CustomerService customerService;
    private PasswordEncryptionService passwordEncryptionService;
    private ProductRepository productRepository;


    ProductSummaryController(CustomerService customerService, PasswordEncryptionService passwordEncryptionService){
        this.passwordEncryptionService = passwordEncryptionService;
        this.customerService = customerService;
    }


    @RequestMapping("/product_summary")
    public String getPageInalid(Model model, HttpSession session){
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "product_summary";
    }

    // == test controller remove after ==
//    @RequestMapping("/product_summary/{id}")
//    public String getPageVar(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("LoginForm", new LoginForm());
//        return "product_summary";
//    }

    @RequestMapping("/loginproduct_summary")
    public String getPageLoginInvalid(Model model, HttpSession session){
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        model.addAttribute("LoginForm", new LoginForm());
        return "product_summary";
    }


    @RequestMapping(value = "/loginproduct_summary",method = RequestMethod.POST) // two post methods have mapping issues
    public String validateUser2Invalid(Model model, @Valid LoginForm loginForm, BindingResult bindingResult, HttpSession session){
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());

        model.addAttribute("LoginForm", new LoginForm());
        if(bindingResult.hasErrors())
        {
            System.out.println("login had errors");
            return "product_summary";
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
                    return "product_summary";
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
                    CartV2 cartV2 = new CartV2();
                    localCustV2.getAccount();
                    cartV2.setCustomerV2(localCustV2); // this will set just the customer

                    session.setAttribute("cart",cartV2);
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
