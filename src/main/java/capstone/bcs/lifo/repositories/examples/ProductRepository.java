package capstone.bcs.lifo.repositories.examples;

import capstone.bcs.lifo.model.examples.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
