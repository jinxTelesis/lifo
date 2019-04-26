package capstone.bcs.lifo.controllers;

import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.model.CartProductV2;
import capstone.bcs.lifo.model.CartV2;
import capstone.bcs.lifo.model.CustomerV2;
import capstone.bcs.lifo.model.Product;
import capstone.bcs.lifo.repositories.CartV2Repository;
import capstone.bcs.lifo.repositories.CustomerV2Repository;
import capstone.bcs.lifo.services.CartService;
import capstone.bcs.lifo.services.ProductService;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


@Controller
public class CartController {

    private ProductService productService;
    private CartService cartService;
    private CustomerV2Repository customerV2Repository;

    // should just be the service fix this
    private CartV2Repository cartV2Repository;

    // == autowired for intention only ==
    @Autowired
    CartController(ProductService productService, CartService cartService, CartV2Repository cartV2Repository, CustomerV2Repository customerV2Repository){
        this.productService = productService;
        this.cartService = cartService;
        this.cartV2Repository = cartV2Repository;
    }

    @RequestMapping({"/cart"})
    public String getPageLogin(Model model, HttpSession session){
        System.out.println("cart button worked!");
        model.addAttribute("LoginForm", new LoginForm());

        if(session.getAttribute("cart") != null)
        {
            //CartOld cart = null;
            CartV2 cartV2 = null;

            cartV2 = (CartV2) session.getAttribute("cart");
            System.out.println("got the cart!!!!");
        }else{
            System.out.println("you need to login first buddy!");

            return "invalid_product_summary";
        }
        return "product_summary";
    }

    // == this needs to be remove at some point
    @RequestMapping({"/cart/product_summary"})
    public String hotFix(Model model, HttpSession session) {
        model.addAttribute("LoginForm", new LoginForm());
        return "product_summary";
    }

    // == to fix this correctly need to put in controller request mapping order
    // == link can be found at https://stackoverflow.com/questions/17374549/spring-set-handlermapping-priority
    // == this needs to be removed at some point
    @RequestMapping({"/products/product_summary"})
    public String hotFix2(Model model, HttpSession session) {
        model.addAttribute("LoginForm", new LoginForm());
        return "product_summary";
    }


//    @RequestMapping("/cart/{id}")
//    public String getPageVar(HttpServletRequest request,HttpSession session,@PathVariable("id") String id, Model model) {
//        String referer = request.getHeader("Referer");
//        model.addAttribute("LoginForm", new LoginForm());
//
//
//        //CartOld cart = null;
//        SimpleCart cart = null;
//
//        if(session.getAttribute("cart") != null)
//        {
//            //cart = (CartOld)session.getAttribute("cart");
//            cart = (SimpleCart)session.getAttribute("cart");
//        }else{
//            System.out.println("you need to login first buddy from /cart/{id}!");
//            //return "redirect:" + "product_summary";
//            return "invalid_product_summary";
//        }
//
//        //return "product_summary";
//        return "redirect:" + "product_summary";
//    }

//    @RequestMapping("/cart/{ida}/{idb}")
//    public String getPageVarVar(HttpServletRequest request,@PathVariable("ida") String id,@PathVariable("idb") String idb, Model model) {
//        String referer = request.getHeader("Referer");
//        model.addAttribute("LoginForm", new LoginForm());
//        //return "/product_summary";
//        return "product_summary";
//    }

    @RequestMapping("/cart/{ida}/{idb}/{idc}")
    public String getPageVarVarVar(HttpServletRequest request,HttpSession session,@PathVariable("ida") String ida,
                                   @PathVariable("idb") String idb,@PathVariable("idc") String idc, Model model) throws Exception {
        String referer = request.getHeader("Referer");
        model.addAttribute("LoginForm", new LoginForm());
        //CartOld cart = null;
        CartV2 cartV2 = null;
        Integer a = null;
        Integer b = null;



        if(session.getAttribute("cart") != null)
        {
            cartV2 = (CartV2) session.getAttribute("cart");
        }else{
            System.out.println("you need to login first buddy from cart/{ida}/{idb}/{idc}!");
            //return "product_summary";
            return "invalid_product_summary";
        }

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

        System.out.println("this is the first cart parameter " + a);
        System.out.println("this is the second car parameter " + b);

        if(a == 1)
        {

        }

        if(a == 2) // a is operation b is the product number
        {
            System.out.println("got to the write product block");

            CartV2 localCart = null;
            CustomerV2 localCust = cartV2.getCustomerV2();
//
            System.out.println(cartV2.getCustomerV2().getpFirstName() + " this is from cart");
            System.out.println(cartV2.getCustomerV2().getAccount().getUsername() + " this is from cart");
            System.out.println(cartV2.getCustomerV2().getpDoB());


            System.out.println(localCust.getAccount().getUsername() + "this is from locatlCust");
            System.out.println(localCust.getCustomerId() + "this is the user id ");


            // this is from database rather than session
            // issue with cart service?
            System.out.println("this is the local customer id " + localCust.getCustomerId());
            localCart = cartService.findById(localCust.getCustomerId());



            Set<CartProductV2> productSetLocal = new HashSet<>();
            CartProductV2 testProduct = new CartProductV2();
            testProduct.setProductId(1);

            testProduct.setProductNumber(1);
            //productSetLocal.add()

            // this is the database cart retreived by the session cart info
            // this will get existing products in the cart
            productSetLocal = localCart.getProductSet();

            CartProductV2 cartProductV2 = new CartProductV2(); // the product created

            // retrieve the product data from the product database
            Product productInfoLocal = productService.findById(b.longValue());
            System.out.println(productInfoLocal.getId() + " this is the product id");

            cartProductV2.setProductId(productInfoLocal.getId().intValue()); // sets value
            cartProductV2.setProductPrice(productInfoLocal.getProductPrice());
            // this line is part of test product
            // remove after
            testProduct.setProductPrice(productInfoLocal.getProductPrice());
            productSetLocal.add(testProduct);
            // this line is part of test product
            // remove after

            cartProductV2.setProductNumber(1);

            Boolean addProduct = false;
            Boolean incrementNumber = false;
            CartProductV2 carIteratorHolder = null;

            // trying to improve use of sets over dict arraylist // know this this not the best solution

            Iterator<CartProductV2> it = productSetLocal.iterator();
            while(it.hasNext()) {

                carIteratorHolder = it.next();
                if(carIteratorHolder.getProductId() == cartProductV2.getProductId())
                {
                    System.out.println("Same value iterated once");
                    carIteratorHolder.setProductNumber(carIteratorHolder.getProductNumber() + 1);
                    if(it.hasNext())
                    {
                        it.next().setProductNumber(carIteratorHolder.getProductNumber()); // think this should adjust it in the database
                    }
                } else
                {
                    addProduct = true;
                }
            }


            // handles if the product is not already in the set
            if(addProduct == true)
            {
                cartProductV2.setProductNumber(1);
                productSetLocal.add(cartProductV2);
                addProduct = false;
            }

            // need to set holder to the real saved value it works correctly
            // case where product number just needs to be incremented
            // because it is already in the set


            Iterator<CartProductV2> it2 = productSetLocal.iterator();
            while (it2.hasNext()){
                System.out.println(it2.next().getProductNumber() + " this is product numbers");
            }

            // now just save the data
            //cartV2Repository.save()
            // get correct users cart then save


//            CustomerV2 customerV2 = customerService.saveOrUpdateRegistrationForm(registrationForm);
//            CartV2 cartV2 = new CartV2();// this is the outer
//            customerV2.setCartV2(cartV2);
//            cartV2.setCustomerV2(customerV2);
//
//            // this is a blank productset
//            Set<CartProductV2> productSet = new HashSet<>();
//            CartProductV2 cartProductV2 = new CartProductV2();
//            cartProductV2.setCartV2(cartV2);
//            productSet.add(cartProductV2);
//
//            cartV2.setProductSet(productSet);
//            cartV2.setCustomerV2(customerV2);
//            cartV2Repository.save(cartV2);

            localCart.setProductSet(productSetLocal);
            cartV2.setCartidv2(1l); // set the carts id
            localCart.setCustomerV2(cartV2.getCustomerV2());
            localCart.setCartidv2(cartV2.getCustomerV2().getCustomerId());


            System.out.println("what is this parameter? " + localCart.getCartidv2());
            session.setAttribute("cart",localCart);
            System.out.println("this is localCust value before save" + localCust.getCustomerId() + " " + localCust.getpFirstName());
            cartV2Repository.save(localCart);

        }

        if(a == 3)
        {
            // remove all of the product

        }

        //return "product_summary";


        // first is a call to cart, first id the operation to be performed keyed out values follow
        // 0 : remove all , 1 : remove a single item of the type, 2 : add a single item of the type,
        // 3 : get the total price of the cart, 4 : get the price of the items
        // the second id is the product number being sent.
        // the last id is for expansion maybe checkout i'm not sure yet
        return "product_summary";
    }

    static public void checkSessionDate(CartV2 cartV2){
        System.out.println(cartV2.getCustomerV2().getCustomerId());
    }


}
