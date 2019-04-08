package capstone.bcs.lifo.services;

import capstone.bcs.lifo.model.CartProducts;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartProductServiceImpl implements CartProductsService {


    @Override
    public List<CartProducts> getCartProducts() {
        return null;
    }

    @Override
    public CartProducts findById(Long l) {
        return null;
    }

    @Override
    public void deleteById(Long idToDelete) {

    }
}
