package capstone.bcs.lifo.repositories;

import capstone.bcs.lifo.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
