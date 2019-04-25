package capstone.bcs.lifo.repositories;

import capstone.bcs.lifo.model.CartOld;
import org.springframework.data.repository.CrudRepository;

public interface CartRespository extends CrudRepository<CartOld,Long> {
}
