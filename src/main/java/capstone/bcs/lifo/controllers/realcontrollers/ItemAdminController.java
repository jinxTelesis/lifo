package capstone.bcs.lifo.controllers.realcontrollers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//@RequestMapping("realprojectpages")
@Controller
public class ItemAdminController {

    @RequestMapping("/itemadmin") // == options in browser that map to the return ==
    public String getPage(){
        return "itemadmin"; // == page it directs to. You don't need to make the 3 different options ==
        // == the page it directs to will be in resources under templates with the return {fill in return name}.html ==
    }
}
