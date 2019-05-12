package capstone.bcs.lifo.converters;

import capstone.bcs.lifo.commands.RegistrationForm;
import capstone.bcs.lifo.model.Account;
import capstone.bcs.lifo.model.Address;
import capstone.bcs.lifo.model.CustomerV2;
import org.springframework.stereotype.Component;


@Component
public class RegistrationFormToCustomerNAccount {

    /**
     * as the name implies this is a converter from a registration form
     * to customerV2
     */

    static final String CUSTOMER = "customer";

    public CustomerV2 convert(RegistrationForm registrationForm) {

        // == this class takes in the registration form and converts it to
        // == an address object and a customer object ==
        // == the address object is embedded in the CustomerOld object ==

        //CustomerOld customer = new CustomerOld(); // has an address object embedded in it - composition - hibernate embeddable
        CustomerV2 customerV2 = new CustomerV2();
        Account account = new Account();
        account.setUsername(registrationForm.getUsername());
        account.setPassword(registrationForm.getPasswordPlain()); // encrypt here?
        account.setUserRole(CUSTOMER);
        account.setActive(true);

        // maybe add role or user object here later --
         // == embedded object
        customerV2.setpFirstName(registrationForm.getpFirstName());
        customerV2.setpLastName(registrationForm.getpLastName());
        customerV2.setpEmail(registrationForm.getpEmail());
        customerV2.setpDoB(registrationForm.getpDoB());
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
        customerV2.setCustomerAddress(address);
        customerV2.setAccount(account);
        return customerV2;
    }
}

