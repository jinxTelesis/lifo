package capstone.bcs.lifo.model;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CartOld {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToOne
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST})
    @JoinColumn(name = "customerId")
    private CustomerOld customer;

    // cart will need a one to many relationship with products


//    @Cascade({org.hibernate.annotations.CascadeType.PERSIST})
//    @ElementCollection // this is a super hack solution and should be removed with a join
//    @Embedded
//    private List<Product> productList = new ArrayList<>();


    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    @ElementCollection
    private List<Integer> productID = new ArrayList<>();


    @Cascade({org.hibernate.annotations.CascadeType.PERSIST})
    @ElementCollection
    private List<Double> productPrices = new ArrayList<>();


    @Cascade({org.hibernate.annotations.CascadeType.PERSIST})
    @ElementCollection
    private List<Integer> productNum = new ArrayList<>();


    // this should be refactored to a one to many join


//    public List<Product> getProductList() {
//        return productList;
//    }
//
//    public void setProductList(List<Product> productList) {
//        this.productList = productList;
//    }

    public List<Double> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(List<Double> productPrices) {
        this.productPrices = productPrices;
    }

    public List<Integer> getProductNum() {
        return productNum;
    }

    public void setProductNum(List<Integer> productNum) {
        this.productNum = productNum;
    }

    private double totalPrice;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public CustomerOld getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerOld customer) {
        this.customer = customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Integer> getProductID() {
        return productID;
    }

    public void setProductID(List<Integer> productID) {
        this.productID = productID;
    }

}
