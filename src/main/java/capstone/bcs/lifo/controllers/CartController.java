package capstone.bcs.lifo.controllers;

import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.model.Product;
import capstone.bcs.lifo.model.SimpleCart;
import capstone.bcs.lifo.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {

    private ProductService productService;

    CartController(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping({"/cart"})
    public String getPageLogin(Model model, HttpSession session){
        System.out.println("cart button worked!");
        model.addAttribute("LoginForm", new LoginForm());

        if(session.getAttribute("cart") != null)
        {
            SimpleCart cart = null;
            //Cart cart = null;
            cart = (SimpleCart)session.getAttribute("cart");
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
//        //Cart cart = null;
//        SimpleCart cart = null;
//
//        if(session.getAttribute("cart") != null)
//        {
//            //cart = (Cart)session.getAttribute("cart");
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
        SimpleCart cart = null;
        Integer a = null;
        Integer b = null;

        if(session.getAttribute("cart") != null)
        {
            cart = (SimpleCart) session.getAttribute("cart");
        }else{
            System.out.println("you need to login first buddy from cart/{ida}/{idb}/{idc}!");
            //return "product_summary";
            return "invalid_product_summary";
        }

        // need to do conversions now


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



        if(a == 1)
        {
            // remove product block

        }

        if(a == 2)
        {

            SimpleCart simpleCart = new SimpleCart();
            List<Product> productList = simpleCart.getProductList(); // list item

            // find product with product repo
            Product product = new Product();
            product = productService.findById(Integer.toUnsignedLong(b));
            // this needs to be added at the index not just thrown in
            productList.add(product);

            // need to get the list before you can set it
            // this needs to be refactored
            simpleCart.setProductList(productList);


            Double productPrice = product.getProductPrice();
            //List<Double>




            simpleCart.getProductPrice(); // list item
            simpleCart.getProductList(); // list item

            // this data model is more complex than it should be
        }

        if(a == 3)
        {
            // remove all of the product
        }



        //return "product_summary";
        return "product_summary";

        // first is a call to cart, first id the operation to be performed keyed out values follow
        // 0 : remove all , 1 : remove a single item of the type, 2 : add a single item of the type,
        // 3 : get the total price of the cart, 4 : get the price of the items
        // the second id is the product number being sent.
        // the last id is for expansion maybe checkout i'm not sure yet
    }
}
