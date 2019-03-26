package capstone.bcs.lifo.services.reposervice;

import capstone.bcs.lifo.commands.RegistrationForm;
import capstone.bcs.lifo.model.Account;
import capstone.bcs.lifo.model.Customer;
import capstone.bcs.lifo.repositories.CustomerRepository;
import capstone.bcs.lifo.services.CustomerService;

import java.util.List;

public class CustomerRegisterServiceImpl implements CustomerService {

    private CustomerRepository customerRepository; // this has address embedded in it

    //ToDO add the Converters

    @Override
    public List<Customer> getCustomers() {
        return null;
    }

    @Override
    public List<Account> getAccounts() {
        return null;
    }

    @Override
    public Customer getById(Long l) {
        return null;
    }

    @Override
    public Customer saveOrUpdateRegistrationForm(RegistrationForm registrationForm) {
        return null;
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return null;
    }

    @Override
    public void delete(Long l) {

    }

}
