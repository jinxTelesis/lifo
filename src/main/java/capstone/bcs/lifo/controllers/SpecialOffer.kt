package capstone.bcs.lifo.controllers


import capstone.bcs.lifo.commands.LoginForm
import capstone.bcs.lifo.model.CartV2
import capstone.bcs.lifo.util.SessionTransitionUtil
import capstone.bcs.lifo.util.ValidSessionDataUtil
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpSession

// Kotlin controller

@Controller
class SpecialOfferKt{

    @RequestMapping("/special_offer")
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
        return "special_offer"
    }

    @RequestMapping("/products/special_offer")
    fun getSpecialPageHotFix(model: Model, httpSession: HttpSession):String {
        model.addAttribute("LoginForm", LoginForm())

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