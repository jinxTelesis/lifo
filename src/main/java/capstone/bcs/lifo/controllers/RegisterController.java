package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.commands.RegistrationForm;
import capstone.bcs.lifo.model.Customer;
import capstone.bcs.lifo.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegisterController {

    // cd to in bin of mariadb install location
    // mysqld --console
    // if it refused to connect your db is not on
    // might need to have admin privilege

    private CustomerService customerService;

    RegisterController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @RequestMapping("/register")
    public String oldCustomer(Model model){
        System.out.println("the general page got called");
        model.addAttribute("registrationForm", new RegistrationForm());
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String saveOrUpdate(@Valid RegistrationForm registrationForm, BindingResult bindingResult) {
        System.out.println("general post got called");

        if(bindingResult.hasErrors())
        {
            System.out.println("the form return got called");
            return "register";
        }
        else
        {
            System.out.println("The new customer form got called");
            Customer newCustomer = customerService.saveOrUpdateRegistrationForm(registrationForm);
            return "register"; // this needs to be a new page for success
        }
    }
}
