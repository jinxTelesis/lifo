package capstone.bcs.lifo.services;

import capstone.bcs.lifo.model.CartOld;
import capstone.bcs.lifo.model.CartV2;
import capstone.bcs.lifo.model.CustomerOld;
import capstone.bcs.lifo.model.Product;

import java.util.List;

public interface CartService {

    List<CartV2> getCarts();

    CartV2 findById(Long l);

    void deleteById(Long idToDelete);
}
