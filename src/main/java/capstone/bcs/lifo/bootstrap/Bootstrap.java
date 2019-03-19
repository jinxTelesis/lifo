package capstone.bcs.lifo.bootstrap;

import capstone.bcs.lifo.model.Account;
import capstone.bcs.lifo.model.Order;
import capstone.bcs.lifo.model.OrderDetail;
import capstone.bcs.lifo.model.Product;
import capstone.bcs.lifo.repositories.AccountRepository;
import capstone.bcs.lifo.repositories.OrderDetailRepository;
import capstone.bcs.lifo.repositories.OrderRepository;
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
    private final AccountRepository accountRepository;
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    public Bootstrap(ProductRepository productRepository, AccountRepository accountRepository, OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
        this.productRepository = productRepository;
        this.accountRepository = accountRepository;
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        productRepository.saveAll(getProducts());
        accountRepository.saveAll(getAccounts());
        orderRepository.saveAll(getOrders());
        orderDetailRepository.saveAll(getOrderDetails());

    }

    private List<Product> getProducts() {

        List<Product> products = new ArrayList<>(2);

        Product p1GeorgeFormanGrill = new Product();
        p1GeorgeFormanGrill.setProductName("George Forman Grill");
        p1GeorgeFormanGrill.setProductPrice(99.99);
        p1GeorgeFormanGrill.setProductImage("george_foreman.jpg");
        p1GeorgeFormanGrill.setProductDimensions(" ");
        p1GeorgeFormanGrill.setDescription1("The amazing grill that cooks your food evenly, while reducing the fat in any meats you cook. This item can be used in a variety of different dishes from Panini's to steaks.");
        p1GeorgeFormanGrill.setDescription2("The George Foreman GR144 Silver Grand Champ Family Size Indoor Grill is great for any family large or small.The 144 Sq");
        p1GeorgeFormanGrill.setDescription3("Get all the space you need to cook leaner for up to 9 people with our largest indoor contact grill. In. grilling surface easily fits up to 9 servings, with even heat from the center to the sides of the plate with our Signature Foreman heating elements.");
        p1GeorgeFormanGrill.setDescription4("Our patented sloped design and George Tough nonstick coating allow you to cook without oil or butter while fat and grease drain off for leaner meals in minutes. The grill includes a dishwasher safe drip tray for added convenience.");
        products.add(p1GeorgeFormanGrill);

        Product p2GinsuKnives = new Product();
        p2GinsuKnives.setProductName("Ginsu Knives");
        p2GinsuKnives.setProductPrice(79.99);
        p2GinsuKnives.setProductImage("ginsu_knives.jpg");
        p2GinsuKnives.setProductDimensions(" ");
        p2GinsuKnives.setDescription1("The perfect knives to get if you need to cut through a can and then slice a tomato right after.");
        // no second
        products.add(p2GinsuKnives);

        Product p3SlapChop = new Product();
        p3SlapChop.setProductName("Slap Chop");
        p3SlapChop.setProductPrice(24.99);
        p3SlapChop.setProductImage("slap_chop.jpg");
        p3SlapChop.setProductDimensions(" ");
        p3SlapChop.setDescription1("A great product to use for chopping and mincing vegetables.");
        p3SlapChop.setDescription2("STAINLESS STEEL & LARGE CUP CONTAINER: Slap Chop blades are made of the highest quality stainless steel while the convenient large cup container captures all foods that are chopped. High quality blades quickly deskin the garlic and onions in seconds.");
        products.add(p3SlapChop);

        Product p4ChiaPet = new Product();
        p4ChiaPet.setProductName("China pet");
        p4ChiaPet.setProductPrice(17.99);
        p4ChiaPet.setProductImage("chia_pets.jpg");
        p4ChiaPet.setProductDimensions(" ");
        p4ChiaPet.setDescription1("Trying to brighten up your office, or home. Why not spruce it up by growing a plant on a fake animal or face via the chia pet. Trust us this is cheaper than a put.");
        p4ChiaPet.setDescription2("Collecting and growing Chia Pet pottery planters has become an American tradition. Everybody loves Chia Pets! Kids and grown ups alike will enjoy \"watching them grow!\"");
        p4ChiaPet.setDescription3("Chia Pets are easy to grow making them a perfect first plant growing experience for kids. Makes a great gift! Collect them all!");
        products.add(p4ChiaPet);

        Product p5Energize10SolarLandscape = new Product();
        p5Energize10SolarLandscape.setProductName("Energize Solar landscape light");
        p5Energize10SolarLandscape.setProductPrice(79.99);
        p5Energize10SolarLandscape.setProductImage("solar.jpg");
        p5Energize10SolarLandscape.setProductDimensions(" ");
        p5Energize10SolarLandscape.setDescription1("Need to light up your yard? Well with this set of solar lights you can do just that.");
        p5Energize10SolarLandscape.setDescription2("Brighten the night with this 10-piece Energizer landscape light set. Each one is equipped with a crystalline solar panel that charges the light during the day, and then powers its gentle glow for up to eight hours a night.");
        p5Energize10SolarLandscape.setDescription3("Use the set to line your walkway, deck, or patio, and enjoy a soft, charming ambience for outdoor gatherings, late-night cocktails, or more surefooted stepping. From Energizer.\"");
        products.add(p5Energize10SolarLandscape);

        Product p6ShoeDini = new Product();
        p6ShoeDini.setProductName("ShowDini");
        p6ShoeDini.setProductPrice(9.99);
        p6ShoeDini.setProductImage("shoedini.jpg");
        p6ShoeDini.setProductDimensions(" ");
        p6ShoeDini.setDescription1("The simple tool used to get your shoes on and off whithout the need to bend down. Perfect for those whith back issues.");
        p6ShoeDini.setDescription2("Shoedini Shoe Horn extends to almost 3 feet to give you the extra reach you need!");
        products.add(p6ShoeDini);

        Product p7Snuggie = new Product();
        p7Snuggie.setProductName("Snuggie");
        p7Snuggie.setProductPrice(19.99);
        p7Snuggie.setProductImage("snuggie.jpg");
        p7Snuggie.setProductDimensions("12.3 x 11.3 x 5.6 inches ; 1.26 pounds");
        p7Snuggie.setDescription1("A warm blanket you can wear.");
        p7Snuggie.setDescription2("The Snuggie Blanket keeps you totally warm and gives you the freedom to use your hands. Work the remote, use your laptop or do some reading in total warmth and comfort! ");
        p7Snuggie.setDescription3("Put an end to those cold days and nights. The Snuggie Blanket is one of a kind with cuffed sleeves and a waist tie to keep you warm no matter what you're doing! ");
        products.add(p7Snuggie);

        Product p8TubShroom = new Product();
        p8TubShroom.setProductName("Tub Shroom");
        p8TubShroom.setProductPrice(9.99);
        p8TubShroom.setProductImage("tub_shroom.jpg");
        p8TubShroom.setProductDimensions("2.2 x 2.2 x 2 inches ; 0.48 ounces");
        p8TubShroom.setDescription1("A great way to stop all of that hair and clunky sludge from going down your drain.");
        p8TubShroom.setDescription2("We face a myriad of challenges each and every day. Cleaning clogged drains, thankfully, no longer has to be one of them--thanks to the TubShroom. ");
        p8TubShroom.setDescription3("TubShroom is a bathtub hair stopper that fits snug inside your shower tub drain, effortlessly gathering each and every hair that tries to make its way down your vulnerable drain. ");
        p8TubShroom.setDescription4("It's the hero you deserve in your bathroom. You can rest easy knowing that TubShroom works great for all kinds of hair-- human and pet alike.");
        products.add(p8TubShroom);

        Product p9WearableTowel = new Product();
        p9WearableTowel.setProductName("Wearable Towel");
        p9WearableTowel.setProductPrice(19.99);
        p9WearableTowel.setProductImage("wearable_towel.jpg");
        p9WearableTowel.setProductDimensions(" ");
        p9WearableTowel.setDescription1("A towel that you can wear, alleviates the issue of holding up towel after shower.");
        p9WearableTowel.setDescription2("The Wearable Towel has three arm openings placed along the side and does not employ the use of any fasteners. It is for unisex and can be worn in either a tunic style or a toga style.");
        products.add(p9WearableTowel);

        return products;
    }

    private List<Account> getAccounts(){
        List<Account> accounts = new ArrayList<Account>();
        return accounts;
    }

    private List<Order> getOrders(){
        List<Order> orders = new ArrayList<Order>();
        return orders;
    }

    private  List<OrderDetail> getOrderDetails(){
        List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
        return  orderDetails;
    }



}
