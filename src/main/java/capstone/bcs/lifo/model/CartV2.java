package capstone.bcs.lifo.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
public class CartV2 {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="cart_version2_id")
    private Long cartidv2;

    //@Cascade(org.hibernate.annotations.CascadeType.MERGE)
    //@Cascade({org.hibernate.annotations.CascadeType.PERSIST})
    //@OneToOne(mappedBy = "cartV2",fetch = FetchType.EAGER)
    //@JoinColumn(name = "customerId")

    @OneToOne(cascade = CascadeType.ALL) // johns
    private CustomerV2 customerV2;

    // this failed in a new way
    //@Cascade(value= org.hibernate.annotations.CascadeType.PERSIST)


    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany(mappedBy = "cartV2", fetch = FetchType.EAGER)
    List<CartProductV2> productList = new ArrayList<>();
    //Set<CartProductV2> productSet = new HashSet<>();

    public CustomerV2 getCustomerV2() {
        return customerV2;
    }

    public void setCustomerV2(CustomerV2 customerV2) {
        this.customerV2 = customerV2;
    }


    public Long getCartidv2() {
        return cartidv2;
    }

    public void setCartidv2(Long cartidv2) {
        this.cartidv2 = cartidv2;
    }

    public List<CartProductV2> getProductList() {
        return productList;
    }

    public void setProductList(List<CartProductV2> productList) {
        this.productList = productList;
    }


}
