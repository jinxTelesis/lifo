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

    @RequestMapping("/authors")
    public String getAuthor(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "authors"; // html
    }
}
