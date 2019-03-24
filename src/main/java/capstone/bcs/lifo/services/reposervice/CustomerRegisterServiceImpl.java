package capstone.bcs.lifo.services.reposervice;

import capstone.bcs.lifo.commands.RegistrationForm;
import capstone.bcs.lifo.model.Customer;
import capstone.bcs.lifo.repositories.CustomerRepository;
import capstone.bcs.lifo.services.CustomerService;

import java.util.List;

public class CustomerRegisterServiceImpl implements CustomerService {

    private CustomerRepository customerRepository; // this has address embedded in it

    //ToDO add the Converters




    @Override
    public List<Customer> listAll() {
        return null;
    }

    @Override
    public Customer getById(Integer id) {
        return null;
    }

    @Override
    public Customer saveOrUpdateCustomerForm(RegistrationForm registrationForm) {
        return null;
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
