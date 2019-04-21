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

    @Lob
    private List<Product> productList;

    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;


    public long getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(long cartProductId) {
        this.cartProductId = cartProductId;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
