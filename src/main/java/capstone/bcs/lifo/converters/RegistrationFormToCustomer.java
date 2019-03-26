package capstone.bcs.lifo.converters;

import capstone.bcs.lifo.commands.RegistrationForm;
import capstone.bcs.lifo.model.Address;
import capstone.bcs.lifo.model.Customer;

public class RegistrationFormToCustomer {

    public Customer convert(RegistrationForm registrationForm) {

        // == this class takes in the registration form and converts it to
        // == an address object and a customer object ==
        // == the address object is embedded in the Customer object ==

        Customer customer = new Customer(); // has an address object embedded in it - composition - hibernate embeddable
        // maybe add role or user object here later --
         // == embedded object
        customer.setpFirstName(registrationForm.getpFirstName());
        customer.setpLastName(registrationForm.getpLastName());
        customer.setpEmail(registrationForm.getpEmail());
        customer.setpPassword(registrationForm.getpPassword());
        customer.setpDoB(registrationForm.getpDoB());
        // all in the composition object address
        Address address = new Address();
        address.setaFirstName(registrationForm.getaFirstName());
        address.setaLastName(registrationForm.getaLastName());
        address.setaCompnay(registrationForm.getaCompany());
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
        return customer;
    }
}

