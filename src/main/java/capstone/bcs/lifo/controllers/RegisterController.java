package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.commands.CustomerForm;
import capstone.bcs.lifo.commands.RegistrationForm;
import capstone.bcs.lifo.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String getPage(){
        return "register";
    }


//    @RequestMapping("/new")
//    public String newCustomer(Model model){
//        model.addAttribute("customerForm", new CustomerForm());
//        return "customerform";
//    }

    // keep as customer for now
    @RequestMapping("/old")
    public String oldCustomer(Model model){
        model.addAttribute("registrationForm", new RegistrationForm());
        return "customerform";
    }

    //
}
