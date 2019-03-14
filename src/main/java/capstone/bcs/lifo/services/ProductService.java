package capstone.bcs.lifo.services;

import capstone.bcs.lifo.model.Product;

import java.util.Set;

public interface ProductService {

    Set<Product> getProducts();

    Product findById(Long l);

    void deleteById(Long idToDelete);
}
