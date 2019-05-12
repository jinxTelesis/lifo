package capstone.bcs.lifo.repositories;

import capstone.bcs.lifo.model.CartProductV2;
import org.springframework.data.repository.CrudRepository;

public interface CartProductV2Repository extends CrudRepository<CartProductV2,Long> {

    /** these are all crud repositories they abstract writing specific JDBC commands

     */
}
