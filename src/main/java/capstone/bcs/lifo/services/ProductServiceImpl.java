package capstone.bcs.lifo.services;


import capstone.bcs.lifo.Exceptions.NotFoundException;
import capstone.bcs.lifo.model.Product;
import capstone.bcs.lifo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @Override
    public Set<Product> getProducts() {
        Set<Product> productSet = new HashSet<>();
        productRepository.findAll().iterator().forEachRemaining(productSet::add);
        return productSet;
    }

    @Override
    public Product findById(Long l) {

        Optional<Product> recipeOptional = productRepository.findById(l);

        if (!recipeOptional.isPresent()) {
            throw new NotFoundException();
        }

        return recipeOptional.get();
    }

    @Override
    public void deleteById(Long idToDelete) {
        productRepository.deleteById(idToDelete);
    }
}
