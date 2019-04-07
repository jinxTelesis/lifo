package capstone.bcs.lifo.controllers.testcontrollers;

import capstone.bcs.lifo.services.CustomerService;
import capstone.bcs.lifo.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestIndexController {


    private final ProductService productService;
    private final CustomerService customerService;

    public TestIndexController(ProductService productService, CustomerService customerService) {
        this.productService = productService;
        this.customerService = customerService;
    }

    @RequestMapping("/testindex")
    public String getPage(){
        return "testpages/testindex";
    } // double check



    @RequestMapping("flowerpot")
    public String getIndexPage(Model model)
    {
        //model.addAttribute("products", productService.findById(1L));
        //model.addAttribute("products", productService.getProducts()); // this produces a list to iterater over
        model.addAttribute("product",productService.findById(1L)); // this produces the specific product
        // either have to change to a table format or fix it to 0-9 index on the spans
        return "testpages/bootstrapindextest";
    }

    @RequestMapping("/customerform")
    public String testCustomerPage(Model model)
    {
        //model.addAttribute("blank",customerService.getById(1l));
        return "register3";
    }

}
