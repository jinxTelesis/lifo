package capstone.bcs.lifo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LegalNoticeController {

    @RequestMapping("/legal_notice")
    public String getPage(){
        return "legal_notice";
    }
}
