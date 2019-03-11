package capstone.bcs.lifo.controllers.testcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestIndexController {

    @RequestMapping("/testindex")
    public String getPage(){
        return "/testpages/testindex";
    }
}
