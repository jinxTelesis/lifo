package capstone.bcs.lifo.controllers.examples;


import capstone.bcs.lifo.repositories.examples.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookControllerLevel2 {

    private BookRepository bookRepository;

    public BookControllerLevel2(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books") // the html name it is mapped to
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "books"; // == html page it goes to, does not have to be same ==
    }
}
