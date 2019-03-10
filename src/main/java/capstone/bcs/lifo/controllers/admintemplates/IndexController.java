package capstone.bcs.lifo.controllers.admintemplates;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static capstone.bcs.lifo.constants.Constants.ADMIN;



@Controller
public class IndexController {

    @RequestMapping("/" + ADMIN + "/index")
    public String getPage(){
        return "index";

    }
}
