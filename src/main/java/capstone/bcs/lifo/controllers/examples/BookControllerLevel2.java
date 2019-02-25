package capstone.bcs.lifo.controllers.examples;


import capstone.bcs.lifo.repositories.examples.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 1/10/17.
 */

@Controller
public class BookControllerLevel2 {

    // == instantiation of repo with crud operations
    private BookRepository bookRepository;

    // == just a constructor ==
    public BookControllerLevel2(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    // == the html has to be strict because thymeleaf will parse it wrong otherwise ==
    // == you can put it into a website to validate if it is strictly compliant ==

    @RequestMapping("/books") // == options in browser that map to the return ==
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "books";  // == page it directs to. You don't need to make the 3 different options ==
        // == the page it directs to will be in resources under templates with the return {fill in return name}.html ==
    }
}
