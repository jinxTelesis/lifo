package capstone.bcs.lifo.controllers;

import capstone.bcs.lifo.model.Product;
import capstone.bcs.lifo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class ProductsRESTfulController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductsRESTfulController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }






}
