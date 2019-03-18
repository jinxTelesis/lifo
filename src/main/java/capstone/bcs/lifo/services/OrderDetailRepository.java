package capstone.bcs.lifo.services;

import capstone.bcs.lifo.model.Account;
import capstone.bcs.lifo.model.OrderDetail;

import java.util.List;

public interface OrderDetailRepository {

    List<OrderDetail> getProducts();

    Account findById(Long l);

    void deleteById(Long idToDelete);
}
