package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.commands.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TacController {

    @RequestMapping("/tac")
    public String getPage(Model model) {
        model.addAttribute("LoginForm", new LoginForm());
        return "tac";
    }

    @RequestMapping("/tac/{id}")
    public String getPageVar(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("LoginForm", new LoginForm());
        return "tac";
    }

}
