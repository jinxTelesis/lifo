package capstone.bcs.lifo.controllers;

import capstone.bcs.lifo.services.TestHibernateEntityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@RequestMapping("realprojectpages")

@Controller // == applies to all of them
public class HomeController {

    private final TestHibernateEntityService testHibernateEntityService;

    public HomeController(TestHibernateEntityService testHibernateEntityService) {
        this.testHibernateEntityService = testHibernateEntityService;
    }

    @RequestMapping("/home") // == options in browser that map to the return ==
    public String getPage(){
        return "home"; // == page it directs to. You don't need to make the 3 different options ==
        // == the page it directs to will be in resources under templates with the return {fill in return name}.html ==
    }

    @GetMapping("/home/{id}/category")
    public String showById(@PathVariable String id, Model model) {

    model.addAttribute("category", testHibernateEntityService.getById(new Long(id)));

    return "recipe/show";

    }

}
