package capstone.bcs.lifo.services;

import capstone.bcs.lifo.model.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface ProductService {

    List<Product> getProducts();

    Product findById(Long l);

    List<Product> getProductsAsce();

    List<Product> getProductsDesc();

    List<Product> getProductsByCategory(Integer integer);

    void deleteById(Long idToDelete);

}
