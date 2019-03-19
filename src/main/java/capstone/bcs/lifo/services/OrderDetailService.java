package capstone.bcs.lifo.services;

import capstone.bcs.lifo.model.OrderDetail;

import java.util.List;


public interface OrderDetailService {

    List<OrderDetail> getOrderDetails();

    OrderDetail findById(Long l);

    void deleteById(Long idToDelete);
}
