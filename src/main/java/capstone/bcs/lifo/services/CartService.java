package capstone.bcs.lifo.services;

import capstone.bcs.lifo.model.CartV2;

import java.util.List;

public interface CartService {

    List<CartV2> getCarts();

    CartV2 findById(Long l);

    void deleteById(Long idToDelete);

    CartV2 findByUserName(String username);
}
