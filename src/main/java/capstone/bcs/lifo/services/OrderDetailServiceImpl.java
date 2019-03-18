package capstone.bcs.lifo.services;

import capstone.bcs.lifo.model.Account;
import capstone.bcs.lifo.model.OrderDetail;
import capstone.bcs.lifo.repositories.OrderDetailRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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
    public List<OrderDetail> getProducts() {
        List<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailRepository.findAll().iterator().forEachRemaining(orderDetailList::add);
        return orderDetailList;
    }

    @Override
    public Account findById(Long l) {
        Optional<OrderDetail> orderDetailOptional = orderDetailRepository.findById(l);
        return null;
    }

    @Override
    public void deleteById(Long idToDelete) {

    }

//
//    @Override
//    public Account findById(Long l) {
//        Optional<Account> accountOptional = accountRepository.findById(l);
//
//        if(!accountOptional.isPresent()){
//            throw new NotFoundException();
//        }
//        return accountOptional.get();
//    }
//
//    @Override
//    public void deleteById(Long idToDelete) {
//        accountRepository.deleteById(idToDelete);
//    }

}
