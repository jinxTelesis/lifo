package capstone.bcs.lifo.controllers


import capstone.bcs.lifo.commands.LoginForm
import capstone.bcs.lifo.services.ProductService
import capstone.bcs.lifo.util.SessionTransitionUtil
import capstone.bcs.lifo.util.ValidSessionDataUtil
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpSession

// Kotlin controller

@Controller
class SpecialOfferKt(val productService: ProductService) {


    @RequestMapping("/special_offer_backup")
    fun getSpecialPage(model: Model, httpSession: HttpSession):String {
        model.addAttribute("LoginForm", LoginForm())

        // == produces the cart ==
        var sU = SessionTransitionUtil()
        var httpSession = sU.AnonSession(httpSession)
        // == produces the cart ==

        model.addAttribute("LoginForm", LoginForm())
        val validSDU = ValidSessionDataUtil(httpSession)
        model.addAttribute("cartsize", validSDU.productListSize)
        model.addAttribute("carttotal", validSDU.cartTotal)
        return "special_offer_backup"
    }

    @RequestMapping("products/special_offer/{id}")
    fun getSpecialPageHotFix(model: Model, httpSession: HttpSession,@PathVariable id:String):String {
        model.addAttribute("LoginForm", LoginForm())

        val productCat = Integer.valueOf(id)
        model.addAttribute("products", productService.getProductsByCategory(Integer.valueOf(productCat)))

        // == produces the cart ==
        var sU = SessionTransitionUtil()
        var httpSession = sU.AnonSession(httpSession)
        // == produces the cart ==

        model.addAttribute("LoginForm", LoginForm())
        val validSDU = ValidSessionDataUtil(httpSession)
        model.addAttribute("cartsize", validSDU.productListSize)
        model.addAttribute("carttotal", validSDU.cartTotal)
        return "special_offer"
    }



}