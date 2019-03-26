package capstone.bcs.lifo.controllers;


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



    // keep as customer for now
    @RequestMapping("/register2")
    public String oldCustomer(Model model){
        model.addAttribute("registrationForm", new RegistrationForm());
        return "register2";
    }

}
