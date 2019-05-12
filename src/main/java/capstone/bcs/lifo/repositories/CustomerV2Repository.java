package capstone.bcs.lifo.repositories;

import capstone.bcs.lifo.model.CustomerV2;
import org.springframework.data.repository.CrudRepository;

public interface CustomerV2Repository extends CrudRepository<CustomerV2,Long> {

    /** these are all crud repositories they abstract writing specific JDBC commands

     */
}
