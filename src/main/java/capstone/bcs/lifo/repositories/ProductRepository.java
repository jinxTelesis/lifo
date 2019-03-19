package capstone.bcs.lifo.repositories;


import capstone.bcs.lifo.model.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Long> {

}