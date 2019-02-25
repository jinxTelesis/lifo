package capstone.bcs.lifo.controllers.examples;


import capstone.bcs.lifo.repositories.examples.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorControllerLevel2 {

    private AuthorRepository authorRepository;

    public AuthorControllerLevel2(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    // == the html has to be strict because thymeleaf will parse it wrong otherwise ==
    // == you can put it into a website to validate if it is strictly compliant ==

    @RequestMapping("/authors") // == options in browser that map to the return ==
    public String getAuthor(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "authors";  // == page it directs to. You don't need to make the 3 different options ==
        // == the page it directs to will be in resources under templates with the return {fill in return name}.html ==
    }
}
