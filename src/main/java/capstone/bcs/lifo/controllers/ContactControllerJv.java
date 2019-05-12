package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.util.ValidSessionDataUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//@Controller
public class ContactControllerJv {

    /**
     * this is the contact controller, it display mostly static content
     * this controller is currently disabled and the kotlin version is running
     * this controller is left in the source because only 1 of our developers knows kotlin
     *
     */

    @RequestMapping("/contact")
    public String getPage(Model model,HttpSession session){
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "contact";
    }

    @RequestMapping("/products/contact")
    public String getPageHotFix(Model model, HttpSession session){
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "contact";
    }


    @RequestMapping("/contact/**")
    public String getPageAnt(Model model,HttpServletRequest request, HttpSession session){
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        System.out.println(request.getRequestURI());
        String newUrl = request.getRequestURI();
        newUrl.replace("/contact","");
        return newUrl;
    }

}
