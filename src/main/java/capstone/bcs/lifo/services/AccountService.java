package capstone.bcs.lifo.services;

import capstone.bcs.lifo.model.Account;
import capstone.bcs.lifo.model.Product;

import java.util.List;

public interface AccountService {

    List<Account> getAccounts();

    Account findById(Long l);

    void deleteById(Long idToDelete);
}
