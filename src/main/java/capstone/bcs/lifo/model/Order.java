package capstone.bcs.lifo.model;

import javax.persistence.*;

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    // should this be split up
    private String address1;
    private String address2;
    private Double zip;
    private String state;
    private String country;
    private String customerEmail;
    private String customerName;
    private String customerPhone;

    @Basic
    @Temporal(TemporalType.DATE)
    private java.util.Date orderDate;

    @Basic
    @Temporal(TemporalType.TIME)
    private java.util.Date orderTime;

    // Order Details needs join to products
    // Order Details needs join to


}
