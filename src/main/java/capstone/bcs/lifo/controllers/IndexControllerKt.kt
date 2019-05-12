package capstone.bcs.lifo.controllers

import capstone.bcs.lifo.commands.LoginForm
import capstone.bcs.lifo.services.ProductService
import capstone.bcs.lifo.util.SessionTransitionUtil
import capstone.bcs.lifo.util.ValidSessionDataUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpSession

@Controller
class IndexControllerKt @Autowired // intention
internal constructor(private val productService: ProductService) {

    /**
     * the index controller is for the home page, and mappings someone might type in manually
     * it will bring up product data or display it in the reverse order
     *
     */

    @RequestMapping("/", "/index", "/.html", "/index.html")
    fun getIndex(model: Model, session: HttpSession): String {
        var session = session
        model.addAttribute("products", productService.productsAsce)
        //model.addAttribute("products", productService.getProductsByCategory(Integer.valueOf(productCat)));
        model.addAttribute("LoginForm", LoginForm())
        val validSDU = ValidSessionDataUtil(session)
        model.addAttribute("cartsize", validSDU.productListSize)
        model.addAttribute("carttotal", validSDU.cartTotal)

        val sU = SessionTransitionUtil()
        session = sU.AnonSession(session)
        return "index"
    }

    @RequestMapping("/indexRev")
    fun getIndexByProductCat(model: Model, session: HttpSession): String {
        val validSDU = ValidSessionDataUtil(session)
        model.addAttribute("cartsize", validSDU.productListSize)
        model.addAttribute("carttotal", validSDU.cartTotal)
        model.addAttribute("products", productService.productsDesc)
        model.addAttribute("LoginForm", LoginForm())
        return "index"
    }

    @RequestMapping("/products/indexRev")
    fun getIndexByProductCatHotFix(model: Model, session: HttpSession): String {
        val validSDU = ValidSessionDataUtil(session)
        model.addAttribute("cartsize", validSDU.productListSize)
        model.addAttribute("carttotal", validSDU.cartTotal)
        model.addAttribute("products", productService.productsDesc)
        model.addAttribute("LoginForm", LoginForm())
        return "index"
    }

}