package capstone.bcs.lifo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TacController {

    @RequestMapping("/tac")
    public String getPage() {
        return "tac";
    }

}
