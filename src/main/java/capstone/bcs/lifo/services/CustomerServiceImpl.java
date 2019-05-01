package capstone.bcs.lifo.services;

import capstone.bcs.lifo.Exceptions.NotFoundException;
import capstone.bcs.lifo.commands.RegistrationForm;
import capstone.bcs.lifo.converters.RegistrationFormToCustomerNAccount;
import capstone.bcs.lifo.model.Account;
import capstone.bcs.lifo.model.CustomerV2;
import capstone.bcs.lifo.repositories.CustomerV2Repository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final PasswordEncryptionService passwordEncryptionService;
    private final CustomerV2Repository customerV2Repository;
    private final RegistrationFormToCustomerNAccount registrationFormToCustomerNAccount;


    // == this is not being used right now ==

    public CustomerServiceImpl(PasswordEncryptionService passwordEncryptionService, RegistrationFormToCustomerNAccount registrationFormToCustomerNAccount
    ,CustomerV2Repository customerV2Repository) {
        this.passwordEncryptionService = passwordEncryptionService;
        this.registrationFormToCustomerNAccount = registrationFormToCustomerNAccount;
        this.customerV2Repository = customerV2Repository;
    }

    @Override
    public List<CustomerV2> getCustomers() {
        List<CustomerV2> customersList = new ArrayList<>();
        //customerRepository.findAll().iterator().forEachRemaining(customersList::add);
        customerV2Repository.findAll().iterator().forEachRemaining(customersList::add);
        return customersList;
    }


    @Override
    public CustomerV2 getById(Long l) {
        Optional<CustomerV2> customerV2Optional = customerV2Repository.findById(l);

        if (!customerV2Optional.isPresent()) {
            throw new NotFoundException();
        }
        return customerV2Optional.get();
    }

    @Override
    public CustomerV2 saveOrUpdateRegistrationForm(RegistrationForm registrationForm) {
        RegistrationFormToCustomerNAccount registrationFormToCustomerNAccount = new RegistrationFormToCustomerNAccount();

        // prob have to check some stuff here still
        //CustomerOld customer = registrationFormToCustomerNAccount.convert(registrationForm);
        CustomerV2 customerV2 = registrationFormToCustomerNAccount.convert(registrationForm);
        Account account = customerV2.getAccount();
        // Account account = customer.getAccount();
        account.setEncryptedPassword(passwordEncryptionService.encryptString(account.getPassword()));

        customerV2Repository.save(customerV2);
        return customerV2;
    }

    @Override
    public CustomerV2 saveOrUpdate(CustomerV2 customer) {
        // wait for the forms be completed hard to test like this
        return customerV2Repository.save(customer);
    }


    @Override
    public void delete(Long l) {
        customerV2Repository.deleteById(l);
    }

    // remove this soon
    @Override
    public CustomerV2 getByUserName(String userName) {
        // write this to service layer
        List<CustomerV2> customersList = new ArrayList<>();
        customerV2Repository.findAll().iterator().forEachRemaining(customersList::add);

        List<CustomerV2> customerV2ResultList = customersList.stream()
                .filter(customerV2 -> customerV2.getAccount().getUsername().equals(userName))
                .collect(Collectors.toList());
        CustomerV2 customerV2Return = customerV2ResultList.get(0);

        return customerV2Return;
    }
}