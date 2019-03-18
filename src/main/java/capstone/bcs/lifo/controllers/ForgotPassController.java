package capstone.bcs.lifo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForgotPassController {
    @RequestMapping("/forgetpass")
    public String getPage(){
        return "forgetpass";
    }
}