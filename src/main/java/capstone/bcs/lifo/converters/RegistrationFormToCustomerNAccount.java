package capstone.bcs.lifo.converters;

import capstone.bcs.lifo.commands.RegistrationForm;
import capstone.bcs.lifo.model.Account;
import capstone.bcs.lifo.model.Address;
import capstone.bcs.lifo.model.Customer;
import org.springframework.stereotype.Component;


@Component
public class RegistrationFormToCustomerNAccount {

    static final String CUSTOMER = "customer";

    public Customer convert(RegistrationForm registrationForm) {

        // == this class takes in the registration form and converts it to
        // == an address object and a customer object ==
        // == the address object is embedded in the Customer object ==

        Customer customer = new Customer(); // has an address object embedded in it - composition - hibernate embeddable
        Account account = new Account();
        account.setUsername(registrationForm.getUsername());
        account.setPassword(registrationForm.getPasswordPlain()); // encrypt here?
        account.setUserRole(CUSTOMER);
        account.setActive(true);

        // maybe add role or user object here later --
         // == embedded object
        customer.setpFirstName(registrationForm.getpFirstName());
        customer.setpLastName(registrationForm.getpLastName());
        customer.setpEmail(registrationForm.getpEmail());
        customer.setpDoB(registrationForm.getpDoB());
        // all in the composition object address
        Address address = new Address();
        address.setaAddress(registrationForm.getaAddress());
        address.setaAddress2(registrationForm.getaAddress2());
        address.setaCity(registrationForm.getaCity());
        address.setaState(registrationForm.getaState());
        address.setaZip(registrationForm.getaZip());
        address.setaCountry(registrationForm.getaCountry());
        address.setaAdditionalInfo(registrationForm.getaAdditionalInfo());
        address.setaCountry(registrationForm.getaCountry());
        address.setaAdditionalInfo(registrationForm.getaAdditionalInfo());
        address.setaHomePhone(registrationForm.getaHomePhone());
        address.setaMobilePhone(registrationForm.getaMobilePhone());

        // puts the object in the object
        customer.setCustomerAddress(address);
        customer.setAccount(account);
        return customer;
    }
}

