package capstone.bcs.lifo.services;

import capstone.bcs.lifo.model.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {

    List<OrderDetail> getProducts();

    Optional<OrderDetail> findById(Long l);

    void deleteById(Long idToDelete);
}
