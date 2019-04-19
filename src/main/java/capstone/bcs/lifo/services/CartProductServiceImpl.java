package capstone.bcs.lifo.services;


import capstone.bcs.lifo.Exceptions.NotFoundException;
import capstone.bcs.lifo.model.CartProducts;
import capstone.bcs.lifo.repositories.CartProductsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CartProductServiceImpl implements CartProductsService {

    // this service needs to be finished 

    private final CartProductsRepository cartProductsRepository;

    public CartProductServiceImpl(CartProductsRepository cartProductsRepository) {
        this.cartProductsRepository = cartProductsRepository;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CartProducts> getCartProducts() {
        List<CartProducts> cartProductsList= new ArrayList<>();
        cartProductsRepository.findAll().iterator().forEachRemaining(cartProductsList::add);
        return cartProductsList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public CartProducts findById(Long longId) {
        Optional<CartProducts> cartProductsOptional = cartProductsRepository.findById(longId);
        if(!cartProductsOptional.isPresent()){
            throw new NotFoundException();
        }
        return cartProductsOptional.get();
    }

    @Override
    public void deleteById(Long idToDelete) {
        cartProductsRepository.deleteById(idToDelete);
    }

}
