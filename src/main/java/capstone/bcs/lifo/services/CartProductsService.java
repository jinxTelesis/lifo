package capstone.bcs.lifo.services;

import capstone.bcs.lifo.model.CartProducts;

import java.util.List;

public interface CartProductsService {

    List<CartProducts> getCartProducts();

    CartProducts findById(Long l);

    void deleteById(Long idToDelete);

}
