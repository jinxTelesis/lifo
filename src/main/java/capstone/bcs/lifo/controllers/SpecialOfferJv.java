package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.services.ProductService;
import capstone.bcs.lifo.util.SessionTransitionUtil;
import capstone.bcs.lifo.util.ValidSessionDataUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

//@Controller
public class SpecialOfferJv {

    /**
     * this controller is a repeat of the basic products page
     * the key difference here is the special price offerings
     * map to different hyperlinks so the cart will be informed
     * it is the lower price version of the product
     * This Java version of the controller is disabled and the Kotlin version runs
     */

    private final ProductService productService;

    public SpecialOfferJv(ProductService productService) {
        this.productService = productService;
    }


    @RequestMapping("/special_offer")
    public String getPage(Model model, HttpSession session){
        // == this will produce the cart == //
        SessionTransitionUtil sU = new SessionTransitionUtil();
        session = sU.AnonSession(session);
        // == this will produce the cart == //

        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "special_offer";
    }

    @RequestMapping("products/special_offer/{id}")
    public String getPageHotFix(Model model, HttpSession session, @PathVariable String id){
        // maybe put exception handling here
        Integer productCat = Integer.valueOf(id);
        model.addAttribute("products", productService.getProductsByCategory(Integer.valueOf(productCat)));
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "special_offer";
    }

//    @RequestMapping("/special_offer/{id}")
//    public String getPageVar(HttpServletRequest request, @PathVariable("id") Integer id, Model model) {
//        model.addAttribute("LoginForm", new LoginForm());
//        String referer = request.getHeader("Referer"); // if change needed
//        return "redirect:" + "special_offer";
//    }


}