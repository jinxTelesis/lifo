package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.model.Product;
import capstone.bcs.lifo.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsRestController {

    private final ProductService productService;

    public ProductsRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/productsapi")
    List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping("/productapiadd")
    Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }


    @RequestMapping("/productapiget/{id}")
    List<Product> getProductById(@PathVariable Long id) {
        return productService.getProductsByCategory(Math.toIntExact(id));
    }

    // would really want this endpoint secure
    @DeleteMapping("/productapidelete/{id}")
    void deleteProduct(@PathVariable Long id){
        productService.deleteById(id);
    }

}
