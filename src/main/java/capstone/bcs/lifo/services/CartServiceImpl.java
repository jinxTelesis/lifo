package capstone.bcs.lifo.services;

import capstone.bcs.lifo.Exceptions.NotFoundException;
import capstone.bcs.lifo.model.Cart;
import capstone.bcs.lifo.repositories.CartRespository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{

    private final CartRespository cartRespository;

    public CartServiceImpl(CartRespository cartRespository) {
        this.cartRespository = cartRespository;
    }
    @Override
    public List<Cart> getCarts() {
        List<Cart> cartList = new ArrayList<>();
        cartRespository.findAll().iterator().forEachRemaining(cartList::add);
        return cartList;
    }


    @SuppressWarnings("unchecked")
    @Override
    public Cart findById(Long l) {
        Optional<Cart> cartOptional = cartRespository.findById(l);
        if(!cartOptional.isPresent())
        {
            throw new NotFoundException();
        }
        return cartOptional.get();
    }

    @Override
    public void deleteById(Long idToDelete) {
        cartRespository.deleteById(idToDelete);
    }
}
