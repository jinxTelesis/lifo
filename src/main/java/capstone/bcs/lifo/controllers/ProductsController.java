package capstone.bcs.lifo.controllers;

import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.services.ProductService;
import capstone.bcs.lifo.util.ValidSessionDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ProductsController {

    private ProductService productService;

    @Autowired
    ProductsController(ProductService productService){
        this.productService = productService;
    }

    // change this back if you don't want them sorted

    @RequestMapping("/products")
    public String getPage(Model model, HttpSession session){
        model.addAttribute("products",productService.getProductSet());
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "products";
    }

    @RequestMapping("/products/products")
    public String getPageHotFix(Model model, HttpSession session){
        model.addAttribute("products",productService.getProductSet());
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "products";
    }

    @RequestMapping("/products/asec")
    public String getPageDesc(Model model, HttpSession session){
        model.addAttribute("products", productService.getProductsDesc());
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "products";
    }

    @RequestMapping("/products/desc")
    public String getPageAesc(Model model,HttpSession session){
        model.addAttribute("products", productService.getProductsAsce());
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "products";
    }

    @RequestMapping("/products/asec/price")
    public String getPageAescByPrice(Model model, HttpSession session){
        model.addAttribute("products", productService.getProductAsecPrice());
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "products";
    }

    @RequestMapping("/products/desc/price")
    public String getPageDescByPrice(Model model, HttpSession session){
        model.addAttribute("products", productService.getProductDescPrice());
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        return "products";
    }

    @RequestMapping("/products/{productCat}")
    public String getPageOrder(HttpServletRequest request, @PathVariable String productCat, Model model, HttpSession session){
        model.addAttribute("products", productService.getProductsByCategory(Integer.valueOf(productCat)));
        model.addAttribute("LoginForm", new LoginForm());
        ValidSessionDataUtil validSDU = new ValidSessionDataUtil(session);
        model.addAttribute("cartsize",validSDU.getProductListSize());
        model.addAttribute("carttotal",validSDU.getCartTotal());
        String referer = request.getHeader("Referer");
        return "products";
    }
}