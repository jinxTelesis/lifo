package capstone.bcs.lifo.services;

import capstone.bcs.lifo.commands.RegistrationForm;
import capstone.bcs.lifo.model.Account;
import capstone.bcs.lifo.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    Customer getById(Long l);

    Customer saveOrUpdateRegistrationForm(RegistrationForm registrationForm);

    Customer saveOrUpdate(Customer customer);

    void delete(Long l);

    Customer getByUserName(String userName);

}
