package capstone.bcs.lifo.services;

import capstone.bcs.lifo.model.Account;
import capstone.bcs.lifo.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getProducts();

    Order findById(Long l);

    void deleteById(Long idToDelete);
}
