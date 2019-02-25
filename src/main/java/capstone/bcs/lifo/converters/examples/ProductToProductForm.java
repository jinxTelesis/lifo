package capstone.bcs.lifo.converters.examples;

import capstone.bcs.lifo.commands.example.ExampleProductForm;
import capstone.bcs.lifo.model.examples.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


/**
 * Created by jt on 1/10/17.
 */
@Component
public class ProductToProductForm implements Converter<Product,ExampleProductForm> {

    @Override
    public ExampleProductForm convert(Product product) {
        ExampleProductForm productForm = new ExampleProductForm();
        productForm.setId(product.getId());
        productForm.setDescription(product.getDescription());
        productForm.setPrice(product.getPrice());
        productForm.setImageUrl(product.getImageUrl());
        return productForm;
    }


}
