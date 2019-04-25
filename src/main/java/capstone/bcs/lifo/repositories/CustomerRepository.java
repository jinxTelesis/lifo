package capstone.bcs.lifo.repositories;

import capstone.bcs.lifo.model.CustomerOld;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerOld, Long> {

    CustomerOld findBypFirstName(String pFirstName);
}
