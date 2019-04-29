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
import capstone.bcs.lifo.util.ThymeleafUtil;
import capstone.bcs.lifo.util.ValidSessionDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;


@Controller
public class CartController {

    // some of these are not being used right now but the flushing to database is off
    // they will be used when that is corrected.

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
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);

        CartV2 cartV2 = null;
        Integer a = null;
        Integer b = null;



        if(session.getAttribute("cart") != null)
        {
            cartV2 = (CartV2) session.getAttribute("cart");
        }else{
            System.out.println("you need to login first buddy from cart/{ida}/{idb}/{idc}!");
            //return "product_summary";
            model.addAttribute("cartsize",validSDU.getProductListSize());
            model.addAttribute("carttotal",validSDU.getCartTotal());
            model.addAttribute("LoginForm", new LoginForm());
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

        if(a == 1) // remove just one copy
        {
            System.out.println("remove a single product block ");

            // this only has one product? it didn't update per each session
            CartV2 localCart = (CartV2)session.getAttribute("cart");
            List<CartProductV2> productList = null;
            productList = localCart.getProductList();
            CartProductV2 cartProductV2 = new CartProductV2();
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
        }

        if(a == 2) // a is operation b is the product number
        {
            // need to get the cart info from the session not the database or you will overwrite
            List<CartProductV2> productList = null;
            productList = cartV2.getProductList();
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



//            System.out.println("got to the write product block");
//
//            CartV2 localCart = null;
//            CustomerV2 localCust = cartV2.getCustomerV2();
//
//            localCart = cartService.findById(localCust.getCustomerId());
//
//            List<CartProductV2> productList = null;
//
//            productList = localCart.getProductList();
//
//            CartProductV2 cartProductV2 = new CartProductV2(); // the product created
//
//            // retrieve the product data from the product database
//            Product productInfoLocal = productService.findById(b.longValue());
//
//            cartProductV2.setProductId(productInfoLocal.getId().intValue()); // sets value
//            cartProductV2.setProductPrice(productInfoLocal.getProductPrice());
//            cartProductV2.setProductNumber(1);
//
//            productList.add(cartProductV2);
//
//
            // a have it add the product

            // adds to database ignore
            // will the actual save break the session
            // is this the same session?

            cartV2.setProductList(productList);
            cartV2.setCartidv2(1l); // set the carts id
            cartV2.setCustomerV2(cartV2.getCustomerV2());
            cartV2.setCartidv2(cartV2.getCustomerV2().getCustomerId());
            cartV2Repository.save(cartV2);

        }

        if(a == 3)
        {
            // lets deal with this one problem at a time
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

            // change this to Stream API

            List<CartProductV2> collectedList = removeAll(productList,cartProductV2);


//            for(int i =0; i<productList.size();i++)
//            {
//                if(productList.get(i).getProductId() == productInfoLocal.getId().intValue())
//                {
//                    productList.remove(i);
//                }
//            }
//
//
//            for(int i = 0; i < productList.size();i++)
//            {
//                System.out.println("this is the products in the list" + productList.get(i).getProductId());
//                System.out.println("this is the price of the corresponding products" + productList.get(i).getProductPrice());
//            }


            localCart.setProductList(collectedList);
            // now just persist to session
            session.setAttribute("cart",localCart);




            // retrieve the product data from the product database
//            Product productInfoLocal = productService.findById(b.longValue());
//            // == this is all the initial details you need == //
//            // == this is all the initial details you need == //
//            // remove all of the product
//            for(int i =0; i<productList.size();i++)
//            {
//                if(productList.get(i).getProductId() == productInfoLocal.getId().intValue())
//                {
//                    productList.remove(i);
//                }
//            }
//
//            for(int i = 0; i < productList.size();i++)
//            {
//                System.out.println("this is the products in the list" + productList.get(i).getProductId());
//                System.out.println("this is the price of the corresponding products" + productList.get(i).getProductPrice());
//            }

//            localCart.setProductList(productList);
//            cartV2.setCartidv2(1l); // set the carts id
//            localCart.setCustomerV2(cartV2.getCustomerV2());
//            localCart.setCartidv2(cartV2.getCustomerV2().getCustomerId());


            //cartV2Repository.save(localCart);
        }



        // first is a call to cart, first id the operation to be performed keyed out values follow
        // 0 : remove all , 1 : remove a single item of the type, 2 : add a single item of the type,
        // 3 : get the total price of the cart, 4 : get the price of the items
        // the second id is the product number being sent.
        // the last id is for expansion maybe checkout i'm not sure yet

        //validSDU.setProductRepository(productRepository);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        model.addAttribute("LoginForm", new LoginForm());
        model.addAttribute("username",validSDU.getUsersName());

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

        ThymeleafUtil thymeleafUtilvar = new ThymeleafUtil();
        thymeleafUtilvar.setDiscount(false);
        thymeleafUtilvar.setEmptyCart(false);
        thymeleafUtilvar.setSubmitted(false);


        if(session.getAttribute("cart") !=null){
            CartV2 cartV22 = (CartV2) session.getAttribute("cart");
            cartProductV2s = cartV2.getProductList();
            if(cartProductV2s.size() == 0)
            {
                //productList.add(dummyProduct); // dummy product
                thymeleafUtilvar.setEmptyCart(true);
                model.addAttribute("cart_state",thymeleafUtilvar);
            }else
            {
                for(int i = 0; i < cartProductV2s.size();i++)
                {
                    index = cartProductV2s.get(i).getProductId();
                    Long longa = new Long(index);
                    try {
                        tempProduct = productRepository.findById(longa).get();
                        productList.add(tempProduct);
                        thymeleafUtilvar.setEmptyCart(false);
                        model.addAttribute("cart_state",thymeleafUtilvar);
                    } catch (NullPointerException e)
                    {

                    }
                }
            }

        }
        model.addAttribute("products",productList);
        model.addAttribute("discount",appDiscountToCart(validSDU.validCartProductList(),0.1));
        model.addAttribute("tax",appDiscountToCart(validSDU.validCartProductList(),0.2));
        model.addAttribute("final_price",appDiscountNTax(validSDU.validCartProductList(),0.1,0.2));
        model.addAttribute("product_details",validSDU.validCartProductList());
        //model.addAttribute("product_details",productDetailsCreator(cartV2.getProductList()));

        return "custom_cart";
    }

    List<CartProductV2> removeAll(List<CartProductV2> list, CartProductV2 cartProductV2){
        return list.stream()
                .filter(p -> !Objects.equals(p, cartProductV2)) // this will work if the equals method is correct
                .collect(Collectors.toList());
    }

    // this might be duplicate code

    Double cartTotal(List<CartProductV2> list){
        double sum = list.stream().filter( p -> p.getProductPrice() > 0.0f).mapToDouble(o -> o.getProductPrice()).sum();
        return sum;
    }

    Double productTotal(List<CartProductV2> list, CartProductV2 cartProductV2){
        list.stream()
                .filter(p -> Objects.equals(p, cartProductV2)) // this will work if the equals method is correct
                .collect(Collectors.toList());
        double sum = list.stream().filter(p -> p.getProductPrice() > 0.0f).mapToDouble(o -> o.getProductPrice()).sum();
        return sum;
    }

    Double appDiscountToCart(List<CartProductV2> list, Double discount){
        double sum = list.stream().filter( p -> p.getProductPrice() > 0.0f).mapToDouble(o -> o.getProductPrice()).sum();
        sum = sum * discount;
        return Math.floor(sum * 100)/100;
    }

    Double appDiscountNTax(List<CartProductV2> list, Double discount, Double tax){
        double sum = list.stream().filter( p -> p.getProductPrice() > 0.0f).mapToDouble(o -> o.getProductPrice()).sum();
        double discountVar = sum * discount;
        double taxvarVar = sum * tax;
        sum = sum - discountVar;
        sum = sum + taxvarVar;
        return Math.floor(sum * 100)/100;
    }

//    List<ProductDetails> productDetailsCreator(List<CartProductV2> list){
//        List<ProductDetails> productDetails = new ArrayList<>();
//        ProductDetails temp = new ProductDetails();
//
//        if(list != null){
//            for(int i = 0;i<list.size();i++){
//                temp.setProductPrice(list.get(i).getProductPrice());
//                productDetails.add(temp);
//            }
//            return productDetails;
//        }
//        return null;
//    }

}