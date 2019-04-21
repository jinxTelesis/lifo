package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.commands.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CompareController {

    @RequestMapping("/compare")
    public String getPage(Model model){
        model.addAttribute("LoginForm", new LoginForm());
        return "compare";
    }

    // == test remove right away == //
    @RequestMapping("/compare/{id}")
    public String getPageVar(HttpServletRequest request, @PathVariable("id") Integer id, Model model) {
        model.addAttribute("LoginForm", new LoginForm());
        return "redirect:" + "/compare";
    }


}
