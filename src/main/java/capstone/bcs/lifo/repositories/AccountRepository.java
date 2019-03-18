package capstone.bcs.lifo.repositories;

import capstone.bcs.lifo.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,Long> {

}
