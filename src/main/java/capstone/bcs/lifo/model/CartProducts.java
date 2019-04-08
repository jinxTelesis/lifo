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
//    private ArrayList<Product> productList = new ArrayList<Product>(){
//        Product p1GeorgeFormanGrill = new Product("George Forman Grill",5,99.99,"george_foreman.jpg"," ",
//                "The amazing grill that cooks your food evenly, while reducing the fat in any meats you cook. This item can be used in a variety of different dishes from Panini's to steaks."
//        ," "," ");
//    };

    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;


}
