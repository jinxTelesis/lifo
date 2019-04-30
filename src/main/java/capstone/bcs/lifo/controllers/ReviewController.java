package capstone.bcs.lifo.controllers;

import capstone.bcs.lifo.services.ProductService;
import capstone.bcs.lifo.util.ValidSessionDataUtil;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Component
public class ReviewController {

    private ProductService productService;

    ReviewController(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping("/review/{id}")
    public String getProductById(Model model, @PathVariable Integer id, HttpSession session) {
        model.addAttribute("product", productService.findById(Integer.toUnsignedLong(id)));
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());

        return "review";
    }

}