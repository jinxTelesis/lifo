package capstone.bcs.lifo.model;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pFirstName;
    private String pLastName;
    private String pEmail;
    private String pPassword;
    private String pDoB;

    //make an embedded type for address
    @Embedded
    private Address customerAddress = new Address();

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Account account;

    public Address getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(Address customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getpFirstName() {
        return pFirstName;
    }

    public void setpFirstName(String pFirstName) {
        this.pFirstName = pFirstName;
    }

    public String getpLastName() {
        return pLastName;
    }

    public void setpLastName(String pLastName) {
        this.pLastName = pLastName;
    }

    public String getpEmail() {
        return pEmail;
    }

    public void setpEmail(String pEmail) {
        this.pEmail = pEmail;
    }

    public String getpPassword() {
        return pPassword;
    }

    public void setpPassword(String pPassword) {
        this.pPassword = pPassword;
    }

    public String getpDoB() {
        return pDoB;
    }

    public void setpDoB(String pDoB) {
        this.pDoB = pDoB;
    }


}
