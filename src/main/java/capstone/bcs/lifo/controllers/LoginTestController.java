package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.model.*;
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
public class LoginTestController {

    private CustomerService customerService;
    private PasswordEncryptionService passwordEncryptionService;


    LoginTestController(CustomerService customerService, PasswordEncryptionService passwordEncryptionService){
        this.passwordEncryptionService = passwordEncryptionService;
        this.customerService = customerService;
    }

    @RequestMapping("/loginstart")
    public String getLogin(Model model){
        model.addAttribute("LoginForm", new LoginForm());
        return "loginstart";
    }

//    @RequestMapping("/loginstart/{id}")
//    public String getPageVar(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("LoginForm", new LoginForm());
//        return "loginstart";
//    }

    @RequestMapping("/unauthorized_user")
    public String invalidUser(){
        return "unauthorized_user";
    }

    //todo this slop should be refactored

    @RequestMapping(value = "/loginstart",method = RequestMethod.POST) // two post methods have mapping issues
    public String validateUser2(Model model, @Valid LoginForm loginForm, BindingResult bindingResult, HttpSession session){

        model.addAttribute("LoginForm", new LoginForm());
        if(bindingResult.hasErrors())
        {
            System.out.println("login had errors");
            return "loginstart";
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
                    System.out.println("I love chicken");
                    String myString = "mybasicString";
                    String printString = "1";
                    session.setAttribute("turkey",myString);
                    System.out.println("Valid user");


                    printString = (String)session.getAttribute("turkey");
                    System.out.println(printString);
                    return "success";
                }
                else {
                    System.out.println("login password invalid");
                    return "loginstart";
                }

            }
            catch(NullPointerException e)
            {
                System.out.println("User name not found");
                return "loginstart";
            }
        }
    }
}

