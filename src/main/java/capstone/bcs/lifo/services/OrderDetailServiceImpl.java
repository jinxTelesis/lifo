package capstone.bcs.lifo.services;

import capstone.bcs.lifo.Exceptions.NotFoundException;
import capstone.bcs.lifo.model.OrderDetail;
import capstone.bcs.lifo.repositories.OrderDetailRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

    private final OrderDetailRepository orderDetailRepository;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public List<OrderDetail> getOrderDetails() {
        List<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailRepository.findAll().iterator().forEachRemaining(orderDetailList::add);
        return orderDetailList;
    }

    @Override
    public OrderDetail findById(Long l) {
        Optional<OrderDetail> orderDetailOptional = orderDetailRepository.findById(l);

        if(!orderDetailOptional.isPresent()){
            throw new NotFoundException();
        }
        return orderDetailOptional.get();
    }

    @Override
    public void deleteById(Long idToDelete) {
        orderDetailRepository.deleteById(idToDelete);
    }


}
