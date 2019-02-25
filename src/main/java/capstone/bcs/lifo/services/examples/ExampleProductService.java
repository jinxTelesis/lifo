package capstone.bcs.lifo.services.examples;

import capstone.bcs.lifo.commands.example.ExampleProductForm;
import capstone.bcs.lifo.model.examples.Product;

import java.util.List;

public interface ExampleProductService {

    List<Product> listAll();

    Product getById(Long id);

    Product saveOrUpdate(Product product);

    void delete(Long id);

    Product saveOrUpdateProductForm(ExampleProductForm productForm);
}
