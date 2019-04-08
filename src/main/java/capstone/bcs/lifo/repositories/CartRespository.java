package capstone.bcs.lifo.repositories;

import capstone.bcs.lifo.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRespository extends CrudRepository<Cart,Long> {
}
