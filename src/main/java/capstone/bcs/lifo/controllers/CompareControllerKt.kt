package capstone.bcs.lifo.controllers

import capstone.bcs.lifo.commands.LoginForm
import capstone.bcs.lifo.repositories.CartProductV2Repository
import capstone.bcs.lifo.repositories.CartV2Repository
import capstone.bcs.lifo.repositories.CustomerV2Repository
import capstone.bcs.lifo.services.ProductService
import capstone.bcs.lifo.util.SessionTransitionUtil
import capstone.bcs.lifo.util.ValidSessionDataUtil
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpSession

@Controller
class CompareControllerKt internal constructor(private val cartV2Repository: CartV2Repository, private val customerV2Repository: CustomerV2Repository,
                                             private val cartProductV2Repository: CartProductV2Repository, private val productService: ProductService) {

    @RequestMapping("/compare")
    fun getPage(model: Model, session: HttpSession): String {
        var session = session
        model.addAttribute("LoginForm", LoginForm())
        val validSDU = ValidSessionDataUtil(session)
        model.addAttribute("cartsize", validSDU.productListSize)
        model.addAttribute("carttotal", validSDU.cartTotal)

        val sU = SessionTransitionUtil()
        session = sU.AnonSession(session)
        return "compare"
    }


    @RequestMapping("/products/compare")
    fun getPageHotFix(model: Model, session: HttpSession): String {
        model.addAttribute("LoginForm", LoginForm())
        val validSDU = ValidSessionDataUtil(session)
        model.addAttribute("cartsize", validSDU.productListSize)
        model.addAttribute("carttotal", validSDU.cartTotal)
        return "compare"
    }

}