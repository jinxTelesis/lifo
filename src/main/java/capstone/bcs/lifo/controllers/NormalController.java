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
public class NormalController {

    @RequestMapping("/normal")
    public String getPage(Model model, HttpSession session){
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "examples/normal";
    }

    @RequestMapping("/prdocuts/normal")
    public String getPageHotFix(Model model, HttpSession session){
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "examples/normal";
    }

//    @RequestMapping("/normal/{id}")
//    public String getPageVar(HttpServletRequest request, @PathVariable("id") Integer id, Model model) {
//        model.addAttribute("LoginForm", new LoginForm());
//        return "redirect:" + "examples/normal";
//    }

}