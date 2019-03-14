package capstone.bcs.lifo.bootstrap;

import capstone.bcs.lifo.model.Product;
import capstone.bcs.lifo.repositories.ProductRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final ProductRepository productRepository;

    public Bootstrap(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        productRepository.saveAll(getProducts());

    }

    private List<Product> getProducts() {

        List<Product> products = new ArrayList<>(2);

        Product p1 = new Product();
        p1.setDescription1("rice maker");
        p1.setProductPrice(10.00);
        p1.setDescription1("rice maker from another planet");

        products.add(p1);

        Product p2 = new Product();
        p2.setDescription1("bean cooker");
        p2.setProductPrice(12.00);
        p2.setDescription1("bean cooker from another planet");

        products.add(p2);

        Product p3 = new Product();
        p3.setDescription1("cheese maker");
        p3.setProductPrice(105.13);
        p2.setDescription2("this product makes really great cheese");
        products.add(p3);

        return products;
    }


}
