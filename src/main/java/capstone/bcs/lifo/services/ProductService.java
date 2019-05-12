package capstone.bcs.lifo.services;

import capstone.bcs.lifo.model.Product;

import java.util.List;
import java.util.Set;

public interface ProductService {

    /**
     * Interface for the ProductService
     * This is to follow best practices with regard to SOLID
     *
     */

    List<Product> getProducts();

    Product findById(Long l);

    Set<Product> getProductSet();

    List<Product> getProductAsecPrice();

    List<Product> getProductDescPrice();

    List<Product> getProductsAsce();

    List<Product> getProductsDesc();

    List<Product> getProductsByCategory(Integer integer);

    Product saveProduct(Product product);

    void deleteById(Long idToDelete);
}
