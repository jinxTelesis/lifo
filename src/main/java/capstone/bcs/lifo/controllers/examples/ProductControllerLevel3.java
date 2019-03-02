package capstone.bcs.lifo.controllers.examples;

import capstone.bcs.lifo.commands.example.ExampleProductForm;
import capstone.bcs.lifo.converters.examples.ProductToProductForm;
import capstone.bcs.lifo.model.examples.Product;
import capstone.bcs.lifo.services.examples.ExampleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by jt on 1/10/17. guy that does a spring course
 */

//@Controller == intentionally disable
public class ProductControllerLevel3 {

    private ExampleProductService productService;

    private ProductToProductForm productToProductForm;

    @Autowired
    public void setProductToProductForm(ProductToProductForm productToProductForm) {
        this.productToProductForm = productToProductForm;
    }

    @Autowired
    public void setProductService(ExampleProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/product/list";
    }

    @RequestMapping({"/product/list", "/product"})
    public String listProducts(Model model){
        model.addAttribute("products", productService.listAll());
        return "product/list";
    }

    // mapping that dynamically gets product items
    @RequestMapping("/product/show/{id}")
    public String getProduct(@PathVariable String id, Model model){
        model.addAttribute("product", productService.getById(Long.valueOf(id)));
        return "product/show";
    }

    // mapping that dynamically edits product items
    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Product product = productService.getById(Long.valueOf(id));
        ExampleProductForm productForm = productToProductForm.convert(product);

        model.addAttribute("productForm", productForm);
        return "product/productform";
    }

    // mapping that dynamically creates new products
    @RequestMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("productForm", new ExampleProductForm());
        return "product/productform";
    }

    // == this is a post mapping and it will consume a form marked post
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid ExampleProductForm productForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "product/productform";
        }

        Product savedProduct = productService.saveOrUpdateProductForm(productForm);

        return "redirect:/product/show/" + savedProduct.getId();
    }

    // mapping that dynamically deletes product items
    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable String id){
        productService.delete(Long.valueOf(id));
        return "redirect:/product/list";
    }
}
