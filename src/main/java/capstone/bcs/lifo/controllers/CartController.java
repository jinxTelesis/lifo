package capstone.bcs.lifo.controllers;

import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.model.CartProductV2;
import capstone.bcs.lifo.model.CartV2;
import capstone.bcs.lifo.model.CustomerV2;
import capstone.bcs.lifo.model.Product;
import capstone.bcs.lifo.services.CartService;
import capstone.bcs.lifo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;


@Controller
public class CartController {

    private ProductService productService;
    private CartService cartService;

    // == autowired for intention only ==
    @Autowired
    CartController(ProductService productService, CartService cartService){
        this.productService = productService;
        this.cartService = cartService;
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

            // wtf was the problem then ???
            System.out.println(cartV2.getCustomerV2().getpFirstName() + " this is from cart");
            System.out.println(cartV2.getCustomerV2().getAccount().getUsername() + " this is from cart");
            System.out.println(cartV2.getCustomerV2().getpDoB());

            CustomerV2 localCust = cartV2.getCustomerV2();
            System.out.println(localCust.getAccount().getUsername() + "this is from locatlCust");
            System.out.println(localCust.getCustomerId() + "this is the user id ");


            // this is from database rather than session
            localCart = cartService.findById(1l);



            Set<CartProductV2> productSetLocal = new HashSet<>();

            // this is the database cart retreived by the session cart info
            // this will get existing products in the cart
            productSetLocal = localCart.getProductSet();

            CartProductV2 cartProductV2 = new CartProductV2(); // the product created

            // retrieve the product data from the product database
            Product productInfoLocal = productService.findById(b.longValue());
            System.out.println(productInfoLocal.getId() + " this is the product id");

            cartProductV2.setProductId(productInfoLocal.getId().intValue()); // sets value
            cartProductV2.setProductPrice(productInfoLocal.getProductPrice());
            cartProductV2.setProductNumber(1);

            // product already contained
//            if(productSetLocal.contains(cartProductV2)) {
//                cartProductV2 = productSetLocal;
//            } else
//            {
//                productSetLocal.add(cartProductV2);
//            }


//            cartProductV2.setProductId(1);
//            cartProductV2.setProductPrice(9.99);
//            cartProductV2.setProductNumber(3);
//            cartProductV2.setCartV2(cartV2);
//            productSet.add(cartProductV2);
//
//            cartV2.setProductSet(productSet);
//            cartV2.setCustomerV2(customerV2);
//
//
//
//            cartV2Repository.save(cartV2);

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


}
