package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.util.ValidSessionDataUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ContactController {

    @RequestMapping("/contact")
    public String getPage(Model model){
        model.addAttribute("LoginForm", new LoginForm());
        return "contact";
    }

    @RequestMapping("/products/contact")
    public String getPageHotFix(Model model){
        model.addAttribute("LoginForm", new LoginForm());
        return "contact";
    }


    @RequestMapping("/contact/**")
    public String getPageAnt(Model model,HttpServletRequest request){
        model.addAttribute("LoginForm", new LoginForm());
        System.out.println(request.getRequestURI());
        String newUrl = request.getRequestURI();
        newUrl.replace("/contact","");
        return newUrl;
    }

}
