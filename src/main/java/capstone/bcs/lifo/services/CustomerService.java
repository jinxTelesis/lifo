package capstone.bcs.lifo.services;

import capstone.bcs.lifo.commands.RegistrationForm;
import capstone.bcs.lifo.model.Account;
import capstone.bcs.lifo.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> listAll();

    Customer getById(Integer id);

    Customer saveOrUpdateCustomerForm(RegistrationForm registrationForm);

    Customer saveOrUpdate(Customer domainObject);

    void delete(Integer id);

}
