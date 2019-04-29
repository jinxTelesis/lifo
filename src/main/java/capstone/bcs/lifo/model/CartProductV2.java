package capstone.bcs.lifo.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class CartProductV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCart")
    private Long idCP;

    private double totalPrice;
    private double productTax = 0.2;
    private double productDiscount = 0.1;
    private double productPrice;

    private int productId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartProductV2)) return false;
        CartProductV2 that = (CartProductV2) o;
        return productId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    private int productNumber;

    private double discountOnProduct;

    //@Cascade({org.hibernate.annotations.CascadeType.PERSIST})
    //@Cascade(org.hibernate.annotations.CascadeType.MERGE) // we might not want this to cascade at all
    //@JoinColumn(name="cart_version2_id",nullable = false) // might be issue

    @Lob
    private String description1;

    private String productName;

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @ManyToOne
    private CartV2 cartV2;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public CartV2 getCartV2() {
        return cartV2;
    }

    public void setCartV2(CartV2 cartV2) {
        this.cartV2 = cartV2;
    }

    public double getDiscountOnProduct() {
        return discountOnProduct;
    }

    public void setDiscountOnProduct(double discountOnProduct) {
        this.discountOnProduct = discountOnProduct;
    }



    public double getTotalPrice() {
        return Math.floor((productPrice - getProductDiscount())*(this.productTax+1))*100/100;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getProductTax() {
        return Math.floor((this.productTax * this.productPrice) * 100)/100;
    }

    public void setProductTax(double productTax) {
        this.productTax = productTax;
    }

    // not a default getter don't do this at home kids
    public double getProductDiscount() {
        return Math.floor((this.productDiscount * this.productPrice)*100)/100;
    }

    public void setProductDiscount(double productDiscount) {
        this.productDiscount = productDiscount;
    }
}