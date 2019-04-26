package capstone.bcs.lifo.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CartV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_version2_id")
    private Long cartidv2;

    @Cascade({org.hibernate.annotations.CascadeType.PERSIST})
    @OneToOne
    @JoinColumn(name = "customerId")
    private CustomerV2 customerV2;

    // this failed in a new way
    @Cascade(value= org.hibernate.annotations.CascadeType.PERSIST)
    @OneToMany(mappedBy = "cartV2", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    Set<CartProductV2> productSet = new HashSet<>();



    public CustomerV2 getCustomerV2() {
        return customerV2;
    }

    public void setCustomerV2(CustomerV2 customerV2) {
        this.customerV2 = customerV2;
    }

    public Set<CartProductV2> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<CartProductV2> productSet) {
        this.productSet = productSet;
    }


    public Long getCartidv2() {
        return cartidv2;
    }

    public void setCartidv2(Long cartidv2) {
        this.cartidv2 = cartidv2;
    }
}
