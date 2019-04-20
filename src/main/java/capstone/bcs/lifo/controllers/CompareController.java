package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.commands.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CompareController {

    @RequestMapping("/compare")
    public String getPage(Model model){
        model.addAttribute("LoginForm", new LoginForm());
        return "compare";
    }

}
