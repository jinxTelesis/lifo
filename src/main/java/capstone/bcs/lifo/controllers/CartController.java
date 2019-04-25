package capstone.bcs.lifo.controllers;

import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.model.CartV2;
import capstone.bcs.lifo.repositories.CartRespository;
import capstone.bcs.lifo.services.CartService;
import capstone.bcs.lifo.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class CartController {

    private ProductService productService;
    private CartService cartService;
    private CartRespository cartRespository;

    CartController(ProductService productService,CartRespository cartRespository){
        this.productService = productService;
        this.cartService = cartService;
        this.cartRespository = cartRespository;
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
            //cart = (CartOld) session.getAttribute("cart");
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

        if(a == 2)
        {
            System.out.println("got to the write product block");
            // add product block // b is the number of the operation
            // need a null operator here
//            CartOld dbCart = cartService.findById(1l); // this is just hardcoded to first account for now
//            Product productToAdd = null;
//            List<Integer> productIdList = new ArrayList<>(100);
//            List<Double> priceList = new ArrayList<>(100);
//            List<Integer> numList = new ArrayList<>(100);
//
//            for(int i =0; i < 100;i++)
//            {
//                productIdList.add(0);
//            }
//
//            for(int i = 0; i < 100;i++)
//            {
//                priceList.add(0.0);
//            }
//
//            for(int i = 0; i < 100;i++)
//            {
//                numList.add(0);
//            }
//
//            System.out.println(priceList.size());
//
//
//
//            // this will bring the requested product via the code
//            productToAdd = productService.findById(Integer.toUnsignedLong(b));
//            System.out.println("the product id that will be added is : " + productToAdd.getId());
//
//
//            // this will get the product list out of the repo
//            //productList = cartService.getProductsByCartId(1l);
//            productIdList.add(productToAdd.getId().intValue(),productToAdd.getId().intValue());
//
//            // adds the product via it product ind as an index
//
//            // this failed you tried to add to empty list
//
//
//            // this will get the product price
//            Double productPrice = 0.0;
//            productPrice = productToAdd.getProductPrice();
//
//
//            // gets existing product list
//
//            // adds the price via it product ind as an index
//            priceList.add(productToAdd.getId().intValue(),productPrice);
//
//            Integer productNum = 0;
//            productNum++;
//            numList.add(productToAdd.getId().intValue(),productNum);
//
//
//
//            dbCart.setProductID(productIdList);
//            dbCart.setProductPrices(priceList);
//            dbCart.setProductNum(numList);
//
//            // this won't work properly it will keep creating new cart objects user logging in and out won't
//            // get the previous cart
//            cartRespository.save(dbCart);
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
