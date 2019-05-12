package capstone.bcs.lifo.util;

import capstone.bcs.lifo.model.CartProductV2;
import capstone.bcs.lifo.model.CartV2;
import capstone.bcs.lifo.model.Product;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


public class ValidSessionDataUtil {

    HttpSession localSession = null;
    CartV2 cartV2 = null;
    double cartTotal = 0;
    CartUtil cartUtil = new CartUtil();

    // == Autowired for intention == //
    public ValidSessionDataUtil(HttpSession localSession) {
        this.localSession = localSession;

        try {
            this.cartV2 = (CartV2) localSession.getAttribute("cart");
        } catch (Exception e){

        }
    }

    public List<CartProductV2> validCartProductList(){
        if(localSession.getAttribute("cart") != null){
            return cartV2.getProductList();
        }
        else
        {
            return null;
        }
    }


    public boolean validSession(){
        if(localSession.getAttribute("cart") !=null){
            return true;
        } else {
            return false;
        }
    }

    public int getProductListSize(){
        if(localSession.getAttribute("cart") != null)
        {
            int temp;
            temp = cartV2.getProductList().size();
            return temp;
        } else {
            return 0;
        }
    }

    public String getUsersName(){
        String temp ="";
        if(localSession.getAttribute("cart") !=null) {
            CartV2 cartV2 = (CartV2) localSession.getAttribute("cart");

            if(cartV2.getCustomerV2() == null)
            {
                return temp;
            }
            if(cartV2.getCustomerV2().getpFirstName() == null) {
                return temp;
            }
            else { temp = cartV2.getCustomerV2().getpFirstName();
                //temp += " " + cartV2.getCustomerV2().getpLastName();
                temp +="'";
                return temp; }
        }else {
            temp = "No User";
            return temp;
        }
    }

    public String getAddress1(){
        String temp = "";
        if(localSession.getAttribute("cart") !=null) {
            CartV2 cartV2 = (CartV2) localSession.getAttribute("cart");

            if(cartV2.getCustomerV2() == null)
            {
                return temp;
            }

            if(cartV2.getCustomerV2().getCustomerAddress().getaAddress() == null) {
                return temp;
            }
            else {
                temp = cartV2.getCustomerV2().getCustomerAddress().getaAddress();
                return temp;
            }
        }else {
            return temp;
        }
    }

    public String getAddress2(){
        String temp = "";
        if(localSession.getAttribute("cart") !=null) {
            CartV2 cartV2 = (CartV2) localSession.getAttribute("cart");

            if(cartV2.getCustomerV2() == null)
            {
                return temp;
            }


            if(cartV2.getCustomerV2().getCustomerAddress().getaAddress2() == null) {
                return temp;
            }
            else {
                temp = cartV2.getCustomerV2().getCustomerAddress().getaAddress2();
                return temp;
            }

        }else {
            return temp;
        }
    }

    public String getCity(){
        String temp ="";
        if(localSession.getAttribute("cart") !=null) {
            CartV2 cartV2 = (CartV2) localSession.getAttribute("cart");


            if(cartV2.getCustomerV2() == null)
            {
                return temp;
            }

            if(cartV2.getCustomerV2().getCustomerAddress().getaCity() == null)
            {
                return temp;
            }
            else
            {
                temp = cartV2.getCustomerV2().getCustomerAddress().getaCity();
                return temp;
            }
        }else {
            return temp;
        }
    }

    public String getState(){
        String temp = "";
        if(localSession.getAttribute("cart") !=null) {
            CartV2 cartV2 = (CartV2) localSession.getAttribute("cart");

            if(cartV2.getCustomerV2() == null)
            {
                return temp;
            }


            if(cartV2.getCustomerV2().getCustomerAddress().getaState() == null) {
                return temp;
            }
            else {
                temp = cartV2.getCustomerV2().getCustomerAddress().getaState();
                return temp;
            }
        }else {
            return temp;
        }
    }

    public String getZip(){
        String temp="";
        if(localSession.getAttribute("cart") !=null) {
            CartV2 cartV2 = (CartV2) localSession.getAttribute("cart");

            if(cartV2.getCustomerV2() == null)
            {
                return temp;
            }

            if(cartV2.getCustomerV2().getCustomerAddress().getaZip() == null) {
                return temp;
            }
            else {
                temp = cartV2.getCustomerV2().getCustomerAddress().getaZip();
                return temp;
            }
        }else {
            return temp;
        }
    }

//    public List<Product> testProductList(){
//        List<Product> products= new ArrayList<>();
//
//        Product pA1BarkOff = new Product();
//        pA1BarkOff.setProductCat(0);
//        pA1BarkOff.setProductName("Bark Off");
//        pA1BarkOff.setProductPrice(9.99);
//        pA1BarkOff.setProductImage("bark_off.jpg");
//        pA1BarkOff.setProductDimensions(" ");
//        pA1BarkOff.setDescription1("A device that emits an ultra-sonic frequency that only dogs can hear. Warning this device can be viewed as an attack on the dog if left on.");
//        pA1BarkOff.setDescription2("A portable handheld device that uses an ultrasonic technology to stop your dog from barking.");
//        pA1BarkOff.setDescription3("BarkOff is safe and easy to use. Just switch it on and when your pet barks, it sends out an ultrasonic signal that will instantly capture their attention and interrupt their barking pattern.");
//        products.add(pA1BarkOff);
//
//
//        Product pAp1Crosswave = new Product();
//        pAp1Crosswave.setProductCat(1);
//        pAp1Crosswave.setProductName("Crosswave");
//        pAp1Crosswave.setProductPrice(299.99);
//        pAp1Crosswave.setProductImage("crosswave.jpg");
//        pAp1Crosswave.setDescription1("The perfect vacuum cleaner engineered specifically for pet owners. This vaccuum washed and vacuums the floors and rugs for easy and fast hair cleanup.");
//        pAp1Crosswave.setDescription2("Vacuums and washes floors at the same time | Cleans both sealed hard floors and area rugsDual-action brush roll | Smart-Touch controls | 2-tank system |Integrated carrying handleEasy-remove brush window");
//        pAp1Crosswave.setDescription3("Swivel steering | Multi-surface cleaning solutionEasy-clean storage tray | Solution tank holds enough solution to clean up to 700 sq ftModel# 1785W | Dimensions: 10.50 x 12.00 x 46.00 Inches");
//        products.add(pAp1Crosswave);
//
//        Product pAp2HaierAirCon = new Product();
//        pAp2HaierAirCon.setProductCat(1);
//        pAp2HaierAirCon.setProductName("Haier portable air conditioner");
//        pAp2HaierAirCon.setProductPrice(299.99);
//        pAp2HaierAirCon.setProductImage("air_condition.jpg");
//        pAp2HaierAirCon.setDescription1("If you need a great way to keep yourself cool, and have no central air or not enough window space, the Haier portable air conditioner will do the job");
//        pAp2HaierAirCon.setDescription2("This 8,000-BTU portable air conditioner is ideal for spot cooling small rooms up to 250 square feet. With three cool settings, three fan settings, a 24-hour on/off timer and dehumidify mode.");
//        pAp2HaierAirCon.setDescription3(" A Quick-Install Window Kit is included for exhausting the unit through any horizontal or vertical opening window and fully-directional casters provide mobility. ");
//        products.add(pAp2HaierAirCon);
//
//        Product pAp3MagicBullet = new Product();
//        pAp3MagicBullet.setProductCat(1);
//        pAp3MagicBullet.setProductName("Magic Bullet");
//        pAp3MagicBullet.setProductPrice(39.99);
//        pAp3MagicBullet.setProductImage("magic_bullet.jpg");
//        pAp3MagicBullet.setDescription1("The perfect machine for all your smoothie, or blending needs. Easily portable.");
//        pAp3MagicBullet.setDescription2("As Seen on TV Magic Bullet, 17-Piece set:Chops, mixes, blends grinds and more1 high-torque power base2 stainless steel blades1 tall cup1 short cup2 shaker / steamer tops2 stay-fresh resealable lids4");
//        pAp3MagicBullet.setDescription3("22oz oversized mugs4 colored lip rings for mugs17-piece blender with 100-page recipe book includedDoes kitchen jobs in 10 seconds or less The As Seen on TV Magic Bullet Express Blender and");
//        products.add(pAp3MagicBullet);
//
//        Product pT2Floam = new Product();
//        pT2Floam.setProductCat(6);
//        pT2Floam.setProductName("floam.jpg");
//        pT2Floam.setProductPrice(9.99);
//        pT2Floam.setProductDimensions("9.6 x 5.2 x 4.9 inches");
//        pT2Floam.setDescription1("A squishy and less messy version of slime and floopy stuff. It makes noise when squished just right, feels fun, and is malleable. (Keep in sealed place to prevent product from drying out too fast.)");
//        pT2Floam.setDescription2("Squishy foamy goop.");
//        products.add(pT2Floam);
//
//        Product pT3Fushigi = new Product();
//        pT3Fushigi.setProductCat(6);
//        pT3Fushigi.setProductName("fushigi");
//        pT3Fushigi.setProductPrice(14.99);
//        pT3Fushigi.setProductDimensions("7 x 7 x 5 ; 15.2 ounces");
//        pT3Fushigi.setDescription1("The gravity ball is an illusory object that will leave you mistified in how the ball moves but doesn't seem too, a cool but simple item that can be used to pass those bored hours that pas you by.");
//        pT3Fushigi.setDescription2("Brand New Fushigi Magic Gravity Ball No Strings No Tricks Simple Hand Manipulation will make Fushigi appear to Float and Defy Gravity Free DVD to Help");
//        pT3Fushigi.setDescription3("Learn Dozens of Illusions Great Gift for Teens- Adults-Mom-Dad Great Easter Basket Filler-Birthdays Novelty Gift and More");
//        products.add(pT3Fushigi);
//
//        Product pT4Magicsand = new Product();
//        pT4Magicsand.setProductCat(6);
//        pT4Magicsand.setProductName("Magic sand");
//        pT4Magicsand.setProductPrice(9.99);
//        pT4Magicsand.setProductDimensions(" ");
//        pT4Magicsand.setProductImage("magic_sand.jpg");
//        pT4Magicsand.setDescription1("Designer sand perfect for building aquatic structures and things. Stays dry when put in water.");
//        pT4Magicsand.setDescription2("Sand that stays dry when wet");
//        products.add(pT4Magicsand);
//
//        Product pT5MoonSand = new Product();
//        pT5MoonSand.setProductCat(6);
//        pT5MoonSand.setProductName("Moon Sand");
//        pT5MoonSand.setProductPrice(19.99);
//        pT5MoonSand.setProductImage("moon_sand.jpg");
//        pT5MoonSand.setDescription1("Designer sand perfect for building aquatic structures and things. Stays dry when put in water.");
//        pT5MoonSand.setDescription2("Sand that stays dry when wet");
//        products.add(pT5MoonSand);
//
//        Product pT6PillowPets = new Product();
//        pT6PillowPets.setProductCat(6);
//        pT6PillowPets.setProductName("Pillow Pets");
//        pT6PillowPets.setProductPrice(27.99);
//        pT6PillowPets.setProductImage("pillow_pets.jpg");
//        pT6PillowPets.setDescription1("Ever wanted to cuddle up next to your favorite animal? Well now you can with these plush animals you will never want to sleep without. Except when you do want too.");
//        pT6PillowPets.setDescription2("Brand New 100% Authentic Pillow Pets Premium Large 18\" AS SEEN ON TV and comes with all original Tags. In stock and ready to ship within 24 hours.");
//        pT6PillowPets.setProductDimensions("17.8 x 12.5 x 7.8 inches ; 1.24 pounds");
//        products.add(pT6PillowPets);
//
//        Product pT7PottyPutter = new Product();
//        pT7PottyPutter.setProductCat(6);
//        pT7PottyPutter.setProductName("Potty Putter");
//        pT7PottyPutter.setProductPrice(10.99);
//        pT7PottyPutter.setProductImage("putter.jpg");
//        pT7PottyPutter.setDescription1("A toy golf set to be set up in the bathroom.");
//        pT7PottyPutter.setDescription2("Arrives Before Christmas! The toilet time golf game that lets you practice your putting while going to the bathroom Sure it sounds funny, but for the golfer that just can't get enough of the game,");
//        pT7PottyPutter.setDescription3("it's the perfect item Makes the perfect gift for any golf fan of any age!");
//        pT7PottyPutter.setProductDimensions("7.2 pounds");
//        products.add(pT7PottyPutter);
//
//        Product pT8ZhuZhuPets = new Product();
//        pT8ZhuZhuPets.setProductCat(6);
//        pT8ZhuZhuPets.setProductName("Zhu Zhu Pets");
//        pT8ZhuZhuPets.setProductPrice(59.99);
//        pT8ZhuZhuPets.setProductImage("zhu_zhu.jpg");
//        pT8ZhuZhuPets.setDescription1("Plucky and plushy, these robotics hamster move on their own and are interactive. have fun with your adventurous or nurturing hamster today, your choice in setting.");
//        pT8ZhuZhuPets.setDescription2("Chatter, scatter, scoot n' scurry like a real hamster.");
//        products.add(pT8ZhuZhuPets);
//
//        return products;
//    }

    public double getCartTotal(){

        if(localSession.getAttribute("cart") != null)
        {
            cartTotal = cartUtil.cartTotal(cartV2.getProductList());
            return Math.floor(cartTotal * 100)/100;
        }
        else
        {
            return 0.0f;
        }
    }



}
