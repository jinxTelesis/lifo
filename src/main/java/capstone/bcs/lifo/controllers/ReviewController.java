package capstone.bcs.lifo.controllers;

import capstone.bcs.lifo.services.ProductService;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Component
public class ReviewController {

    private ProductService productService;

    ReviewController(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping("/review/{id}")
    public String getProductById(Model model, @PathVariable Integer id) {
        model.addAttribute("product", productService.findById(Integer.toUnsignedLong(id)));
        //model.addAttribute("LoginForm", new LoginForm());
        return "review";
    }

}
