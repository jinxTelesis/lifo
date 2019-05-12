package capstone.bcs.lifo.controllers;

import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.services.ProductService;
import capstone.bcs.lifo.util.SessionTransitionUtil;
import capstone.bcs.lifo.util.ValidSessionDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TopSellersController {

    private ProductService productService;

    @Autowired
    TopSellersController(ProductService productService){
        this.productService = productService;
    }

    // change this back if you don't want them sorted

    @RequestMapping("/topsellers")
    public String getPage(Model model, HttpSession session){
        model.addAttribute("products",productService.getProductsByCategory(4));
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());

        SessionTransitionUtil sU = new SessionTransitionUtil();
        session = sU.AnonSession(session);
        return "topsellers";
    }

     @RequestMapping("/topsellers/asec")
    public String getPageDesc(Model model, HttpSession session){
        model.addAttribute("products", productService.getProductsDesc());
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());

        SessionTransitionUtil sU = new SessionTransitionUtil();
        session = sU.AnonSession(session);
        return "topsellers";
    }

    @RequestMapping("/topsellers/desc")
    public String getPageAesc(Model model,HttpSession session){
        model.addAttribute("products", productService.getProductsAsce());
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());

        SessionTransitionUtil sU = new SessionTransitionUtil();
        session = sU.AnonSession(session);
        return "topsellers";
    }

    @RequestMapping("/topsellers/asec/price")
    public String getPageAescByPrice(Model model, HttpSession session){
        model.addAttribute("products", productService.getProductAsecPrice());
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());

        SessionTransitionUtil sU = new SessionTransitionUtil();
        session = sU.AnonSession(session);
        return "topsellers";
    }

    @RequestMapping("/topsellers/desc/price")
    public String getPageDescByPrice(Model model, HttpSession session){
        model.addAttribute("products", productService.getProductDescPrice());
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());

        SessionTransitionUtil sU = new SessionTransitionUtil();
        session = sU.AnonSession(session);
        return "topsellers";
    }


}