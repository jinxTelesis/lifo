package capstone.bcs.lifo.config;


import capstone.bcs.lifo.controllers.ProductsRESTfulController;
import capstone.bcs.lifo.model.Product;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class ProductAssembler implements ResourceAssembler<Product,Resource<Product>> {

    // this is a resource assembler for hateos which does data conversion to format to the APIs standards

    @Override
    public Resource<Product> toResource(Product entity) {
        return new Resource<>(entity,
                linkTo(methodOn(ProductsRESTfulController.class).getProduct(entity.getId())).withSelfRel(),
                linkTo(methodOn(ProductsRESTfulController.class).getProducts()).withRel("products"));
    }
}


