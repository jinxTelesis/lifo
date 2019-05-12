package capstone.bcs.lifo.bootstrap;

import capstone.bcs.lifo.model.*;
import capstone.bcs.lifo.repositories.CustomerV2Repository;
import capstone.bcs.lifo.repositories.OrderDetailRepository;
import capstone.bcs.lifo.repositories.ProductRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final ProductRepository productRepository;
    //private final AccountRepository accountRepository;
    //private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    // == testing remove ==
    //private final CustomerRepository customerRepository;

    public Bootstrap(ProductRepository productRepository, OrderDetailRepository orderDetailRepository, CustomerV2Repository customerV2Repository) {
        this.productRepository = productRepository;
        //this.accountRepository = accountRepository;
        //this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        // == testing remove ==
        //this.customerRepository = customerRepository;
    }


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        //accountRepository.saveAll(getAccounts());
        //orderRepository.saveAll(getOrders());
        orderDetailRepository.saveAll(getOrderDetails());
        //customerRepository.saveAll(getCustomers());

    }


    private List<CustomerV2> getCustomers()
    {
        List<CustomerV2> customers = new ArrayList<>();
        CustomerV2 customer1 = new CustomerV2();

        Account account = new Account();
        account.setUsername("biff");
        account.setPassword("marko12");
        account.setEncryptedPassword("fdfdsfsd");
        account.setUserRole("customer");
        account.setActive(true);

        customer1.setAccount(account);


        customer1.setpFirstName("biff");
        customer1.setpLastName("marko");
        customer1.setpEmail("dranko@hotmail.com");
        customer1.setpDoB("08-12-2019");


        Address address = new Address();
        address.setaAddress("117 betten ray");
        address.setaAddress2("blank");
        address.setaZip("12131");
        address.setaCountry("United States");
        address.setaAdditionalInfo("blank");
        address.setaHomePhone("212-121-1221");
        address.setaMobilePhone("121-111-2131");


        customer1.setCustomerAddress(address);
        customers.add(customer1);

        return customers;
    }

    private List<Account> getAccounts(){
        List<Account> accounts = new ArrayList<Account>();
        Account jimsAccount = new Account();


        jimsAccount.setActive(true);
        jimsAccount.setUsername("Biffman1000");
        jimsAccount.setUsername("macNCheese");
        jimsAccount.setUserRole("CustomerOld");

        accounts.add(jimsAccount);

        Account bethsAccount = new Account();
        bethsAccount.setActive(true);
        bethsAccount.setUsername("Chelseaseasea");
        bethsAccount.setUserRole("lovethatmacnCheese");
        bethsAccount.setUserRole("CustomerOld");

        accounts.add(bethsAccount);

        return accounts;
    }

    private List<Order> getOrders(){
        List<Order> orders = new ArrayList<Order>();

//        Order F1000 = new Order();
//        F1000.setAmount(100.00);
//        F1000.setAddress1("10 Parker street");
//        F1000.setAddress2("upstairs apt");
//        F1000.setCountry("United States");
//        F1000.setCustomerEmail("farklank10@hotmail.com");
//        F1000.setCustomerName("billy");
//        F1000.setCustomerPhone("517-2788-1281");
//
//        Date ordeDate = new Date();
//        ordeDate.setTime(10213131);
//        F1000.setOrderDate(ordeDate);
//
//        Date ordertime = new Date();
//        ordertime.setTime(1213131);
//        F1000.setOrderTime(ordertime);
//        F1000.setState("NY");
//        F1000.setZip(10001);
//        orders.add(F1000);
//
//        Order F1001 = new Order();
//        F1001.setAmount(105.17);
//        F1001.setAddress1("17 Parker street");
//        F1001.setAddress2("back apt");
//        F1001.setCountry("United States");
//        F1001.setCustomerEmail("Bifarklank10@hotmail.com");
//        F1001.setCustomerName("lisy");
//        F1001.setCustomerPhone("518-2788-1281");
//
//        Date ordeDate1 = new Date();
//        ordeDate.setTime(1021131);
//        F1001.setOrderDate(ordeDate1);
//
//        Date ordertime2 = new Date();
//        ordertime.setTime(113131);
//        F1001.setOrderTime(ordertime2);
//        F1001.setState("NY");
//        F1001.setZip(11001);
//        orders.add(F1001);


        return orders;
    }

    private  List<OrderDetail> getOrderDetails() {
        List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setAmount(100.07);
        orderDetail1.setOrderID("100cahbx");
        orderDetail1.setPrice(10.1);
        orderDetail1.setProductID("hb1c");
        orderDetail1.setQuantity(2);

        // == added to the list == //
        orderDetails.add(orderDetail1);

        OrderDetail orderDetai2 = new OrderDetail();
        orderDetai2.setAmount(78.1);
        orderDetai2.setOrderID("100cabhx");
        orderDetai2.setPrice(10.8);
        orderDetai2.setProductID("blunkjk");
        orderDetai2.setQuantity(3);

        // == added to the list == /
        orderDetails.add(orderDetai2);

        OrderDetail orderDetai3 = new OrderDetail();
        orderDetai3.setAmount(100.07);
        orderDetai3.setProductID("100cads");
        orderDetai3.setPrice(10.4);
        orderDetai3.setProductID("spiff");
        orderDetai3.setQuantity(4);


        return orderDetails;
    }

}
