package capstone.bcs.lifo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CartProducts {

    @Id
    @GeneratedValue
    private long cartProductId;

    private int numberOfItems;
    private double price;

    // no relation can just store products here
    //private List<Product> productList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;





}
