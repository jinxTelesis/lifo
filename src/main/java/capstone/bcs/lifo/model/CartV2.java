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


    @OneToOne(cascade = CascadeType.ALL) // johns
    private CustomerV2 customerV2;

    private Boolean annonoymousAccount;

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

    public Boolean getAnnonoymousAccount() {
        return annonoymousAccount;
    }

    public void setAnnonoymousAccount(Boolean annonoymousAccount) {
        this.annonoymousAccount = annonoymousAccount;
    }


}