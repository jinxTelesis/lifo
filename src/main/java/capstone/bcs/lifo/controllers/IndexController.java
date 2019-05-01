package capstone.bcs.lifo.controllers;

import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.services.ProductService;
import capstone.bcs.lifo.util.SessionTransitionUtil;
import capstone.bcs.lifo.util.ValidSessionDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

// start a registration page -


@Controller
public class IndexController {

    // == the main page should have /.html
    //@RequestMapping({"/","/index","/.html","/index.html"})
    public String index(){
        return "index";
    }

    private ProductService productService;

    @Autowired // intention
    IndexController(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping({"/","/index","/.html","/index.html"})
    public String getIndex(Model model, HttpSession session){
        model.addAttribute("products", productService.getProductsAsce());
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());

        SessionTransitionUtil sU = new SessionTransitionUtil();
        session = sU.AnonSession(session);
        return "index";
    }


    @RequestMapping({"/indexRev"})
    public String getIndexByProductCat(Model model, HttpSession session){
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        model.addAttribute("products", productService.getProductsDesc());
        model.addAttribute("LoginForm", new LoginForm());
        return "index";
    }

    @RequestMapping({"/products/indexRev"})
    public String getIndexByProductCatHotFix(Model model, HttpSession session){
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        model.addAttribute("products", productService.getProductsDesc());
        model.addAttribute("LoginForm", new LoginForm());
        return "index";
    }

//    @RequestMapping("/indexRev/{id}")
//    public String getPageVar(HttpServletRequest request,@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("LoginForm", new LoginForm());
//        return "indexRev";
//    }



}