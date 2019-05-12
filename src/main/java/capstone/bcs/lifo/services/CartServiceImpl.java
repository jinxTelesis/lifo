package capstone.bcs.lifo.services;

import capstone.bcs.lifo.Exceptions.NotFoundException;
import capstone.bcs.lifo.model.CartV2;
import capstone.bcs.lifo.repositories.CartV2Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    /** CartServiceImpl implements CartService
     * the service is a convenience class to abstract some of the search operations
     * this removes it from directly accessing the repository

     */

    private final CartV2Repository cartV2Repository;

    public CartServiceImpl(CartV2Repository cartV2Repository) {
        this.cartV2Repository = cartV2Repository;
    }

    @Override
    public List<CartV2> getCarts() {
        List<CartV2> cartV2 = new ArrayList<>();
        cartV2Repository.findAll().iterator().forEachRemaining(cartV2::add);
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

    @Override
    public CartV2 findByUserName(String username){
        List<CartV2> cartList = new ArrayList<>();
        cartV2Repository.findAll().iterator().forEachRemaining(cartList::add);

        List<CartV2> cartV2ResultList = cartList.stream()
                .filter(cartV2 -> cartV2.getCustomerV2().getAccount().getUsername().equals(username))
                .collect(Collectors.toList());
        CartV2 cartV2ReturnValue = cartV2ResultList.get(0);
        return cartV2ReturnValue;

    }

}
