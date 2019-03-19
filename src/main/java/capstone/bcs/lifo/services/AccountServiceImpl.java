package capstone.bcs.lifo.services;


import capstone.bcs.lifo.Exceptions.NotFoundException;
import capstone.bcs.lifo.model.Account;
import capstone.bcs.lifo.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAccounts() {
        List<Account> accountList = new ArrayList<>();
        accountRepository.findAll().iterator().forEachRemaining(accountList::add);
        return accountList;
    }

    @Override
    public Account findById(Long l) {
        Optional<Account> accountOptional = accountRepository.findById(l);

        if(!accountOptional.isPresent()){
            throw new NotFoundException();
        }
        return accountOptional.get();
    }

    @Override
    public void deleteById(Long idToDelete) {
        accountRepository.deleteById(idToDelete);
    }

}
