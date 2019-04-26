package capstone.bcs.lifo.services;

import capstone.bcs.lifo.Exceptions.NotFoundException;
import capstone.bcs.lifo.model.CartV2;
import capstone.bcs.lifo.repositories.CartV2Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final CartV2Repository cartV2Repository;

    public CartServiceImpl(CartV2Repository cartV2Repository) {
        this.cartV2Repository = cartV2Repository;
    }

    @Override
    public List<CartV2> getCarts() {
        //List<CartOld> cartList = new ArrayList<>();
        List<CartV2> cartV2 = new ArrayList<>();
        cartV2Repository.findAll().iterator().forEachRemaining(cartV2::add);
        //cartRespository.findAll().iterator().forEachRemaining(cartList::add);
        return cartV2;
    }

    //@SuppressWarnings("unchecked")
    @Override
    public CartV2 findById(Long l) {
        Optional<CartV2> cartOptional = cartV2Repository.findById(l);
        if(!cartOptional.isPresent())
        {
            throw new NotFoundException();
        }
        return cartOptional.get();
    }

    @Override
    public void deleteById(Long idToDelete) {
        cartV2Repository.deleteById(idToDelete);
    }
}
