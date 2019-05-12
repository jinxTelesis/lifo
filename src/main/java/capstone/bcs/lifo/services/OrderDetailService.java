package capstone.bcs.lifo.services;

import capstone.bcs.lifo.model.OrderDetail;

import java.util.List;


public interface OrderDetailService {

    /**
     * Interface for the OrderDetailService
     * This is to follow best practices with regard to SOLID
     *
     */

    List<OrderDetail> getOrderDetails();

    OrderDetail findById(Long l);

    void deleteById(Long idToDelete);
}
