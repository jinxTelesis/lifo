package capstone.bcs.lifo.util;

import capstone.bcs.lifo.model.CartProductV2;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CartUtil {

    public List<CartProductV2> removeAll(List<CartProductV2> list, CartProductV2 cartProductV2){
        return list.parallelStream()
                .filter(p -> !Objects.equals(p, cartProductV2))
                .collect(Collectors.toList());
    }

    public Double cartTotal(List<CartProductV2> list){
        double sum = list.parallelStream().filter( p -> p.getProductPrice() > 0.0f).mapToDouble(o -> o.getProductPrice()).sum();
        return sum;
    }

    public Double productTotal(List<CartProductV2> list, CartProductV2 cartProductV2){
        list.stream()
                .filter(p -> Objects.equals(p, cartProductV2))
                .collect(Collectors.toList());
        double sum = list.parallelStream().filter(p -> p.getProductPrice() > 0.0f).mapToDouble(o -> o.getProductPrice()).sum();
        return sum;
    }

    public Double appDiscountToCart(List<CartProductV2> list, Double discount){
        double sum = list.parallelStream().filter( p -> p.getProductPrice() > 0.0f).mapToDouble(o -> o.getProductPrice()).sum();
        sum = sum + (sum * discount);
        return sum;
    }

}