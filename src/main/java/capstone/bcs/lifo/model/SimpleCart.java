package capstone.bcs.lifo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SimpleCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @Lob
    @Embedded
    private List<Product> productList = new ArrayList<>();

    @Lob
    private List<Double> productPrice = new ArrayList<>();

    @Lob
    private List<Integer> productNumber = new ArrayList<>();


    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Double> getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(List<Double> productPrice) {
        this.productPrice = productPrice;
    }

    public List<Integer> getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(List<Integer> productNumber) {
        this.productNumber = productNumber;
    }

}
