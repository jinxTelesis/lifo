package capstone.bcs.lifo.controllers

import capstone.bcs.lifo.commands.LoginForm
import capstone.bcs.lifo.util.ValidSessionDataUtil
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpSession

@Controller
class TacController {

    /**
     * this is a plain text page displaying our terms and conditions
     */

    @RequestMapping("/tac")
    fun getPage(model: Model, session: HttpSession): String {
        model.addAttribute("LoginForm", LoginForm())
        val validSDU = ValidSessionDataUtil(session)
        model.addAttribute("cartsize", validSDU.productListSize)
        model.addAttribute("carttotal", validSDU.cartTotal)
        return "tac"
    }

    @RequestMapping("products/tac")
    fun getPageHotFix(model: Model, session: HttpSession): String {
        model.addAttribute("LoginForm", LoginForm())
        val validSDU = ValidSessionDataUtil(session)
        model.addAttribute("cartsize", validSDU.productListSize)
        model.addAttribute("carttotal", validSDU.cartTotal)
        return "tac"
    }

}