package capstone.bcs.lifo.services;

import capstone.bcs.lifo.Exceptions.NotFoundException;
import capstone.bcs.lifo.commands.RegistrationForm;
import capstone.bcs.lifo.converters.RegistrationFormToCustomerNAccount;
import capstone.bcs.lifo.model.Account;
import capstone.bcs.lifo.model.Customer;
import capstone.bcs.lifo.repositories.CustomerRepository;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final PasswordEncryptionService passwordEncryptionService;
    private final CustomerRepository customerRepository;
    private final RegistrationFormToCustomerNAccount registrationFormToCustomerNAccount;
    protected EntityManagerFactory entityManagerFactory;


    // == this is not being used right now ==
    @PersistenceUnit
    public void setEmf(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    public CustomerServiceImpl(PasswordEncryptionService passwordEncryptionService, CustomerRepository customerRepository, RegistrationFormToCustomerNAccount registrationFormToCustomerNAccount) {
        this.passwordEncryptionService = passwordEncryptionService;
        this.customerRepository = customerRepository;
        this.registrationFormToCustomerNAccount = registrationFormToCustomerNAccount;
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customersList = new ArrayList<>();
        customerRepository.findAll().iterator().forEachRemaining(customersList::add);
        return customersList;
    }


    @Override
    public Customer getById(Long l) {
        Optional<Customer> customerOptional = customerRepository.findById(l);

        if (!customerOptional.isPresent()) {
            throw new NotFoundException();
        }
        return customerOptional.get();
    }

    @Override
    public Customer saveOrUpdateRegistrationForm(RegistrationForm registrationForm) {
        RegistrationFormToCustomerNAccount registrationFormToCustomerNAccount = new RegistrationFormToCustomerNAccount();

        // prob have to check some stuff here still
        Customer customer = registrationFormToCustomerNAccount.convert(registrationForm);
        Account account = customer.getAccount();
        account.setEncryptedPassword(passwordEncryptionService.encryptString(account.getPassword()));
        customerRepository.save(customer);

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

    // remove this soon
    @Override
    public Customer getByUserName(String userName) {
        // write this to service layer
        List<Customer> customersList = new ArrayList<>();
        customerRepository.findAll().iterator().forEachRemaining(customersList::add);
        //customersList.forEach(customer -> customer.getpFirstName());

        List<Customer> customerResultList = customersList.stream()
                .filter(customer -> customer.getAccount().getUsername().equals(userName))
                .collect(Collectors.toList());

        Customer customerReturn = customerResultList.get(0);

        return customerReturn;
    }

//    @Override
//    public Customer getByUserName(String pFirstName) {
//        // load all of them?
//
//        // put this in a try catch
//        Customer customerReturn = customerRepository.findBypFirstName(pFirstName);
//        // this does not work
//
//
//
//        EntityManager em = entityManagerFactory.createEntityManager();
//        //userName
//        Customer customer = em.createQuery("from Customer where user_name = :username", Customer.class).getSingleResult();
//
//        System.out.println(customer.getAccount().getUsername());
//
//
//        // might be from account class
//        return customerReturn;
//        //return em.createQuery("from Customer where user_name =:user_name",Customer.class).getSingleResult();//   }
//    }
//}
}