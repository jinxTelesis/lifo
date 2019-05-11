package capstone.bcs.lifo.services;

import capstone.bcs.lifo.commands.RegistrationForm;
import capstone.bcs.lifo.model.CustomerV2;

import java.util.List;

public interface CustomerService {

    List<CustomerV2> getCustomers();

    CustomerV2 getById(Long l);

    CustomerV2 saveOrUpdateRegistrationForm(RegistrationForm registrationForm);

    CustomerV2 saveOrUpdate(CustomerV2 customer);

    void delete(Long l);

    CustomerV2 getByUserName(String userName);

    CustomerV2 getByEmail(String email);

}
