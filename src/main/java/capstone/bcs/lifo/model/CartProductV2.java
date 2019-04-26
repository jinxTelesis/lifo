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

    private double productPrice;

    private int productNumber;

    private double discountOnProduct;

    //@Cascade({org.hibernate.annotations.CascadeType.PERSIST})
    //@Cascade(org.hibernate.annotations.CascadeType.MERGE) // we might not want this to cascade at all
    //@JoinColumn(name="cart_version2_id",nullable = false) // might be issue
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
}
