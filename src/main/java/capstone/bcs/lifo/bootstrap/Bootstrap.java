package capstone.bcs.lifo.bootstrap;

import capstone.bcs.lifo.model.*;
import capstone.bcs.lifo.repositories.CustomerRepository;
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
    //private final AccountRepository accountRepository;
    //private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    // == testing remove ==
    //private final CustomerRepository customerRepository;

    public Bootstrap(ProductRepository productRepository, OrderDetailRepository orderDetailRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        //this.accountRepository = accountRepository;
        //this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        // == testing remove ==
        //this.customerRepository = customerRepository;
    }


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        productRepository.saveAll(getProducts());
        //accountRepository.saveAll(getAccounts());
        //orderRepository.saveAll(getOrders());
        orderDetailRepository.saveAll(getOrderDetails());
        //customerRepository.saveAll(getCustomers());

    }

    private List<Product> getProducts() {

        List<Product> products = new ArrayList<>(2);

//        Product p1GeorgeFormanGrill = new Product();
//        p1GeorgeFormanGrill.setProductCat(0);
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
//        p2GinsuKnives.setProductCat(1);
//        p2GinsuKnives.setProductName("Ginsu Knives");
//        p2GinsuKnives.setProductPrice(79.99);
//        p2GinsuKnives.setProductImage("ginsu_knives.jpg");
//        p2GinsuKnives.setProductDimensions(" ");
//        p2GinsuKnives.setDescription1("The perfect knives to get if you need to cut through a can and then slice a tomato right after.");
//        // added
//        products.add(p2GinsuKnives);
//
//        Product p3SlapChop = new Product();
//        p3SlapChop.setProductCat(2);
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
//        p4ChiaPet.setProductCat(3);
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
//        p5Energize10SolarLandscape.setProductCat(4);
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
//        p7Snuggie.setProductCat(6);
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
//        p8TubShroom.setProductCat(7);
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
//        p9WearableTowel.setProductCat(8);
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
//        p10GLHHairSystem.setProductCat(9);
//        p10GLHHairSystem.setProductName("GLH Hair System");
//        p10GLHHairSystem.setProductPrice(39.99);
//        p10GLHHairSystem.setProductImage("glh.jpg");
//        p10GLHHairSystem.setProductDimensions(" ");
//        p10GLHHairSystem.setDescription1("A powder that attaches to the smallest of hair follicles and builds on itself to act like hair.");
//        p10GLHHairSystem.setDescription2("Glh is the very latest breakthrough and contains almost life-like fibers that instantly give added body to your hair. Glh will take away that wispy look. Fill in those thin see-through spots and for men it can even cover bald spots.");
//        // added
//        products.add(p10GLHHairSystem);
//
//        Product p11ShakeWeight = new Product();
//        p11ShakeWeight.setProductCat(10);
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
//        p13Bowflex.setProductCat(11);
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
//        p14HawaiiChair.setProductCat(12);
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
//        p15InStylerMax.setProductCat(13);
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
//        p16Kush.setProductCat(14);
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
//        p17Proactiv.setProductCat(15);
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
//        p18Rej.setProductCat(16);
//        p18Rej.setProductName("Rejuvenique Electric Facial Mask");
//        p18Rej.setProductPrice(99.99);
//        p18Rej.setProductImage("rejuvenique.jpg");
//        p18Rej.setDescription1("A great Halloween mask and facial toner. This tool was advertised as a product that would reduce wrinkles. Requires a 9-volt battery.");
//        p18Rej.setDescription2("Set includes: rejuvenique mask adjustable, washable headband control handset cable connector 9 volt battery owner s manual");
//        p18Rej.setDescription3("By delivering a light pulsation from a 9-volt battery (included), the 26 gold-plated contact points inside this facemask gradually tone the skin and reduce the appearance of wrinkling.");
//        p18Rej.setProductDimensions("10.5 x 3.8 x 11.2 inches ; 1 pounds");
//        // added
//        products.add(p18Rej);
//
//        Product p19Sweatin = new Product();
//        p19Sweatin.setProductCat(17);
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
//        p20ThighMaster.setProductCat(18);
//        p20ThighMaster.setProductName("ThighMaster");
//        p20ThighMaster.setProductPrice(12.99);
//        p20ThighMaster.setProductImage("thigh_master.jpg");
//        p20ThighMaster.setDescription1("A product that can be used to tone legs and arms for multiple work outs.");
//        p20ThighMaster.setDescription2("It's the ThighMaster Gold and the ButtMaster (LBX) together for the ultimate lower body workout. This is the only original ThighMaster straight from Suzanne. Don't accept any knock-off brands.");
//        p20ThighMaster.setDescription3(" Both tools aid in sculpting arms, shoulders, chest and back. It's the fast, easy, and inexpensive way to get in shape. Comes with an instructional DVD.");
//        // added
//        products.add(p20ThighMaster);

        Product pA1BarkOff = new Product();
        pA1BarkOff.setProductCat(0);
        pA1BarkOff.setProductName("Bark Off");
        pA1BarkOff.setProductPrice(9.99);
        pA1BarkOff.setProductImage("bark_off.jpg");
        pA1BarkOff.setProductDimensions(" ");
        pA1BarkOff.setDescription1("A device that emits an ultra-sonic frequency that only dogs can hear. Warning this device can be viewed as an attack on the dog if left on.");
        pA1BarkOff.setDescription2("A portable handheld device that uses an ultrasonic technology to stop your dog from barking.");
        pA1BarkOff.setDescription3("BarkOff is safe and easy to use. Just switch it on and when your pet barks, it sends out an ultrasonic signal that will instantly capture their attention and interrupt their barking pattern.");
        products.add(pA1BarkOff);

        Product pA2CleverGrip = new Product();
        pA2CleverGrip.setProductCat(0);
        pA2CleverGrip.setProductName("Clever Grip");
        pA2CleverGrip.setProductPrice(9.99);
        pA2CleverGrip.setProductImage("clever_grap.jpg");
        pA2CleverGrip.setProductDimensions(" ");
        pA2CleverGrip.setDescription1("One way to keep your phone available for it's features in your car, and keep you hands free while you access the important things. Like the GPS. Should not be used as an excuse to read or text while driving.");
        pA2CleverGrip.setDescription2("Introducing Clever Grip, the most portable smartphone car mount we’ve ever seen.Just attach Clever Grip on to any air vent and insert your smartphone. It's that simple. ");
        pA2CleverGrip.setDescription3("It's that simple. It keep your smartphone in sight at eye level and ready for GPS directions, streaming music, and hands-free calls.");
        products.add(pA2CleverGrip);

        Product pA3TiddyBear = new Product();
        pA3TiddyBear.setProductCat(0);
        pA3TiddyBear.setProductName("Tiddy Bear");
        pA3TiddyBear.setProductPrice(9.95);
        pA3TiddyBear.setProductImage("tiddybear.jpg");
        pA3TiddyBear.setDescription1("An item used to provide comfort in the care from the safety belt");
        pA3TiddyBear.setDescription2("Introducing the Tiddy Bear, the cute little guy made with the finest soft plush eliminates all these problems. Tiddy Bear is designed to make driving more comfortable.");
        pA3TiddyBear.setDescription3("Just snap the Tiddy Bear onto the shoulder strap of your seat belt and adjust up and down to remove pressure where you need it. ");
        products.add(pA3TiddyBear);

        Product pAp1Crosswave = new Product();
        pAp1Crosswave.setProductCat(1);
        pAp1Crosswave.setProductName("Crosswave");
        pAp1Crosswave.setProductPrice(299.99);
        pAp1Crosswave.setProductImage("crosswave.jpg");
        pAp1Crosswave.setDescription1("The perfect vacuum cleaner engineered specifically for pet owners. This vaccuum washed and vacuums the floors and rugs for easy and fast hair cleanup.");
        pAp1Crosswave.setDescription2("Vacuums and washes floors at the same time | Cleans both sealed hard floors and area rugsDual-action brush roll | Smart-Touch controls | 2-tank system |Integrated carrying handleEasy-remove brush window");
        pA2CleverGrip.setDescription3("Swivel steering | Multi-surface cleaning solutionEasy-clean storage tray | Solution tank holds enough solution to clean up to 700 sq ftModel# 1785W | Dimensions: 10.50 x 12.00 x 46.00 Inches");
        products.add(pAp1Crosswave);

        Product pAp2HaierAirCon = new Product();
        pAp2HaierAirCon.setProductCat(1);
        pAp2HaierAirCon.setProductName("Haier portable air conditioner");
        pAp2HaierAirCon.setProductPrice(299.99);
        pAp2HaierAirCon.setProductImage("air_condition.jpg");
        pAp2HaierAirCon.setDescription1("If you need a great way to keep yourself cool, and have no central air or not enough window space, the Haier portable air conditioner will do the job");
        pAp2HaierAirCon.setDescription2("This 8,000-BTU portable air conditioner is ideal for spot cooling small rooms up to 250 square feet. With three cool settings, three fan settings, a 24-hour on/off timer and dehumidify mode.");
        pAp2HaierAirCon.setDescription3(" A Quick-Install Window Kit is included for exhausting the unit through any horizontal or vertical opening window and fully-directional casters provide mobility. ");
        products.add(pAp2HaierAirCon);

        Product pAp3MagicBullet = new Product();
        pAp3MagicBullet.setProductCat(1);
        pAp3MagicBullet.setProductName("Magic Bullet");
        pAp3MagicBullet.setProductPrice(39.99);
        pAp3MagicBullet.setProductImage("magic_bullet.jpg");
        pAp3MagicBullet.setDescription1("The perfect machine for all your smoothie, or blending needs. Easily portable.");
        pAp3MagicBullet.setDescription2("As Seen on TV Magic Bullet, 17-Piece set:Chops, mixes, blends grinds and more1 high-torque power base2 stainless steel blades1 tall cup1 short cup2 shaker / steamer tops2 stay-fresh resealable lids4");
        pAp3MagicBullet.setDescription3("22oz oversized mugs4 colored lip rings for mugs17-piece blender with 100-page recipe book includedDoes kitchen jobs in 10 seconds or less The As Seen on TV Magic Bullet Express Blender and");
        products.add(pAp3MagicBullet);

        Product pAp4SharkSteamMop = new Product();
        pAp4SharkSteamMop.setProductCat(1);
        pAp4SharkSteamMop.setProductName("Shark Steam Mop");
        pAp4SharkSteamMop.setProductPrice(119.99);
        pAp4SharkSteamMop.setProductImage("shark_steam_mop.jpg");
        pAp4SharkSteamMop.setDescription1("Steam cleans and sanitizes your floor. Great for hard wood, and removes grease and grime.");
        pAp4SharkSteamMop.setDescription2("Shark Steam Pocket Mop... Patented 2-sided cleaning \"pocket\": clean with one side, and sanitize with the other for faster, more effective cleaning; Quick Release Mop Heads allow for easy cleaning of all spaces;");
        pAp4SharkSteamMop.setDescription3("Longer cord and larger water tank for faster, longer cleaning. Includes the following: Rectangle Pocket Head, 20ft Power Cord, 1 Rectangle pockets and Filling flask. comes with one washable microfiber cleaing pads.");
        products.add(pAp4SharkSteamMop);

        Product pAp5TheClapper = new Product();
        pAp5TheClapper.setProductCat(1);
        pAp5TheClapper.setProductName("The Clapper");
        pAp5TheClapper.setProductPrice(17.99);
        pAp5TheClapper.setProductImage("clapper.jpg");
        pAp5TheClapper.setDescription1("Great and easy way to turn off electronics without moving from where you are.");
        pAp5TheClapper.setDescription2("Control 1 or 2 things at the same time by simply clapping your hands.;Great for lamps and Christmas tree lights! CLAP ON, CLAP OFF;2 CLAPS/3 CLAPS SETTING: ");
        pAp5TheClapper.setDescription3("connect to the 2 or 3 clap outlet, then activate each one with 2 or 3 claps respectively.;Features Clap Detection Lights: Lights glow in sequence when proper claps are detected.");
        products.add(pAp5TheClapper);
        // == product type 2 start ==
        // == product type 2 start ==

        Product pC1Kaboom = new Product();
        pC1Kaboom.setProductCat(2);
        pC1Kaboom.setProductName("Kaboom Foam-Tastic Bathroom Cleaner");
        pC1Kaboom.setProductPrice(13.99);
        pC1Kaboom.setProductImage("kaboom.jpg");
        pC1Kaboom.setProductDimensions("2.6 x 2.6 x 9.5 inches ; 1.4 pounds");
        pA1BarkOff.setDescription1("A powerful cleaner that eliminates bathroom stains, buildups and soap scum, no hard scrubbing necessary.");
        pA1BarkOff.setDescription2("Tired of tough scrubbing? Try Kaboom Foam-Tastic, a foaming cleaner that changes color to let you know the surface is clean. As it sprays on blue, ");
        pA1BarkOff.setDescription3("he OxiClean stain-fighting bubbles get to work powering through soap scum, hard water, and calcium and lime stains. When it turns white you just wipe away to reveal a deep clean and a sparkling shine with absolutely no dull residue left behind.");
        products.add(pC1Kaboom);

        Product pC2OxiClean = new Product();
        pC2OxiClean.setProductCat(2);
        pC2OxiClean.setProductName("OxiClean");
        pC2OxiClean.setProductPrice(9.99);
        pC2OxiClean.setProductImage("oxiclean.jpg");
        pC2OxiClean.setProductDimensions("");
        pC2OxiClean.setDescription1("A cleaning product that uses the power of oxygen to remove tough stains. Works great with clothes, and doesn’t cause colors to bleed.");
        pC2OxiClean.setDescription2("OxiClean Versatile Stain Remover Chlorine Free.");
        pC2OxiClean.setDescription3("Concentrated! 99% Active stain fighters. 156+ loads. Now concentrated! Use less per load vs. previous formula! For all machines including HE.");
        products.add(pC2OxiClean);

        Product pC3RotoSweep = new Product();
        pC3RotoSweep.setProductCat(2);
        pC3RotoSweep.setProductName("Roto Sweep");
        pC3RotoSweep.setProductPrice(19.99);
        pC3RotoSweep.setProductImage("sweep.jpg");
        pC3RotoSweep.setProductDimensions("15.5 x 8.7 x 3.9 inches ; 1.9 pounds");
        pC3RotoSweep.setDescription1("hard floor sweeper that is a broom and dust pan all in one. Only works in one direction, but great for edging.");
        pC3RotoSweep.setDescription2("INTRODUCING THE ROTO SWEEP The Hard Floor sweeper from the Fuller Brush company! It&rsquo;s a rotating broom with a built-in dust pan that puts the power of cleaning any mess into the palm of your hand! ");
        pC3RotoSweep.setDescription3("HOW IT WORKS - Manually push sweeper forward to collect dirt and debris. No bags, filters, batteries or electricity cords required. - ");
        products.add(pC3RotoSweep);

        Product pC4SaniSticks = new Product();
        pC4SaniSticks.setProductCat(2);
        pC4SaniSticks.setProductName("Sani Sticks");
        pC4SaniSticks.setProductPrice(9.99);
        pC4SaniSticks.setProductImage("san_stick.jpg");
        pC4SaniSticks.setProductDimensions("");
        pC4SaniSticks.setDescription1("A safe and powerful drain cleaner that cleans, deodorizes and prevents clogs in any kind of plumbing.");
        pC4SaniSticks.setDescription2("SMART CLEANING: Sani Sticks cleaner, deodorizer and clog preventer are a powerful, safe and efficient way to eliminate embarrassing, foul odors from drains and helps to prevent clog backups in sinks and showers. ");
        pC4SaniSticks.setDescription3("ONE STICK IS ALL IT TAKES: Made with powerful, natural enzymes, each Sani Stick slowly releases a super concentrated blend of powerful enzymes that will eliminate organic deposits and grease build up for 30 days.");
        products.add(pC4SaniSticks);

        Product pC5ScrubDaddy = new Product();
        pC5ScrubDaddy.setProductCat(2);
        pC5ScrubDaddy .setProductName("Scrub Daddy");
        pC5ScrubDaddy.setProductPrice(24.99);
        pC5ScrubDaddy.setProductImage("scrub_daddy.jpg");
        pC5ScrubDaddy.setProductDimensions("");
        pC5ScrubDaddy.setDescription1("The sponge that keeps on giving and can handle al of your cleaning needs.");
        pC5ScrubDaddy.setDescription2("American's favorite sponge! Safe on non-stick pans, stainless steel & other delicate surfaces. Test in small area before using. Dishwasher safe. Food may get stuck in my pores. Keep fresh by running under warm water after each use. ");
        pC5ScrubDaddy.setDescription3("Scratch free. Resists odors. Soft in warm water & firm in cool water");
        products.add(pC5ScrubDaddy);

        Product pC5Shamwow = new Product();
        pC5Shamwow.setProductCat(2);
        pC5Shamwow.setProductName("Shamwow!");
        pC5Shamwow.setProductPrice(24.99);
        pC5Shamwow.setProductImage("shamwow.jpg");
        pC5Shamwow.setProductDimensions("12.6 x 10.7 x 2.9 inches ; 12 ounces");
        pC5Shamwow.setDescription1("The one time paper towel, holds up to 10 pounds its weight in liquid and machine washable.");
        pC5Shamwow.setDescription2("The world famous ORIGINAL As-Seen-On-TV Shamwow! It's like a Chamois (Shammy), Towel, and a Sponge, all in One. 8 piece set - 4 large towel cloths and 4 small towel cloths. ");
        pC5Shamwow.setDescription3("The massive ShamWow towels are 20 x 23.5 inches and the minis are 15 x 15 inches You can cut the large ones in half to use as a bath mat, drain your dishes, under your crisper to keep the veggies fresh and even make smaller ones for dish rags.");
        products.add(pC5Shamwow);

        Product pC5TrueTouch = new Product();
        pC5TrueTouch.setProductCat(2);
        pC5TrueTouch.setProductName("True touch");
        pC5TrueTouch.setProductPrice(12.99);
        pC5TrueTouch.setProductImage("true_touch.jpg");
        pC5TrueTouch.setProductDimensions("7.8 x 0.5 x 10 inches ; 2.88 ounces");
        pC5TrueTouch.setDescription1("A great way to spend time with your hairy pets, groom them, and get that excess hair off of them.");
        pC5TrueTouch.setDescription2("Pet the Hair Away! Great for all Dogs & Cats. Your pet will love the True Touch Five Finger Deshedding Glove! It mimics the loving touch of your hand for a relaxing massage and includes 180 soft silicone grooming tips to groom your pet with ease. ");
        pC5TrueTouch.setDescription3("The hair sticks to the glove, making it easy to peel and throw away. Minimize shedding and keep your house clean with the True Touch Deshedding Glove.");
        products.add(pC5TrueTouch);


        // == start of product type 3 ==
        Product pH1FlexTape = new Product();
        pH1FlexTape.setProductCat(3);
        pH1FlexTape.setProductName("Flex Tape");
        pH1FlexTape.setProductPrice(4.99);
        pH1FlexTape.setProductImage("flex_tape.jpg");
        pH1FlexTape.setProductDimensions("4.2 x 3.5 x 3.5 inches ; 2.4 ounces");
        pH1FlexTape.setDescription1("A super strong, rubberized, waterproof tape that can patch, bond, seal and repair virtually everything!");
        pH1FlexTape.setDescription2("Flex Tape Rubberized Waterproof Tape, 4\" x 5', Black");
        products.add(pH1FlexTape);

        Product pH2HerculesHooks = new Product();
        pH2HerculesHooks.setProductCat(3);
        pH2HerculesHooks.setProductName("Hercules Hooks");
        pH2HerculesHooks.setProductPrice(7.99);
        pH2HerculesHooks.setProductImage("hercules_hooks.jpg");
        pH2HerculesHooks.setProductDimensions("11.2 x 5.7 x 2 inches ; 3.2 ounces");
        pH2HerculesHooks.setDescription1("A hook that installs with no tools, and can hold up to 150 pounds.");
        pH2HerculesHooks.setDescription2("The Hercules Hook is the easiest way to hang pictures mirrors shelves just about anything. Hercules Hooks are easy to install just twist push and turn! No more drilling or pounding to try to find a stud - No more damaged walls! ");
        pH2HerculesHooks.setDescription3("The reinforced steel design provides the muscle to hang and hold up to 150 lbs. ");
        products.add(pH2HerculesHooks);


        Product pH3MightPutty = new Product();
        pH3MightPutty.setProductCat(3);
        pH3MightPutty.setProductName("Mighty Putty");
        pH3MightPutty.setProductPrice(9.95);
        pH3MightPutty.setProductImage("mighty_putty.jpg");
        pH3MightPutty.setProductDimensions("1.2 x 5.8 x 6.8 inches ; 5.8 ounces");
        pH3MightPutty.setDescription1("A strong putty that is useful for sealing holes and other such things.");
        pH3MightPutty.setDescription2("Now you can repair any job big or small, thanks to Mighty Putty. Mighty Putty is great for anything from your smallest craft projects to your largest home improvements. ");
        pH3MightPutty.setDescription3("The easy way to fix, fill and seal almost any surface, and make it last. Mighty Putty is a powerful bonding epoxy stick that you can mold to any shape .");
        products.add(pH3MightPutty);

        // this product is missing its image???
//        Product pH4Pop4tier = new Product();
//        pH4Pop4tier.setProductCat(3);
//        pH4Pop4tier.setProductName("Pop-it 4 tier Collapsible Storage Shelf");
//        pH4Pop4tier.setProductPrice(89.99);
//        pH4Pop4tier.setProductImage("pop-it_4_tier_collapsible_shelf_with wheels");
//        pH4Pop4tier.setProductDimensions("35-7/8\"L x 20\"W x 59-3/4\"H ; 28 lbs");
//        pH4Pop4tier.setDescription1("A foldable four tier shelf that rolls and can hold a total of 700 lbs. (175 lbs. per shelf)");
//        pH4Pop4tier.setDescription2("From your garage to utility room, or wherever you need a more organized storage solution, pop open this four-tiered shelving unit,");
//        pH4Pop4tier.setDescription3("and then fold it up when it's not in use. Add the wheels to easily move it around, and add the shelf liners for storing smaller items. From Pop-It.");
//        products.add(pH4Pop4tier);

        Product pH5PressureJoe = new Product();
        pH5PressureJoe.setProductCat(3);
        pH5PressureJoe.setProductName("Pressure Joe");
        pH5PressureJoe.setProductPrice(84.99);
        pH5PressureJoe.setProductImage("pressure_washer.jpg");
        pH5PressureJoe.setProductDimensions("12 x 9.8 x 19 inches ; 11.7 pounds");
        pH5PressureJoe.setDescription1("A cleaner for light to medium jobs, using the power of water.");
        pH5PressureJoe.setDescription2("The ultimate dirt fighter, the Pressure Joe SPX1000 is ideal for tackling a variety of light-to-medium duty cleaning jobs. Use it to clean boats, motorcycles, ");
        pH5PressureJoe.setDescription3("RV's, ATV's, trailers, decks, barbecues, siding and more. Packed with a powerful 1400-watt motor, Pressure Joe delivers up to 1450 PSI of cleaning power and a maximum");
        products.add(pH5PressureJoe);

        Product pH6RodentSheriff = new Product();
        pH6RodentSheriff.setProductCat(3);
        pH6RodentSheriff.setProductName("Rodent Sheriff");
        pH6RodentSheriff.setProductPrice(7.95);
        pH6RodentSheriff.setProductImage("rodent_sherrif.jpg");
        pH6RodentSheriff.setProductDimensions("10 x 4.2 x 3.5 inches ; 1.5 pounds");
        pH6RodentSheriff.setDescription1("Uses natural peppermin oil to get rid of mice, rats and other pests");
        pH6RodentSheriff.setDescription2("A powerful spray made in the USA from a handcrafted peppermint formula. You’ll love its long-lasting minty fresh scent, but mice, roaches, raccoons and other rodents hate it. So the minute they get a whiff, they head for the hills.");
        pH6RodentSheriff.setDescription3("And since it’s a natural formula, you can even spray it around your garden, around trash cans, vehicles, garages, storage areas, attics, entry points around your house... ");
        products.add(pH6RodentSheriff);

        Product pH7ZappLight = new Product();
        pH7ZappLight.setProductCat(3);
        pH7ZappLight.setProductName("Zapp Light");
        pH7ZappLight.setProductPrice(12.99);
        pH7ZappLight.setProductImage("zapp_light.jpg");
        pH7ZappLight.setProductDimensions("8.3 x 5.9 x 3.2 inches ; 5.35 pounds");
        pH7ZappLight.setDescription1("A light bulb and a bug zapper all wrapped in one. Help keep your mosquito problems down.");
        pH7ZappLight.setDescription2("Lighting adds elegance style sophistication and beautify your home or office spaces Lighting is the most integral part of any interior space The right lighting makes even the modest of space look bigger and classy Features.");
        products.add(pH7ZappLight);


        Product p10GLHHairSystem = new Product();
        p10GLHHairSystem.setProductCat(4);
        p10GLHHairSystem.setProductName("GLH Hair System");
        p10GLHHairSystem.setProductPrice(39.99);
        p10GLHHairSystem.setProductImage("GLH.jpg");
        p10GLHHairSystem.setProductDimensions(" ");
        p10GLHHairSystem.setDescription1("A powder that attaches to the smallest of hair follicles and builds on itself to act like hair.");
        p10GLHHairSystem.setDescription2("Glh is the very latest breakthrough and contains almost life-like fibers that instantly give added body to your hair. Glh will take away that wispy look. Fill in those thin see-through spots and for men it can even cover bald spots.");
        // added
        products.add(p10GLHHairSystem);

        Product p11ShakeWeight = new Product();
        p11ShakeWeight.setProductCat(4);
        p11ShakeWeight.setProductName("Shake Weight");
        p11ShakeWeight.setProductPrice(19.99);
        p11ShakeWeight.setProductImage("shake_weight.jpg");
        p11ShakeWeight.setProductDimensions(" ");
        p11ShakeWeight.setDescription1("A training tool for the arms.");
        p11ShakeWeight.setDescription2("Get incredible results in just 6 minutes a day using the revolutionary new way to shape and tone your arms, shoulders and chest It's fun and easy to use. ");
        // added
        products.add(p11ShakeWeight);

        Product p13Bowflex = new Product();
        p13Bowflex.setProductCat(4);
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
        p14HawaiiChair.setProductCat(4);
        p14HawaiiChair.setProductImage("hula_chair.jpg");
        p14HawaiiChair.setProductPrice(49.99);
        p14HawaiiChair.setProductName("Hawaii Chair");
        p14HawaiiChair.setDescription1("A kind of swiveling chair that consistently moves in a circle and provides an abdominal work out.");
        p14HawaiiChair.setDescription2("This is a brand new Hawaii Chair (Hula Chair) and is built with steel feet, ABS armrest and leather backrest. Great gift for ladies!");
        p14HawaiiChair.setDescription3("9 Speeds with 60 Watt Power and Handle up to 300 Lbs. Exercises the whole body especially the waist. Strengthening intestines and stomach functions while stimulating blood flow");
        // added
        products.add(p14HawaiiChair);

        Product p15InStylerMax = new Product();
        p15InStylerMax.setProductCat(4);
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
        p16Kush.setProductCat(4);
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
        p17Proactiv.setProductCat(4);
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
        p18Rej.setProductCat(4);
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
        p19Sweatin.setProductCat(4);
        p19Sweatin.setProductName("Sweatin’ to the oldies");
        p19Sweatin.setProductPrice(9.99);
        p19Sweatin.setProductImage("sweatin_to_the_oldies.jpg");
        p19Sweatin.setDescription1("A classic work out video featuring Richard Simmons, and some classy music. Lose yourself and some pounds by tuning into this vigorous work out.");
        p19Sweatin.setDescription2("Turn back time with America's Favorite Fitness Expert, Richard Simmons! Celebrating 25 years since the original Sweatin' to the Oldies, fall in love with fun fitness all over again");
        p19Sweatin.setDescription3("with this low impact routine guaranteed to get you off the couch and getting into shape.");
        // added
        products.add(p19Sweatin);

        Product p20ThighMaster = new Product();
        p20ThighMaster.setProductCat(4);
        p20ThighMaster.setProductName("ThighMaster");
        p20ThighMaster.setProductPrice(12.99);
        p20ThighMaster.setProductImage("thigh_master.jpg");
        p20ThighMaster.setDescription1("A product that can be used to tone legs and arms for multiple work outs.");
        p20ThighMaster.setDescription2("It's the ThighMaster Gold and the ButtMaster (LBX) together for the ultimate lower body workout. This is the only original ThighMaster straight from Suzanne. Don't accept any knock-off brands.");
        p20ThighMaster.setDescription3(" Both tools aid in sculpting arms, shoulders, chest and back. It's the fast, easy, and inexpensive way to get in shape. Comes with an instructional DVD.");
        // added
        products.add(p20ThighMaster);





        Product p1GeorgeFormanGrill = new Product();
        p1GeorgeFormanGrill.setProductCat(5);
        p1GeorgeFormanGrill.setProductName("George Forman Grill");
        p1GeorgeFormanGrill.setProductPrice(99.99);
        p1GeorgeFormanGrill.setProductImage("george_foreman.jpg");
        p1GeorgeFormanGrill.setProductDimensions(" ");
        p1GeorgeFormanGrill.setDescription1("The amazing grill that cooks your food evenly, while reducing the fat in any meats you cook. This item can be used in a variety of different dishes from Panini's to steaks.");
        p1GeorgeFormanGrill.setDescription2("The George Foreman GR144 Silver Grand Champ Family Size Indoor Grill is great for any family large or small.The 144 Sq");
        p1GeorgeFormanGrill.setDescription3("Get all the space you need to cook leaner for up to 9 people with our largest indoor contact grill. In. grilling surface easily fits up to 9 servings, with even heat from the center to the sides of the plate.");
        p1GeorgeFormanGrill.setDescription4("Our patented sloped design and George Tough nonstick coating allow you to cook without oil or butter while fat and grease drain off for leaner meals in minutes. The grill includes a dishwasher safe drip tray for added convenience.");
        // added
        products.add(p1GeorgeFormanGrill);

        Product p2GinsuKnives = new Product();
        p2GinsuKnives.setProductCat(5);
        p2GinsuKnives.setProductName("Ginsu Knives");
        p2GinsuKnives.setProductPrice(79.99);
        p2GinsuKnives.setProductImage("ginsu_knives.jpg");
        p2GinsuKnives.setProductDimensions(" ");
        p2GinsuKnives.setDescription1("The perfect knives to get if you need to cut through a can and then slice a tomato right after.");
        // added
        products.add(p2GinsuKnives);

        Product p3SlapChop = new Product();
        p3SlapChop.setProductCat(5);
        p3SlapChop.setProductName("Slap Chop");
        p3SlapChop.setProductPrice(24.99);
        p3SlapChop.setProductImage("slap_chop.jpg");
        p3SlapChop.setProductDimensions(" ");
        p3SlapChop.setDescription1("A great product to use for chopping and mincing vegetables.");
        p3SlapChop.setDescription2("STAINLESS STEEL & LARGE CUP CONTAINER: Slap Chop blades are made of the highest quality stainless steel while the convenient large cup container captures all foods that are chopped. High quality blades quickly deskin the garlic and onions in seconds.");
        // added
        products.add(p3SlapChop);

        Product p4ChiaPet = new Product();
        p4ChiaPet.setProductCat(5);
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
        p5Energize10SolarLandscape.setProductCat(5);
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
        p6ShoeDini.setProductCat(5);
        p6ShoeDini.setProductName("ShowDini");
        p6ShoeDini.setProductPrice(9.99);
        p6ShoeDini.setProductImage("shoedini.jpg");
        p6ShoeDini.setProductDimensions(" ");
        p6ShoeDini.setDescription1("The simple tool used to get your shoes on and off whithout the need to bend down. Perfect for those whith back issues.");
        p6ShoeDini.setDescription2("Shoedini Shoe Horn extends to almost 3 feet to give you the extra reach you need!");
        // added
        products.add(p6ShoeDini);

        Product p7Snuggie = new Product();
        p7Snuggie.setProductCat(5);
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
        p8TubShroom.setProductCat(5);
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
        p9WearableTowel.setProductCat(5);
        p9WearableTowel.setProductName("Wearable Towel");
        p9WearableTowel.setProductPrice(19.99);
        p9WearableTowel.setProductImage("wearable_towel.jpg");
        p9WearableTowel.setProductDimensions(" ");
        p9WearableTowel.setDescription1("A towel that you can wear, alleviates the issue of holding up towel after shower.");
        p9WearableTowel.setDescription2("The Wearable Towel has three arm openings placed along the side and does not employ the use of any fasteners. It is for unisex and can be worn in either a tunic style or a toga style.");
        // added
        products.add(p9WearableTowel);



        // == product category ==

        Product pT1Bendaroos = new Product();
        pT1Bendaroos.setProductCat(6);
        pT1Bendaroos.setProductName("Bendaroos");
        pT1Bendaroos.setProductPrice(19.99);
        pT1Bendaroos.setProductDimensions("10.6 x 8.8 x 2 inches");
        pT1Bendaroos.setProductImage("bendaroos.jpg");
        pT1Bendaroos.setDescription1("A great toy for kids that is hard to break and can be used to make art, or amazing designs for massive fun.");
        pT1Bendaroos.setDescription2("500 piece bendy toy");
        products.add(pT1Bendaroos);

        Product pT2Floam = new Product();
        pT2Floam.setProductCat(6);
        pT2Floam.setProductName("floam.jpg");
        pT2Floam.setProductPrice(9.99);
        pT2Floam.setProductDimensions("9.6 x 5.2 x 4.9 inches");
        pT2Floam.setDescription1("A squishy and less messy version of slime and floopy stuff. It makes noise when squished just right, feels fun, and is malleable. (Keep in sealed place to prevent product from drying out too fast.)");
        pT2Floam.setDescription2("Squishy foamy goop.");

        Product pT3Fushigi = new Product();
        pT3Fushigi.setProductCat(6);
        pT3Fushigi.setProductName("fushigi");
        pT3Fushigi.setProductPrice(14.99);
        pT3Fushigi.setProductDimensions("7 x 7 x 5 ; 15.2 ounces");
        pT3Fushigi.setDescription1("The gravity ball is an illusory object that will leave you mistified in how the ball moves but doesn't seem too, a cool but simple item that can be used to pass those bored hours that pas you by.");
        pT3Fushigi.setDescription2("Brand New Fushigi Magic Gravity Ball No Strings No Tricks Simple Hand Manipulation will make Fushigi appear to Float and Defy Gravity Free DVD to Help");
        pT3Fushigi.setDescription3("Learn Dozens of Illusions Great Gift for Teens- Adults-Mom-Dad Great Easter Basket Filler-Birthdays Novelty Gift and More");

        Product pT4Magicsand = new Product();
        pT4Magicsand.setProductCat(6);
        pT4Magicsand.setProductName("Magic sand");
        pT4Magicsand.setProductPrice(9.99);
        pT4Magicsand.setProductDimensions(" ");
        pT4Magicsand.setProductImage("magic_sand.jpg");
        pT4Magicsand.setDescription1("Designer sand perfect for building aquatic structures and things. Stays dry when put in water.");
        pT4Magicsand.setDescription2("Sand that stays dry when wet");

        Product pT5MoonSand = new Product();
        pT5MoonSand.setProductCat(6);
        pT5MoonSand.setProductName("Moon Sand");
        pT5MoonSand.setProductPrice(19.99);
        pT5MoonSand.setProductImage("moon_sand.jpg");
        pT5MoonSand.setDescription1("Designer sand perfect for building aquatic structures and things. Stays dry when put in water.");
        pT5MoonSand.setDescription2("Sand that stays dry when wet");

        Product pT6PillowPets = new Product();
        pT6PillowPets.setProductCat(6);
        pT6PillowPets.setProductName("Pillow Pets");
        pT6PillowPets.setProductPrice(27.99);
        pT6PillowPets.setProductImage("pillow_pets.jpg");
        pT6PillowPets.setDescription1("Ever wanted to cuddle up next to your favorite animal? Well now you can with these plush animals you will never want to sleep without. Except when you do want too.");
        pT6PillowPets.setDescription2("Brand New 100% Authentic Pillow Pets Premium Large 18\" AS SEEN ON TV and comes with all original Tags. In stock and ready to ship within 24 hours.");
        pT6PillowPets.setProductDimensions("17.8 x 12.5 x 7.8 inches ; 1.24 pounds");

        Product pT7PottyPutter = new Product();
        pT7PottyPutter.setProductCat(6);
        pT7PottyPutter.setProductName("Potty Putter");
        pT7PottyPutter.setProductPrice(10.99);
        pT7PottyPutter.setProductImage("putter.jpg");
        pT7PottyPutter.setDescription1("A toy golf set to be set up in the bathroom.");
        pT7PottyPutter.setDescription2("Arrives Before Christmas! The toilet time golf game that lets you practice your putting while going to the bathroom Sure it sounds funny, but for the golfer that just can't get enough of the game,");
        pT7PottyPutter.setDescription3("it's the perfect item Makes the perfect gift for any golf fan of any age!");
        pT7PottyPutter.setProductDimensions("7.2 pounds");

        Product pT8ZhuZhuPets = new Product();
        pT8ZhuZhuPets.setProductCat(6);
        pT8ZhuZhuPets.setProductName("Zhu Zhu Pets");
        pT8ZhuZhuPets.setProductPrice(59.99);
        pT8ZhuZhuPets.setProductImage("zhu_zhu.jpg");
        pT8ZhuZhuPets.setDescription1("Plucky and plushy, these robotics hamster move on their own and are interactive. have fun with your adventurous or nurturing hamster today, your choice in setting.");
        pT8ZhuZhuPets.setDescription2("Chatter, scatter, scoot n' scurry like a real hamster.");




        //
        //
        // cat break
        //
        //


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

    private List<Customer> getCustomers()
    {
        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer();

        Account account = new Account();
        account.setUsername("biff");
        account.setPassword("marko12");
        account.setEncryptedPassword("fdfdsfsd");
        account.setUserRole("customer");
        account.setActive(true);

        customer1.setAccount(account);


        customer1.setpFirstName("biff");
        customer1.setpLastName("marko");
        customer1.setpEmail("dranko@hotmail.com");
        customer1.setpDoB("08-12-2019");


        Address address = new Address();
        address.setaAddress("117 betten ray");
        address.setaAddress2("blank");
        address.setaZip("12131");
        address.setaCountry("United States");
        address.setaAdditionalInfo("blank");
        address.setaHomePhone("212-121-1221");
        address.setaMobilePhone("121-111-2131");


        customer1.setCustomerAddress(address);
        customers.add(customer1);

        return customers;
    }

    private List<Account> getAccounts(){
        List<Account> accounts = new ArrayList<Account>();
        Account jimsAccount = new Account();


        jimsAccount.setActive(true);
        jimsAccount.setUsername("Biffman1000");
        jimsAccount.setUsername("macNCheese");
        jimsAccount.setUserRole("Customer");

        accounts.add(jimsAccount);

        Account bethsAccount = new Account();
        bethsAccount.setActive(true);
        bethsAccount.setUsername("Chelseaseasea");
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
