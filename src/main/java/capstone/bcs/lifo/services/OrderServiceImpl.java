package capstone.bcs.lifo.services;

import capstone.bcs.lifo.Exceptions.NotFoundException;
import capstone.bcs.lifo.model.Order;
import capstone.bcs.lifo.repositories.OrderRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getOrders() {
        List<Order> orderList = new ArrayList<>();
        orderRepository.findAll().iterator().forEachRemaining(orderList::add);
        return orderList;
    }

    @Override
    public Order findById(Long l) {
        Optional<Order> orderOptional = orderRepository.findById(l);

        if(!orderOptional.isPresent()) {
            throw new NotFoundException();
        }
        return orderOptional.get();
    }

    @Override
    public void deleteById(Long idToDelete) {
        orderRepository.deleteById(idToDelete);
    }
    

}
