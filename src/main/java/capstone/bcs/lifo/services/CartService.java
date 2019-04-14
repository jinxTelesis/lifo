package capstone.bcs.lifo.services;

import capstone.bcs.lifo.model.Cart;
import capstone.bcs.lifo.model.Order;

import java.util.List;

public interface CartService {

    List<Cart> getCarts();

    Cart findById(Long l);

    void deleteById(Long idToDelete);
}
