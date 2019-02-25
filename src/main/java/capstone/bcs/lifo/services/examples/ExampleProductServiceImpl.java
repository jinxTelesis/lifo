package capstone.bcs.lifo.services.examples;

import capstone.bcs.lifo.commands.example.ExampleProductForm;
import capstone.bcs.lifo.converters.examples.ProductFormToProduct;
import capstone.bcs.lifo.model.examples.Product;
import capstone.bcs.lifo.repositories.examples.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExampleProductServiceImpl implements ExampleProductService {
    private ProductRepository productRepository;
    private ProductFormToProduct productFormToProduct;

    @Autowired
    public ExampleProductServiceImpl(ProductRepository productRepository, ProductFormToProduct productFormToProduct) {
        this.productRepository = productRepository;
        this.productFormToProduct = productFormToProduct;
    }


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

    @Override
    public Product saveOrUpdateProductForm(ExampleProductForm productForm) {
        Product savedProduct = saveOrUpdate(productFormToProduct.convert(productForm));

        System.out.println("Saved Product Id: " + savedProduct.getId());
        return savedProduct;
    }
}
