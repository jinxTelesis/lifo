package capstone.bcs.lifo.services;

import capstone.bcs.lifo.model.Order;

import java.util.List;

public interface OrderService {

    /**
     * Interface for the OrderDetailService
     * This is to follow best practices with regard to SOLID
     *
     */

    List<Order> getOrders();

    Order findById(Long l);

    void deleteById(Long idToDelete);
}
