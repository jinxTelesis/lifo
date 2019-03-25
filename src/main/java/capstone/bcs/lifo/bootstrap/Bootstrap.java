package capstone.bcs.lifo.bootstrap;

import capstone.bcs.lifo.model.Account;
import capstone.bcs.lifo.model.OrderDetail;
import capstone.bcs.lifo.model.Product;
import capstone.bcs.lifo.repositories.AccountRepository;
import capstone.bcs.lifo.repositories.OrderDetailRepository;
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
    //private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    public Bootstrap(ProductRepository productRepository, AccountRepository accountRepository, OrderDetailRepository orderDetailRepository) {
        this.productRepository = productRepository;
        this.accountRepository = accountRepository;
        //this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        productRepository.saveAll(getProducts());
        accountRepository.saveAll(getAccounts());
        //orderRepository.saveAll(getOrders());
        orderDetailRepository.saveAll(getOrderDetails());

    }

    private List<Product> getProducts() {

        List<Product> products = new ArrayList<>(2);

        Product p1GeorgeFormanGrill = new Product();
        p1GeorgeFormanGrill.setProductCat(0);
        p1GeorgeFormanGrill.setProductName("George Forman Grill");
        p1GeorgeFormanGrill.setProductPrice(99.99);
        p1GeorgeFormanGrill.setProductImage("george_foreman.jpg");
        p1GeorgeFormanGrill.setProductDimensions(" ");
        p1GeorgeFormanGrill.setDescription1("The amazing grill that cooks your food evenly, while reducing the fat in any meats you cook. This item can be used in a variety of different dishes from Panini's to steaks.");
        p1GeorgeFormanGrill.setDescription2("The George Foreman GR144 Silver Grand Champ Family Size Indoor Grill is great for any family large or small.The 144 Sq");
        p1GeorgeFormanGrill.setDescription3("Get all the space you need to cook leaner for up to 9 people with our largest indoor contact grill. In. grilling surface easily fits up to 9 servings, with even heat from the center to the sides of the plate with our Signature Foreman heating elements.");
        p1GeorgeFormanGrill.setDescription4("Our patented sloped design and George Tough nonstick coating allow you to cook without oil or butter while fat and grease drain off for leaner meals in minutes. The grill includes a dishwasher safe drip tray for added convenience.");
        // added
        products.add(p1GeorgeFormanGrill);

        Product p2GinsuKnives = new Product();
        p2GinsuKnives.setProductCat(0);
        p2GinsuKnives.setProductName("Ginsu Knives");
        p2GinsuKnives.setProductPrice(79.99);
        p2GinsuKnives.setProductImage("ginsu_knives.jpg");
        p2GinsuKnives.setProductDimensions(" ");
        p2GinsuKnives.setDescription1("The perfect knives to get if you need to cut through a can and then slice a tomato right after.");
        // added
        products.add(p2GinsuKnives);

        Product p3SlapChop = new Product();
        p3SlapChop.setProductCat(2);
        p3SlapChop.setProductName("Slap Chop");
        p3SlapChop.setProductPrice(24.99);
        p3SlapChop.setProductImage("slap_chop.jpg");
        p3SlapChop.setProductDimensions(" ");
        p3SlapChop.setDescription1("A great product to use for chopping and mincing vegetables.");
        p3SlapChop.setDescription2("STAINLESS STEEL & LARGE CUP CONTAINER: Slap Chop blades are made of the highest quality stainless steel while the convenient large cup container captures all foods that are chopped. High quality blades quickly deskin the garlic and onions in seconds.");
        // added
        products.add(p3SlapChop);

        Product p4ChiaPet = new Product();
        p4ChiaPet.setProductCat(0);
        p4ChiaPet.setProductName("China pet");
        p4ChiaPet.setProductPrice(17.99);
        p4ChiaPet.setProductImage("chia_pets.jpg");
        p4ChiaPet.setProductDimensions(" ");
        p4ChiaPet.setDescription1("Trying to brighten up your office, or home. Why not spruce it up by growing a plant on a fake animal or face via the chia pet. Trust us this is cheaper than a put.");
        p4ChiaPet.setDescription2("Collecting and growing Chia Pet pottery planters has become an American tradition. Everybody loves Chia Pets! Kids and grown ups alike will enjoy \"watching them grow!\"");
        p4ChiaPet.setDescription3("Chia Pets are easy to grow making them a perfect first plant growing experience for kids. Makes a great gift! Collect them all!");
        // added
        products.add(p4ChiaPet);

        Product p5Energize10SolarLandscape = new Product();
        p5Energize10SolarLandscape.setProductCat(1);
        p5Energize10SolarLandscape.setProductName("Energize Solar landscape light");
        p5Energize10SolarLandscape.setProductPrice(79.99);
        p5Energize10SolarLandscape.setProductImage("solar.jpg");
        p5Energize10SolarLandscape.setProductDimensions(" ");
        p5Energize10SolarLandscape.setDescription1("Need to light up your yard? Well with this set of solar lights you can do just that.");
        p5Energize10SolarLandscape.setDescription2("Brighten the night with this 10-piece Energizer landscape light set. Each one is equipped with a crystalline solar panel that charges the light during the day, and then powers its gentle glow for up to eight hours a night.");
        p5Energize10SolarLandscape.setDescription3("Use the set to line your walkway, deck, or patio, and enjoy a soft, charming ambience for outdoor gatherings, late-night cocktails, or more surefooted stepping. From Energizer.\"");
        // added
        products.add(p5Energize10SolarLandscape);

        Product p6ShoeDini = new Product();
        p6ShoeDini.setProductCat(1);
        p6ShoeDini.setProductName("ShowDini");
        p6ShoeDini.setProductPrice(9.99);
        p6ShoeDini.setProductImage("shoedini.jpg");
        p6ShoeDini.setProductDimensions(" ");
        p6ShoeDini.setDescription1("The simple tool used to get your shoes on and off whithout the need to bend down. Perfect for those whith back issues.");
        p6ShoeDini.setDescription2("Shoedini Shoe Horn extends to almost 3 feet to give you the extra reach you need!");
        // added
        products.add(p6ShoeDini);

        Product p7Snuggie = new Product();
        p7Snuggie.setProductCat(1);
        p7Snuggie.setProductName("Snuggie");
        p7Snuggie.setProductPrice(19.99);
        p7Snuggie.setProductImage("snuggie.jpg");
        p7Snuggie.setProductDimensions("12.3 x 11.3 x 5.6 inches ; 1.26 pounds");
        p7Snuggie.setDescription1("A warm blanket you can wear.");
        p7Snuggie.setDescription2("The Snuggie Blanket keeps you totally warm and gives you the freedom to use your hands. Work the remote, use your laptop or do some reading in total warmth and comfort! ");
        p7Snuggie.setDescription3("Put an end to those cold days and nights. The Snuggie Blanket is one of a kind with cuffed sleeves and a waist tie to keep you warm no matter what you're doing! ");
        // added
        products.add(p7Snuggie);

        Product p8TubShroom = new Product();
        p8TubShroom.setProductCat(1);
        p8TubShroom.setProductName("Tub Shroom");
        p8TubShroom.setProductPrice(9.99);
        p8TubShroom.setProductImage("tub_shroom.jpg");
        p8TubShroom.setProductDimensions("2.2 x 2.2 x 2 inches ; 0.48 ounces");
        p8TubShroom.setDescription1("A great way to stop all of that hair and clunky sludge from going down your drain.");
        p8TubShroom.setDescription2("We face a myriad of challenges each and every day. Cleaning clogged drains, thankfully, no longer has to be one of them--thanks to the TubShroom. ");
        p8TubShroom.setDescription3("TubShroom is a bathtub hair stopper that fits snug inside your shower tub drain, effortlessly gathering each and every hair that tries to make its way down your vulnerable drain. ");
        p8TubShroom.setDescription4("It's the hero you deserve in your bathroom. You can rest easy knowing that TubShroom works great for all kinds of hair-- human and pet alike.");
        // added
        products.add(p8TubShroom);

        Product p9WearableTowel = new Product();
        p9WearableTowel.setProductCat(1);
        p9WearableTowel.setProductName("Wearable Towel");
        p9WearableTowel.setProductPrice(19.99);
        p9WearableTowel.setProductImage("wearable_towel.jpg");
        p9WearableTowel.setProductDimensions(" ");
        p9WearableTowel.setDescription1("A towel that you can wear, alleviates the issue of holding up towel after shower.");
        p9WearableTowel.setDescription2("The Wearable Towel has three arm openings placed along the side and does not employ the use of any fasteners. It is for unisex and can be worn in either a tunic style or a toga style.");
        // added
        products.add(p9WearableTowel);

        //
        //
        // cat break
        //
        //

        Product p10GLHHairSystem = new Product();
        p10GLHHairSystem.setProductCat(2);
        p10GLHHairSystem.setProductName("GLH Hair System");
        p10GLHHairSystem.setProductPrice(39.99);
        p10GLHHairSystem.setProductImage("glh.jpg");
        p10GLHHairSystem.setProductDimensions(" ");
        p10GLHHairSystem.setDescription1("A powder that attaches to the smallest of hair follicles and builds on itself to act like hair.");
        p10GLHHairSystem.setDescription2("Glh is the very latest breakthrough and contains almost life-like fibers that instantly give added body to your hair. Glh will take away that wispy look. Fill in those thin see-through spots and for men it can even cover bald spots.");
        // added
        products.add(p10GLHHairSystem);

        Product p11ShakeWeight = new Product();
        p11ShakeWeight.setProductCat(2);
        p11ShakeWeight.setProductName("Shake Weight");
        p11ShakeWeight.setProductPrice(19.99);
        p11ShakeWeight.setProductImage("shake_weight.jpg");
        p11ShakeWeight.setProductDimensions(" ");
        p11ShakeWeight.setDescription1("A training tool for the arms.");
        p11ShakeWeight.setDescription2("Get incredible results in just 6 minutes a day using the revolutionary new way to shape and tone your arms, shoulders and chest It's fun and easy to use. ");
        // added
        products.add(p11ShakeWeight);

        Product p13Bowflex = new Product();
        p13Bowflex.setProductCat(2);
        p13Bowflex.setProductName("Bowflex");
        p13Bowflex.setProductPrice(539.99);
        p13Bowflex.setProductImage("bowflex.png");
        p13Bowflex.setDescription1("Great in home gym to be used for heavy lifting and toning. Comes with a variety of workouts.");
        p13Bowflex.setDescription1("he Bowflex Ultimate 2 Home Gym is a total body solution that delivers everything you could possibly imagine for great fitness results.");
        p13Bowflex.setDescription1("It offers over 95 exercises and includes a lat tower, leg extension/leg curlstation, preacher curl, integrated squat station and more.");
        p13Bowflex.setProductDimensions("468 pounds");
        // added
        products.add(p13Bowflex);

        Product p14HawaiiChair = new Product();
        p14HawaiiChair.setProductCat(2);
        p14HawaiiChair.setProductImage("hula_chair.jpg");
        p14HawaiiChair.setProductPrice(49.99);
        p14HawaiiChair.setProductName("Hawaii Chair");
        p14HawaiiChair.setDescription1("A kind of swiveling chair that consistently moves in a circle and provides an abdominal work out.");
        p14HawaiiChair.setDescription2("This is a brand new Hawaii Chair (Hula Chair) and is built with steel feet, ABS armrest and leather backrest. Great gift for ladies!");
        p14HawaiiChair.setDescription3("9 Speeds with 60 Watt Power and Handle up to 300 Lbs. Exercises the whole body especially the waist. Strengthening intestines and stomach functions while stimulating blood flow");
        // added
        products.add(p14HawaiiChair);

        Product p15InStylerMax = new Product();
        p15InStylerMax.setProductCat(3);
        p15InStylerMax.setProductName("InStyler Max 2");
        p15InStylerMax.setProductPrice(19.99);
        p15InStylerMax.setProductImage("instyler.jpg");
        p15InStylerMax.setDescription1("The rotating iron, styles and dries your hair off at the same time.");
        p15InStylerMax.setDescription2("The MAX is the most advanced version of the InStyler rotating iron yet. The 2-way rotating barrel's innovative technology allows for change of direction with a simple double-click");
        p15InStylerMax.setDescription3("of the barrel for maximum results by rotating in the natural direction of your hair. With a tourmaline ceramic smoothing plate, dual rotating barrel and ionic bristles, the MAX straightens");
        p15InStylerMax.setProductDimensions("12 x 5.5 x 2.6 inches ; 1.4 pounds");
        // added
        products.add(p15InStylerMax);

        Product p16Kush = new Product();
        p16Kush.setProductCat(3);
        p16Kush.setProductName("Kush");
        p16Kush.setProductPrice(39.99);
        p16Kush.setProductImage("kush.jpg");
        p16Kush.setDescription1("An item made to support the breasts while sleep");
        p16Kush.setDescription2("Breast support for side sleepers, cup size C and larger - Kush Support provides the support your breasts need for comfortable sleep. ");
        p16Kush.setDescription3("Yet Kush Support is so lightweight and comfortable that it feels like part of your body. Foam adapts to your skin temperature.");
        p16Kush.setProductDimensions("6.5 x 4 x 3.9 inches ; 2.08 ounces");
        // added
        products.add(p16Kush);

        Product p17Proactiv = new Product();
        p17Proactiv.setProductCat(3);
        p17Proactiv.setProductName("Proactiv");
        p17Proactiv.setProductPrice(34.99);
        p17Proactiv.setProductImage("proactiv.jpg");
        p17Proactiv.setDescription1("Have a problem with acne? Proactiv is the dermatologists choice in handling clogs pores and keeping your face clean.");
        p17Proactiv.setDescription2("The Proactiv 3-Step System helps treat and prevent acne breakouts with proven acne-fighting ingredients. The Renewing Cleanser and Repairing Treatment contain benzoyl peroxide");
        p17Proactiv.setDescription3("a proven acne medicine known to kill and prevent acne bacteria. The alcohol-free Revitalizing Toner helps to gently remove excess oil and soften acne-prone skin with glycolic acid. ");
        p17Proactiv.setProductDimensions("9 x 2.8 x 1.3 inches; 1.2 pounds");
        // added
        products.add(p17Proactiv);

        Product p18Rej = new Product();
        p18Rej.setProductCat(3);
        p18Rej.setProductName("Rejuvenique Electric Facial Mask");
        p18Rej.setProductPrice(99.99);
        p18Rej.setProductImage("rejuvenique.jpg");
        p18Rej.setDescription1("A great Halloween mask and facial toner. This tool was advertised as a product that would reduce wrinkles. Requires a 9-volt battery.");
        p18Rej.setDescription2("Set includes: rejuvenique mask adjustable, washable headband control handset cable connector 9 volt battery owner s manual");
        p18Rej.setDescription3("By delivering a light pulsation from a 9-volt battery (included), the 26 gold-plated contact points inside this facemask gradually tone the skin and reduce the appearance of wrinkling.");
        p18Rej.setProductDimensions("10.5 x 3.8 x 11.2 inches ; 1 pounds");
        // added
        products.add(p18Rej);

        Product p19Sweatin = new Product();
        p19Sweatin.setProductCat(3);
        p19Sweatin.setProductName("Sweatin’ to the oldies");
        p19Sweatin.setProductPrice(9.99);
        p19Sweatin.setProductImage("sweatin_to_the_oldies.jpg");
        p19Sweatin.setDescription1("A classic work out video featuring Richard Simmons, and some classy music. Lose yourself and some pounds by tuning into this vigorous work out.");
        p19Sweatin.setDescription2("Turn back time with America's Favorite Fitness Expert, Richard Simmons! Celebrating 25 years since the original Sweatin' to the Oldies, fall in love with fun fitness all over again");
        p19Sweatin.setDescription3("with this low impact routine guaranteed to get you off the couch and getting into shape.");
        // added
        products.add(p19Sweatin);

        Product p20ThighMaster = new Product();
        p20ThighMaster.setProductCat(3);
        p20ThighMaster.setProductName("ThighMaster");
        p20ThighMaster.setProductPrice(12.99);
        p20ThighMaster.setProductImage("thigh_master.jpg");
        p20ThighMaster.setDescription1("A product that can be used to tone legs and arms for multiple work outs.");
        p20ThighMaster.setDescription2("It's the ThighMaster Gold and the ButtMaster (LBX) together for the ultimate lower body workout. This is the only original ThighMaster straight from Suzanne. Don't accept any knock-off brands.");
        p20ThighMaster.setDescription3(" Both tools aid in sculpting arms, shoulders, chest and back. It's the fast, easy, and inexpensive way to get in shape. Comes with an instructional DVD.");
        // added
        products.add(p20ThighMaster);

//        Product p1GeorgeFormanGrill = new Product();
//        p1GeorgeFormanGrill.setProductCat(5);
//        p1GeorgeFormanGrill.setProductName("George Forman Grill");
//        p1GeorgeFormanGrill.setProductPrice(99.99);
//        p1GeorgeFormanGrill.setProductImage("george_foreman.jpg");
//        p1GeorgeFormanGrill.setProductDimensions(" ");
//        p1GeorgeFormanGrill.setDescription1("The amazing grill that cooks your food evenly, while reducing the fat in any meats you cook. This item can be used in a variety of different dishes from Panini's to steaks.");
//        p1GeorgeFormanGrill.setDescription2("The George Foreman GR144 Silver Grand Champ Family Size Indoor Grill is great for any family large or small.The 144 Sq");
//        p1GeorgeFormanGrill.setDescription3("Get all the space you need to cook leaner for up to 9 people with our largest indoor contact grill. In. grilling surface easily fits up to 9 servings, with even heat from the center to the sides of the plate with our Signature Foreman heating elements.");
//        p1GeorgeFormanGrill.setDescription4("Our patented sloped design and George Tough nonstick coating allow you to cook without oil or butter while fat and grease drain off for leaner meals in minutes. The grill includes a dishwasher safe drip tray for added convenience.");
//        // added
//        products.add(p1GeorgeFormanGrill);
//
//        Product p2GinsuKnives = new Product();
//        p2GinsuKnives.setProductCat(5);
//        p2GinsuKnives.setProductName("Ginsu Knives");
//        p2GinsuKnives.setProductPrice(79.99);
//        p2GinsuKnives.setProductImage("ginsu_knives.jpg");
//        p2GinsuKnives.setProductDimensions(" ");
//        p2GinsuKnives.setDescription1("The perfect knives to get if you need to cut through a can and then slice a tomato right after.");
//        // added
//        products.add(p2GinsuKnives);
//
//        Product p3SlapChop = new Product();
//        p3SlapChop.setProductCat(5);
//        p3SlapChop.setProductName("Slap Chop");
//        p3SlapChop.setProductPrice(24.99);
//        p3SlapChop.setProductImage("slap_chop.jpg");
//        p3SlapChop.setProductDimensions(" ");
//        p3SlapChop.setDescription1("A great product to use for chopping and mincing vegetables.");
//        p3SlapChop.setDescription2("STAINLESS STEEL & LARGE CUP CONTAINER: Slap Chop blades are made of the highest quality stainless steel while the convenient large cup container captures all foods that are chopped. High quality blades quickly deskin the garlic and onions in seconds.");
//        // added
//        products.add(p3SlapChop);
//
//        Product p4ChiaPet = new Product();
//        p4ChiaPet.setProductCat(5);
//        p4ChiaPet.setProductName("China pet");
//        p4ChiaPet.setProductPrice(17.99);
//        p4ChiaPet.setProductImage("chia_pets.jpg");
//        p4ChiaPet.setProductDimensions(" ");
//        p4ChiaPet.setDescription1("Trying to brighten up your office, or home. Why not spruce it up by growing a plant on a fake animal or face via the chia pet. Trust us this is cheaper than a put.");
//        p4ChiaPet.setDescription2("Collecting and growing Chia Pet pottery planters has become an American tradition. Everybody loves Chia Pets! Kids and grown ups alike will enjoy \"watching them grow!\"");
//        p4ChiaPet.setDescription3("Chia Pets are easy to grow making them a perfect first plant growing experience for kids. Makes a great gift! Collect them all!");
//        // added
//        products.add(p4ChiaPet);
//
//        Product p5Energize10SolarLandscape = new Product();
//        p5Energize10SolarLandscape.setProductCat(5);
//        p5Energize10SolarLandscape.setProductName("Energize Solar landscape light");
//        p5Energize10SolarLandscape.setProductPrice(79.99);
//        p5Energize10SolarLandscape.setProductImage("solar.jpg");
//        p5Energize10SolarLandscape.setProductDimensions(" ");
//        p5Energize10SolarLandscape.setDescription1("Need to light up your yard? Well with this set of solar lights you can do just that.");
//        p5Energize10SolarLandscape.setDescription2("Brighten the night with this 10-piece Energizer landscape light set. Each one is equipped with a crystalline solar panel that charges the light during the day, and then powers its gentle glow for up to eight hours a night.");
//        p5Energize10SolarLandscape.setDescription3("Use the set to line your walkway, deck, or patio, and enjoy a soft, charming ambience for outdoor gatherings, late-night cocktails, or more surefooted stepping. From Energizer.\"");
//        // added
//        products.add(p5Energize10SolarLandscape);
//
//        Product p6ShoeDini = new Product();
//        p6ShoeDini.setProductCat(5);
//        p6ShoeDini.setProductName("ShowDini");
//        p6ShoeDini.setProductPrice(9.99);
//        p6ShoeDini.setProductImage("shoedini.jpg");
//        p6ShoeDini.setProductDimensions(" ");
//        p6ShoeDini.setDescription1("The simple tool used to get your shoes on and off whithout the need to bend down. Perfect for those whith back issues.");
//        p6ShoeDini.setDescription2("Shoedini Shoe Horn extends to almost 3 feet to give you the extra reach you need!");
//        // added
//        products.add(p6ShoeDini);
//
//        Product p7Snuggie = new Product();
//        p7Snuggie.setProductCat(5);
//        p7Snuggie.setProductName("Snuggie");
//        p7Snuggie.setProductPrice(19.99);
//        p7Snuggie.setProductImage("snuggie.jpg");
//        p7Snuggie.setProductDimensions("12.3 x 11.3 x 5.6 inches ; 1.26 pounds");
//        p7Snuggie.setDescription1("A warm blanket you can wear.");
//        p7Snuggie.setDescription2("The Snuggie Blanket keeps you totally warm and gives you the freedom to use your hands. Work the remote, use your laptop or do some reading in total warmth and comfort! ");
//        p7Snuggie.setDescription3("Put an end to those cold days and nights. The Snuggie Blanket is one of a kind with cuffed sleeves and a waist tie to keep you warm no matter what you're doing! ");
//        // added
//        products.add(p7Snuggie);
//
//        Product p8TubShroom = new Product();
//        p8TubShroom.setProductCat(5);
//        p8TubShroom.setProductName("Tub Shroom");
//        p8TubShroom.setProductPrice(9.99);
//        p8TubShroom.setProductImage("tub_shroom.jpg");
//        p8TubShroom.setProductDimensions("2.2 x 2.2 x 2 inches ; 0.48 ounces");
//        p8TubShroom.setDescription1("A great way to stop all of that hair and clunky sludge from going down your drain.");
//        p8TubShroom.setDescription2("We face a myriad of challenges each and every day. Cleaning clogged drains, thankfully, no longer has to be one of them--thanks to the TubShroom. ");
//        p8TubShroom.setDescription3("TubShroom is a bathtub hair stopper that fits snug inside your shower tub drain, effortlessly gathering each and every hair that tries to make its way down your vulnerable drain. ");
//        p8TubShroom.setDescription4("It's the hero you deserve in your bathroom. You can rest easy knowing that TubShroom works great for all kinds of hair-- human and pet alike.");
//        // added
//        products.add(p8TubShroom);
//
//        Product p9WearableTowel = new Product();
//        p9WearableTowel.setProductCat(5);
//        p9WearableTowel.setProductName("Wearable Towel");
//        p9WearableTowel.setProductPrice(19.99);
//        p9WearableTowel.setProductImage("wearable_towel.jpg");
//        p9WearableTowel.setProductDimensions(" ");
//        p9WearableTowel.setDescription1("A towel that you can wear, alleviates the issue of holding up towel after shower.");
//        p9WearableTowel.setDescription2("The Wearable Towel has three arm openings placed along the side and does not employ the use of any fasteners. It is for unisex and can be worn in either a tunic style or a toga style.");
//        // added
//        products.add(p9WearableTowel);
//
//        //
//        //
//        // cat break
//        //
//        //
//
//        Product p10GLHHairSystem = new Product();
//        p10GLHHairSystem.setProductCat(4);
//        p10GLHHairSystem.setProductName("GLH Hair System");
//        p10GLHHairSystem.setProductPrice(39.99);
//        p10GLHHairSystem.setProductImage("GLH.jpg");
//        p10GLHHairSystem.setProductDimensions(" ");
//        p10GLHHairSystem.setDescription1("A powder that attaches to the smallest of hair follicles and builds on itself to act like hair.");
//        p10GLHHairSystem.setDescription2("Glh is the very latest breakthrough and contains almost life-like fibers that instantly give added body to your hair. Glh will take away that wispy look. Fill in those thin see-through spots and for men it can even cover bald spots.");
//        // added
//        products.add(p10GLHHairSystem);
//
//        Product p11ShakeWeight = new Product();
//        p11ShakeWeight.setProductCat(4);
//        p11ShakeWeight.setProductName("Shake Weight");
//        p11ShakeWeight.setProductPrice(19.99);
//        p11ShakeWeight.setProductImage("shake_weight.jpg");
//        p11ShakeWeight.setProductDimensions(" ");
//        p11ShakeWeight.setDescription1("A training tool for the arms.");
//        p11ShakeWeight.setDescription2("Get incredible results in just 6 minutes a day using the revolutionary new way to shape and tone your arms, shoulders and chest It's fun and easy to use. ");
//        // added
//        products.add(p11ShakeWeight);
//
//        Product p13Bowflex = new Product();
//        p13Bowflex.setProductCat(4);
//        p13Bowflex.setProductName("Bowflex");
//        p13Bowflex.setProductPrice(539.99);
//        p13Bowflex.setProductImage("bowflex.png");
//        p13Bowflex.setDescription1("Great in home gym to be used for heavy lifting and toning. Comes with a variety of workouts.");
//        p13Bowflex.setDescription1("he Bowflex Ultimate 2 Home Gym is a total body solution that delivers everything you could possibly imagine for great fitness results.");
//        p13Bowflex.setDescription1("It offers over 95 exercises and includes a lat tower, leg extension/leg curlstation, preacher curl, integrated squat station and more.");
//        p13Bowflex.setProductDimensions("468 pounds");
//        // added
//        products.add(p13Bowflex);
//
//        Product p14HawaiiChair = new Product();
//        p14HawaiiChair.setProductCat(4);
//        p14HawaiiChair.setProductImage("hula_chair.jpg");
//        p14HawaiiChair.setProductPrice(49.99);
//        p14HawaiiChair.setProductName("Hawaii Chair");
//        p14HawaiiChair.setDescription1("A kind of swiveling chair that consistently moves in a circle and provides an abdominal work out.");
//        p14HawaiiChair.setDescription2("This is a brand new Hawaii Chair (Hula Chair) and is built with steel feet, ABS armrest and leather backrest. Great gift for ladies!");
//        p14HawaiiChair.setDescription3("9 Speeds with 60 Watt Power and Handle up to 300 Lbs. Exercises the whole body especially the waist. Strengthening intestines and stomach functions while stimulating blood flow");
//        // added
//        products.add(p14HawaiiChair);
//
//        Product p15InStylerMax = new Product();
//        p15InStylerMax.setProductCat(4);
//        p15InStylerMax.setProductName("InStyler Max 2");
//        p15InStylerMax.setProductPrice(19.99);
//        p15InStylerMax.setProductImage("instyler.jpg");
//        p15InStylerMax.setDescription1("The rotating iron, styles and dries your hair off at the same time.");
//        p15InStylerMax.setDescription2("The MAX is the most advanced version of the InStyler rotating iron yet. The 2-way rotating barrel's innovative technology allows for change of direction with a simple double-click");
//        p15InStylerMax.setDescription3("of the barrel for maximum results by rotating in the natural direction of your hair. With a tourmaline ceramic smoothing plate, dual rotating barrel and ionic bristles, the MAX straightens");
//        p15InStylerMax.setProductDimensions("12 x 5.5 x 2.6 inches ; 1.4 pounds");
//        // added
//        products.add(p15InStylerMax);
//
//        Product p16Kush = new Product();
//        p16Kush.setProductCat(4);
//        p16Kush.setProductName("Kush");
//        p16Kush.setProductPrice(39.99);
//        p16Kush.setProductImage("kush.jpg");
//        p16Kush.setDescription1("An item made to support the breasts while sleep");
//        p16Kush.setDescription2("Breast support for side sleepers, cup size C and larger - Kush Support provides the support your breasts need for comfortable sleep. ");
//        p16Kush.setDescription3("Yet Kush Support is so lightweight and comfortable that it feels like part of your body. Foam adapts to your skin temperature.");
//        p16Kush.setProductDimensions("6.5 x 4 x 3.9 inches ; 2.08 ounces");
//        // added
//        products.add(p16Kush);
//
//        Product p17Proactiv = new Product();
//        p17Proactiv.setProductCat(4);
//        p17Proactiv.setProductName("Proactiv");
//        p17Proactiv.setProductPrice(34.99);
//        p17Proactiv.setProductImage("proactiv.jpg");
//        p17Proactiv.setDescription1("Have a problem with acne? Proactiv is the dermatologists choice in handling clogs pores and keeping your face clean.");
//        p17Proactiv.setDescription2("The Proactiv 3-Step System helps treat and prevent acne breakouts with proven acne-fighting ingredients. The Renewing Cleanser and Repairing Treatment contain benzoyl peroxide");
//        p17Proactiv.setDescription3("a proven acne medicine known to kill and prevent acne bacteria. The alcohol-free Revitalizing Toner helps to gently remove excess oil and soften acne-prone skin with glycolic acid. ");
//        p17Proactiv.setProductDimensions("9 x 2.8 x 1.3 inches; 1.2 pounds");
//        // added
//        products.add(p17Proactiv);
//
//        Product p18Rej = new Product();
//        p18Rej.setProductCat(4);
//        p18Rej.setProductName("Rejuvenique Electric Facial Mask");
//        p18Rej.setProductPrice(99.99);
//        p18Rej.setProductImage("Rejuvenique.jpg");
//        p18Rej.setDescription1("A great Halloween mask and facial toner. This tool was advertised as a product that would reduce wrinkles. Requires a 9-volt battery.");
//        p18Rej.setDescription2("Set includes: rejuvenique mask adjustable, washable headband control handset cable connector 9 volt battery owner s manual");
//        p18Rej.setDescription3("By delivering a light pulsation from a 9-volt battery (included), the 26 gold-plated contact points inside this facemask gradually tone the skin and reduce the appearance of wrinkling.");
//        p18Rej.setProductDimensions("10.5 x 3.8 x 11.2 inches ; 1 pounds");
//        // added
//        products.add(p18Rej);
//
//        Product p19Sweatin = new Product();
//        p19Sweatin.setProductCat(4);
//        p19Sweatin.setProductName("Sweatin’ to the oldies");
//        p19Sweatin.setProductPrice(9.99);
//        p19Sweatin.setProductImage("sweatin_to_the_oldies.jpg");
//        p19Sweatin.setDescription1("A classic work out video featuring Richard Simmons, and some classy music. Lose yourself and some pounds by tuning into this vigorous work out.");
//        p19Sweatin.setDescription2("Turn back time with America's Favorite Fitness Expert, Richard Simmons! Celebrating 25 years since the original Sweatin' to the Oldies, fall in love with fun fitness all over again");
//        p19Sweatin.setDescription3("with this low impact routine guaranteed to get you off the couch and getting into shape.");
//        // added
//        products.add(p19Sweatin);
//
//        Product p20ThighMaster = new Product();
//        p20ThighMaster.setProductCat(4);
//        p20ThighMaster.setProductName("ThighMaster");
//        p20ThighMaster.setProductPrice(12.99);
//        p20ThighMaster.setProductImage("ThighMaster.jpg");
//        p20ThighMaster.setDescription1("A product that can be used to tone legs and arms for multiple work outs.");
//        p20ThighMaster.setDescription2("It's the ThighMaster Gold and the ButtMaster (LBX) together for the ultimate lower body workout. This is the only original ThighMaster straight from Suzanne. Don't accept any knock-off brands.");
//        p20ThighMaster.setDescription3(" Both tools aid in sculpting arms, shoulders, chest and back. It's the fast, easy, and inexpensive way to get in shape. Comes with an instructional DVD.");
//        // added
//        products.add(p20ThighMaster);
//
//
//
//
//        //
//        //
//        // cat break
//        //
//        //
//
//        // == this is a duplicate left it in for now == the squiggly lines are telling you it is repeat code ==
//        Product p12ShoeDini = new Product();
//        p12ShoeDini.setProductName("ShoeDini");
//        p12ShoeDini.setProductCat(12);
//        p12ShoeDini.setProductPrice(9.99);
//        p12ShoeDini.setProductImage("shoedini.jpg");
//        p12ShoeDini.setProductDimensions(" ");
//        p12ShoeDini.setDescription1("The simple tool used to get your shoes on and off whithout the need to bend down. Perfect for those whith back issues.");
//        p12ShoeDini.setDescription2("Shoedini Shoe Horn extends to almost 3 feet to give you the extra reach you need!");
//        // added
//        products.add(p12ShoeDini);

        return products;
    }

    private List<Account> getAccounts(){
        List<Account> accounts = new ArrayList<Account>();
        Account jimsAccount = new Account();


        jimsAccount.setActive(true);
        jimsAccount.setUserName("Biffman1000");
        jimsAccount.setUserName("macNCheese");
        jimsAccount.setUserRole("Customer");

        accounts.add(jimsAccount);

        Account bethsAccount = new Account();
        bethsAccount.setActive(true);
        bethsAccount.setUserName("Chelseaseasea");
        bethsAccount.setUserRole("lovethatmacnCheese");
        bethsAccount.setUserRole("Customer");

        accounts.add(bethsAccount);

        return accounts;
    }

//    private List<Order> getOrders(){
//        List<Order> orders = new ArrayList<Order>();
//
////        Order F1000 = new Order();
////        F1000.setAmount(100.00);
////        F1000.setAddress1("10 Parker street");
////        F1000.setAddress2("upstairs apt");
////        F1000.setCountry("United States");
////        F1000.setCustomerEmail("farklank10@hotmail.com");
////        F1000.setCustomerName("billy");
////        F1000.setCustomerPhone("517-2788-1281");
////
////        Date ordeDate = new Date();
////        ordeDate.setTime(10213131);
////        F1000.setOrderDate(ordeDate);
////
////        Date ordertime = new Date();
////        ordertime.setTime(1213131);
////        F1000.setOrderTime(ordertime);
////        F1000.setState("NY");
////        F1000.setZip(10001);
////        orders.add(F1000);
////
////        Order F1001 = new Order();
////        F1001.setAmount(105.17);
////        F1001.setAddress1("17 Parker street");
////        F1001.setAddress2("back apt");
////        F1001.setCountry("United States");
////        F1001.setCustomerEmail("Bifarklank10@hotmail.com");
////        F1001.setCustomerName("lisy");
////        F1001.setCustomerPhone("518-2788-1281");
////
////        Date ordeDate1 = new Date();
////        ordeDate.setTime(1021131);
////        F1001.setOrderDate(ordeDate1);
////
////        Date ordertime2 = new Date();
////        ordertime.setTime(113131);
////        F1001.setOrderTime(ordertime2);
////        F1001.setState("NY");
////        F1001.setZip(11001);
////        orders.add(F1001);
//
//
//        return orders;
//    }

    // last one to do
    private  List<OrderDetail> getOrderDetails() {
        List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setAmount(100.07);
        orderDetail1.setOrderID("100cahbx");
        orderDetail1.setPrice(10.1);
        orderDetail1.setProductID("hb1c");
        orderDetail1.setQuantity(2);

        // == added to the list == //
        orderDetails.add(orderDetail1);

        OrderDetail orderDetai2 = new OrderDetail();
        orderDetai2.setAmount(78.1);
        orderDetai2.setOrderID("100cabhx");
        orderDetai2.setPrice(10.8);
        orderDetai2.setProductID("blunkjk");
        orderDetai2.setQuantity(3);

        // == added to the list == /
        orderDetails.add(orderDetai2);

        OrderDetail orderDetai3 = new OrderDetail();
        orderDetai3.setAmount(100.07);
        orderDetai3.setProductID("100cads");
        orderDetai3.setPrice(10.4);
        orderDetai3.setProductID("spiff");
        orderDetai3.setQuantity(4);


        return orderDetails;
    }

}
