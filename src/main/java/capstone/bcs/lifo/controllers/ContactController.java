package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.commands.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ContactController {

    @RequestMapping("/contact")
    public String getPage(Model model){
        model.addAttribute("LoginForm", new LoginForm());
        return "contact";
    }

//    @RequestMapping("/contact/{id}")
//    public String getPageVar(HttpServletRequest request, @PathVariable("id") Integer id, Model model) {
//        model.addAttribute("LoginForm", new LoginForm());
//        return "redirect:" + "/contact";
//    }

//    @RequestMapping("/contact/**")
//    public String getPageAnt(HttpServletRequest request,Model model){
//        model.addAttribute("LoginForm", new LoginForm());
//        System.out.println(request.getRequestURI());
//        return "contact";
//    }

    @RequestMapping("/contact/**")
    public String getPageAnt(Model model,HttpServletRequest request){
        model.addAttribute("LoginForm", new LoginForm());
        System.out.println(request.getRequestURI());
//        String what = request.getHeader("contact");
//        System.out.println("this is getHeader" + what);
//        System.out.println(request.getContextPath());
//        long what2 = request.getDateHeader("contact");
//        System.out.println("this is getDateHeader" + what2);
        String newUrl = request.getRequestURI();
        newUrl.replace("/contact","");
        return newUrl;
    }

}
