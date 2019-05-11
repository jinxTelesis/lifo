package capstone.bcs.lifo.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class CustomerV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private long customerId;

    private String pFirstName;
    private String pLastName;

    @Column(unique = true)
    private String pEmail;

    private String pDoB;


    //@Cascade({org.hibernate.annotations.CascadeType.PERSIST}) // this is what you just changed does it fail
    //@JoinColumn(name ="cart_version2_id") // changed from div
    //@Cascade(org.hibernate.annotations.CascadeType.MERGE)

    @OneToOne
    private CartV2 cartV2;



    //make an embedded type for address
    @Embedded
    private Address customerAddress = new Address();

    @Embedded
    private Account account = new Account();


    public Address getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(Address customerAddress) {
        this.customerAddress = customerAddress;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getpDoB() {
        return pDoB;
    }

    public void setpDoB(String pDoB) {
        this.pDoB = pDoB;
    }

    public CartV2 getCartV2() {
        return cartV2;
    }

    public void setCartV2(CartV2 cartV2) {
        this.cartV2 = cartV2;
    }



}
