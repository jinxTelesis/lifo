package capstone.bcs.lifo.services;

import capstone.bcs.lifo.Exceptions.NotFoundException;
import capstone.bcs.lifo.commands.RegistrationForm;
import capstone.bcs.lifo.converters.RegistrationFormToCustomer;
import capstone.bcs.lifo.model.Account;
import capstone.bcs.lifo.model.Customer;
import capstone.bcs.lifo.repositories.AccountRepository;
import capstone.bcs.lifo.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final RegistrationFormToCustomer registrationFormToCustomer;
    private final AccountRepository accountRepository; // think about removing

    public CustomerServiceImpl(CustomerRepository customerRepository, RegistrationFormToCustomer registrationFormToCustomer, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.registrationFormToCustomer = registrationFormToCustomer;
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customersList = new ArrayList<>();
        customerRepository.findAll().iterator().forEachRemaining(customersList::add);
        return customersList;
    }

    public List<Account> getAccounts(){
        List<Account> accountList = new ArrayList<>();
        accountRepository.findAll().iterator().forEachRemaining(accountList::add);
        return accountList;
    }

    @Override
    public Customer getById(Long l) {
        Optional<Customer> customerOptional = customerRepository.findById(l);

        if(!customerOptional.isPresent()) {
            throw  new NotFoundException();
        }
        return customerOptional.get();
    }

    @Override
    public Customer saveOrUpdateRegistrationForm(RegistrationForm registrationForm) {
        RegistrationFormToCustomer registrationFormToCustomer = new RegistrationFormToCustomer();

        Customer customer = registrationFormToCustomer.convert(registrationForm);
        customerRepository.save(customer);

        Account dummyAccount = new Account();
        accountRepository.save(dummyAccount);
        // == this is a dummy account == //

        //ToDo this needs to be implemented at some point does not check if there was an existing user

        return customer;
    }

    @Override
    public Customer saveOrUpdate(Customer customer) {


        // wait for the forms be completed hard to test like this
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Long l) {
        customerRepository.deleteById(l);

    }

}
