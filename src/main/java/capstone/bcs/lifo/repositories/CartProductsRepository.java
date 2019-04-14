package capstone.bcs.lifo.repositories;

import capstone.bcs.lifo.model.CartProducts;
import org.springframework.data.repository.CrudRepository;

public interface CartProductsRepository extends CrudRepository<CartProducts,Long> {

}
