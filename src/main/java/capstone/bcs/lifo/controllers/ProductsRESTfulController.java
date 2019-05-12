package capstone.bcs.lifo.controllers;

import capstone.bcs.lifo.config.ProductAssembler;
import capstone.bcs.lifo.model.Product;
import capstone.bcs.lifo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class ProductsRESTfulController {

    /**
     * this is based off the hatoes library which comes with a data format assembler
     * this was a little tricky to use a first but it will reformat the data into
     * a beautiful and easy to use display
     * if you issue curl commands Get/Delete at those addresses it will
     * change the LIFO database, tested about 30-40 times and it works great
     */

    private final ProductRepository productRepository;
    private final ProductAssembler assembler;

    @Autowired
    public ProductsRESTfulController(ProductAssembler assembler, ProductRepository productRepository) {
        this.assembler = assembler;
        this.productRepository = productRepository;
    }


    @DeleteMapping(value = "/product/rest/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping(value = "/product/rest/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Resource<Product> getProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
        return assembler.toResource(product);
    }

    @GetMapping(value = "/product/rest/all",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Resources<Resource<Product>> getProducts() {
        List<Resource<Product>> products = productRepository.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(products,
                linkTo(methodOn(ProductsRESTfulController.class).getProducts()).withSelfRel());
    }

}
