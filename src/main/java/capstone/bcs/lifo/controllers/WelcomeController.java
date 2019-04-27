package capstone.bcs.lifo.controllers;

import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.util.ValidSessionDataUtil;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Component
public class WelcomeController {

    @RequestMapping("/faq2")
    public String getPage(Model model, HttpSession session){
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "faq";
    }
}
