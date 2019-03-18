package capstone.bcs.lifo.repositories;

import capstone.bcs.lifo.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long> {

}
