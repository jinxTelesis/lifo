package capstone.bcs.lifo.services.examples;

import capstone.bcs.lifo.commands.example.ExampleProductForm;
import capstone.bcs.lifo.converters.examples.ProductFormToProduct;
import capstone.bcs.lifo.model.examples.Product;
import capstone.bcs.lifo.repositories.examples.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // == tells spring this is a bean
public class ExampleProductServiceImpl implements ExampleProductService {


    private ProductRepository productRepository; // == repo , the service provides a lay of abstraction to model/repos
    private ProductFormToProduct productFormToProduct;

    @Autowired // == this is just a constructor following best DI practices
    public ExampleProductServiceImpl(ProductRepository productRepository, ProductFormToProduct productFormToProduct) {
        this.productRepository = productRepository;
        this.productFormToProduct = productFormToProduct;
    }

    // == everything below this is basically getters, setters and operations aka some sort of method to access the data ==
    // == in various ways, list all. it does not have to be these methods it can be anything that serves the data up ==
    // == in a way that makes sense. ==

    @Override
    public List<Product> listAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add); //fun with Java 8
        return products;
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveOrUpdate(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);

    }

    // == this accesses a converter, a converter will change a POST object into something usable by the java code ==
    // == converters go both ways ==
    @Override
    public Product saveOrUpdateProductForm(ExampleProductForm productForm) {
        Product savedProduct = saveOrUpdate(productFormToProduct.convert(productForm));

        System.out.println("Saved Product Id: " + savedProduct.getId());
        return savedProduct;
    }
}
