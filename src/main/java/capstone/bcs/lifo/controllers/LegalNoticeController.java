package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.commands.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LegalNoticeController {

    @RequestMapping("/legal_notice")
    public String getPage(Model model){
        model.addAttribute("LoginForm", new LoginForm());
        return "legal_notice";
    }


    @RequestMapping("/legal_notice/{id}")
    public String getPageVar(HttpServletRequest request, @PathVariable("id") Integer id, Model model) {
        model.addAttribute("LoginForm", new LoginForm());
        return "redirect:" + "/legal_notice";
    }

}
