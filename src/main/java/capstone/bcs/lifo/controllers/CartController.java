package capstone.bcs.lifo.controllers;

import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.model.CartProductV2;
import capstone.bcs.lifo.model.CartV2;
import capstone.bcs.lifo.model.Product;
import capstone.bcs.lifo.model.nonentity.ProductDetails;
import capstone.bcs.lifo.repositories.CartProductV2Repository;
import capstone.bcs.lifo.repositories.CartV2Repository;
import capstone.bcs.lifo.repositories.CustomerV2Repository;
import capstone.bcs.lifo.repositories.ProductRepository;
import capstone.bcs.lifo.services.CartService;
import capstone.bcs.lifo.services.ProductService;
import capstone.bcs.lifo.util.SessionTransitionUtil;
import capstone.bcs.lifo.util.ValidSessionDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;


@Controller
public class CartController {

    /**
     * this adds data to the various parts of the cart session
     * code 1 is delete code 2 is add code 3 is remove all
     * code 10 is neutral mapping this is a work in progress
     * and needs the most attention
     */

    private ProductService productService;
    private ProductRepository productRepository;
    private CartService cartService;
    private CustomerV2Repository customerV2Repository;
    private CartProductV2Repository cartProductV2Repository;

    // should just be the service fix this
    private CartV2Repository cartV2Repository;

    // == autowired for intention only ==
    @Autowired
    CartController(ProductService productService, CartService cartService, CartV2Repository cartV2Repository,
                   CustomerV2Repository customerV2Repository, CartProductV2Repository cartProductV2Repository,
                   ProductRepository productRepository){
        this.productService = productService;
        this.cartService = cartService;
        this.cartV2Repository = cartV2Repository;
        this.cartProductV2Repository = cartProductV2Repository;
        this.productRepository = productRepository;
    }

    @RequestMapping({"/cart"})
    public String getPageLogin(Model model, HttpSession session){
        System.out.println("cart button worked!");
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());

        SessionTransitionUtil sU = new SessionTransitionUtil();
        session = sU.AnonSession(session);

        if(session.getAttribute("cart") != null)
        {
            //CartOld cart = null;
            CartV2 cartV2 = null;

            cartV2 = (CartV2) session.getAttribute("cart");
            System.out.println("got the cart!!!!");
        }else{
            System.out.println("you need to login first buddy!");

            return "login";
        }
        return "product_summary";
    }

    // == this needs to be remove at some point
    @RequestMapping({"/cart/product_summary"})
    public String hotFix(Model model, HttpSession session) {
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "product_summary";
    }

    // == to fix this correctly need to put in controller request mapping order
    // == link can be found at https://stackoverflow.com/questions/17374549/spring-set-handlermapping-priority
    // == this needs to be removed at some point
    @RequestMapping({"/products/product_summary"})
    public String hotFix2(Model model, HttpSession session) {
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "product_summary";
    }

    @RequestMapping({"/cart/{ida}/{idb}/{idc}"})
    public String getPageVarVarVar(HttpServletRequest request,HttpSession session,@PathVariable("ida") String ida,
                                   @PathVariable("idb") String idb,@PathVariable("idc") String idc, Model model, RedirectAttributes redirectAttributes) throws Exception {
        String referer = request.getHeader("Referer");

        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);

        CartV2 cartV2 = null;
        Integer a = null;
        Integer b = null;

        // moved the two parse variables i think this is okay

        try{
            a = Integer.valueOf(ida);
        } catch (NumberFormatException e)
        {
            throw  new Exception("Invalid input from cart hyperlink for the first parameter {ida}");
        }

        try{
            b = Integer.valueOf(idb);
        } catch (NumberFormatException e)
        {
            throw new Exception("Invalid input from cart hyperlink for the second parameter {idb}");
        }

        // improved customer cart area
        if(a == 10) // threw issue Property or field 'productImage' Cannott be found on object of type 'capstone.bcs.lifo.model.CartProductv2"
        {
            // products does not fail with blank data
            // does it fail with a null pointer // this does not seem to fail with a null pointer or empty list
            // this all renders it just needs null checks before being displayed
            // bottom rendered properly with data
            System.out.println("username " + validSDU.getUsersName());
            System.out.println("products " + validSDU.validCartProductList());
            System.out.println("discount" + validSDU.validCartProductList());
            System.out.println("tax" + validSDU.validCartProductList());
            System.out.println("product_details" + validSDU.validCartProductList());

            model.addAttribute("cartsize",validSDU.getProductListSize());
            //model.addAttribute("cartsize",0);
            model.addAttribute("carttoal",validSDU.getCartTotal());
            if(validSDU.getUsersName() == null || validSDU.getUsersName().equals(""))
            {
                model.addAttribute("username","cart");
            } else {
                model.addAttribute("username",validSDU.getUsersName() + "'s cart");
            }
            // this method has to be real products
            model.addAttribute("products",validSDU.validCartProductList());
            model.addAttribute("discount",appDiscountToCart(validSDU.validCartProductList(),0.1));
            model.addAttribute("tax",appDiscountToCart(validSDU.validCartProductList(),0.2)); // those function calls throw npes
            model.addAttribute("final_price",appDiscountNTax(validSDU.validCartProductList(),0.1,0.2)); // those function calls throw npes
            model.addAttribute("product_details",validSDU.validCartProductList()); // those function calls throw npes
            return "custom_cart";

        }

        if(session.getAttribute("cart") != null)
        {
            cartV2 = (CartV2) session.getAttribute("cart");
        }else{



            System.out.println("you need to login first buddy from cart/{ida}/{idb}/{idc}!");
            //return "product_summary";
            model.addAttribute("cartsize",validSDU.getProductListSize());
            model.addAttribute("carttotal",validSDU.getCartTotal());
            model.addAttribute("LoginForm", new LoginForm());
            return "login";
        }


        System.out.println("this is the first cart parameter " + a);
        System.out.println("this is the second car parameter " + b);

        // remove updated
        if(a == 1) // remove just one copy
        {


            System.out.println("remove a single product block ");

            // this only has one product? it didn't update per each session
            CartV2 localCart = (CartV2)session.getAttribute("cart");


            List<CartProductV2> productList = null; // just changed
            productList = localCart.getProductList();


            CartProductV2 cartProductV2 = new CartProductV2(); // just changed
            Product productInfoLocal = productService.findById(b.longValue());

            cartProductV2.setProductId(productInfoLocal.getId().intValue());
            cartProductV2.setProductId(productInfoLocal.getId().intValue()); // sets value
            cartProductV2.setProductPrice(productInfoLocal.getProductPrice());
            cartProductV2.setDescription1(productInfoLocal.getDescription1());
            cartProductV2.setProductName(productInfoLocal.getProductName());
            cartProductV2.setProductNumber(1);

            for(int i =0; i<productList.size();i++)
            {
                if(productList.get(i).getProductId() == productInfoLocal.getId().intValue())
                {
                    productList.remove(i);
                    break;
                }
            }


            productList.forEach(p -> System.out.println(p.getProductId()));
            productList.forEach(p -> System.out.println(p.getProductPrice()));


            localCart.setProductList(productList);
            // now just persist to session
            session.setAttribute("cart",localCart);

            // this was just added
            //TODO this was just added
            if(localCart.getAnnonoymousAccount() == false)
            {
                cartV2Repository.save(localCart);
            }


        }

        if(a == 2) // a is operation b is the product number
        {
            // need to get the cart info from the session not the database or you will overwrite
            List<CartProductV2> productList = null;// this was changed
            productList = cartV2.getProductList(); // just removed session annon update
            CartProductV2 cartProductV2 = new CartProductV2();
            Product productInfoLocal = productService.findById(b.longValue());
            cartProductV2.setProductId(productInfoLocal.getId().intValue());
            cartProductV2.setProductId(productInfoLocal.getId().intValue()); // sets value
            cartProductV2.setProductPrice(productInfoLocal.getProductPrice());
            cartProductV2.setProductName(productInfoLocal.getProductName());
            cartProductV2.setDescription1(productInfoLocal.getDescription1());
            cartProductV2.setProductNumber(1);

            productList.add(cartProductV2); // added the new product to productlist


            cartV2.setProductList(productList);
            // now just persist to session
            session.setAttribute("cart",cartV2);

            // adds to database ignore
            // will the actual save break the session
            // is this the same session?

            cartV2.setProductList(productList);

            // this was just added
            //TODO
            if(cartV2.getAnnonoymousAccount() == false)
            {
                cartV2Repository.save(cartV2);
            }

        }

        if(a == 3)
        {
            System.out.println("remove all products of a type block hit");

            // this only has one product? it didn't update per each session
            CartV2 localCart = (CartV2)session.getAttribute("cart");
            List<CartProductV2> productList = null;
            productList = localCart.getProductList();
            CartProductV2 cartProductV2 = new CartProductV2();
            Product productInfoLocal = productService.findById(b.longValue());
            cartProductV2.setProductId(productInfoLocal.getId().intValue());
            cartProductV2.setProductId(productInfoLocal.getId().intValue()); // sets value
            cartProductV2.setProductPrice(productInfoLocal.getProductPrice());
            cartProductV2.setProductNumber(1);


            List<CartProductV2> collectedList = removeAll(productList,cartProductV2);


            localCart.setProductList(collectedList);
            // now just persist to session
            session.setAttribute("cart",localCart);

            // need to update the cart in the repo now without detachement

            // this was just added
            //TODO this was just added
            if(localCart.getAnnonoymousAccount() == false)
            {
                cartV2Repository.save(localCart);
            }


        }

        if(a == 20)
        {
            List<CartProductV2> productList = null;// this was changed
            productList = cartV2.getProductList(); // just removed session annon update
            CartProductV2 cartProductV2 = new CartProductV2();
            Product productInfoLocal = productService.findById(b.longValue());
            cartProductV2.setProductId(productInfoLocal.getId().intValue()); // sets value
            cartProductV2.setProductPrice(productInfoLocal.getProductPrice() * .8);
            cartProductV2.setProductName(productInfoLocal.getProductName());
            cartProductV2.setDescription1(productInfoLocal.getDescription1());
            cartProductV2.setProductNumber(1);

            productList.add(cartProductV2); // added the new product to productlist


            cartV2.setProductList(productList);
            // now just persist to session
            session.setAttribute("cart",cartV2);

            // adds to database ignore
            // will the actual save break the session
            // is this the same session?

            // this was just added

            //TODO this was just added
            if(cartV2.getAnnonoymousAccount() == false)
            {
                cartV2Repository.save(cartV2);
            }

        }



        // first is a call to cart, first id the operation to be performed keyed out values follow
        // 0 : remove all , 1 : remove a single item of the type, 2 : add a single item of the type,
        // 3 : get the total price of the cart, 4 : get the price of the items
        // the second id is the product number being sent.
        // the last id is for expansion maybe checkout i'm not sure yet

        //validSDU.setProductRepository(productRepository);

        ValidSessionDataUtil validSDU2 = new ValidSessionDataUtil(session);

        model.addAttribute("cartsize",validSDU2.getProductListSize());
        model.addAttribute("carttotal",validSDU2.getCartTotal());
        model.addAttribute("LoginForm", new LoginForm());
        model.addAttribute("username",validSDU2.getUsersName());
        //model.addAttribute("first",validSDU.get)

        // make a function // make a function // make a function

        Product dummyProduct = new Product();
        dummyProduct.setProductPrice(0.0f);
        dummyProduct.setDescription1("nothing ordered");
        dummyProduct.setProductName("empty cart");
        dummyProduct.setProductCat(0);
        dummyProduct.setProductImage("bark_off.jpg");
        dummyProduct.setId(99l);

        List<Product> productList = new ArrayList<>();
        List<CartProductV2> cartProductV2s = null;
        Product tempProduct = null;
        Integer index = 0;
        Double price = 0.0;

        if(session.getAttribute("cart") !=null){
            CartV2 cartV22 = (CartV2) session.getAttribute("cart");
            cartProductV2s = cartV2.getProductList();
            if(cartProductV2s.size() == 0)
            {

            }else
            {
                for(int i = 0; i < cartProductV2s.size();i++)
                {
                    index = cartProductV2s.get(i).getProductId();
                    price = cartProductV2s.get(i).getProductPrice();
                    price = Math.floor((price * 100)/100);
                    Long longa = new Long(index);
                    try {
                        tempProduct = productRepository.findById(longa).get();
                        tempProduct.setProductPrice(price);
                        productList.add(tempProduct);
                    } catch (NullPointerException e)
                    {

                    }
                }
            }

        }

        model.addAttribute("products",productList);
        model.addAttribute("discount",appDiscountToCart(validSDU2.validCartProductList(),0.1));
        model.addAttribute("tax",appDiscountToCart(validSDU2.validCartProductList(),0.2));
        model.addAttribute("final_price",appDiscountNTax(validSDU2.validCartProductList(),0.1,0.2));
        model.addAttribute("product_details",validSDU2.validCartProductList());


        return "custom_cart";
    }

    List<CartProductV2> removeAll(List<CartProductV2> list, CartProductV2 cartProductV2){
        return list.stream()
                .filter(p -> !Objects.equals(p, cartProductV2)) // this will work if the equals method is correct
                .collect(Collectors.toList());
    }

    // this might be duplicate code

    Double cartTotal(List<CartProductV2> list){
        if(list == null){
            return 0.0;
        }

        double sum = list.stream().filter( p -> p.getProductPrice() > 0.0f).mapToDouble(o -> o.getProductPrice()).sum();
        return sum;
    }

    Double productTotal(List<CartProductV2> list, CartProductV2 cartProductV2){
        if(list == null){
            return 0.0;
        }

        if(cartProductV2 == null){
            return 0.0;
        }

        list.stream()
                .filter(p -> Objects.equals(p, cartProductV2)) // this will work if the equals method is correct
                .collect(Collectors.toList());
        double sum = list.stream().filter(p -> p.getProductPrice() > 0.0f).mapToDouble(o -> o.getProductPrice()).sum();
        return sum;
    }

    Double appDiscountToCart(List<CartProductV2> list, Double discount){
        if(list == null){
            return 0.0;
        }

        double sum = list.stream().filter( p -> p.getProductPrice() > 0.0f).mapToDouble(o -> o.getProductPrice()).sum();
        sum = sum * discount;
        return Math.floor(sum * 100)/100;
    }

    Double appDiscountNTax(List<CartProductV2> list, Double discount, Double tax){

        if(list == null) {
            return 0.0;
        }


        double sum = list.stream().filter( p -> p.getProductPrice() > 0.0f).mapToDouble(o -> o.getProductPrice()).sum();
        double discountVar = sum * discount;
        double taxvarVar = sum * tax;
        sum = sum - discountVar;
        sum = sum + taxvarVar;
        return Math.floor(sum * 100)/100;
    }

    List<ProductDetails> productDetailsCreator(List<CartProductV2> list){
        List<ProductDetails> productDetails = new ArrayList<>();
        ProductDetails temp = new ProductDetails();

        if(list != null){
            for(int i = 0;i<list.size();i++){
                temp.setProductPrice(list.get(i).getProductPrice());
                productDetails.add(temp);
            }
            return productDetails;
        }
        return null;
    }

}