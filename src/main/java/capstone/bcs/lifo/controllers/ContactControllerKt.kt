package capstone.bcs.lifo.controllers

import capstone.bcs.lifo.commands.LoginForm
import capstone.bcs.lifo.util.ValidSessionDataUtil
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

@Controller
class ContactControllerKt {

    /**
     * this is the contact controller, it display mostly static content
     * about the website it passed http session with user cart info and the model to the page
     *
     */

    @RequestMapping("/contact")
    fun getPage(model: Model, session: HttpSession): String {
        model.addAttribute("LoginForm", LoginForm())
        val validSDU = ValidSessionDataUtil(session)
        model.addAttribute("cartsize", validSDU.productListSize)
        model.addAttribute("carttotal", validSDU.cartTotal)
        return "contact"
    }

    @RequestMapping("/products/contact")
    fun getPageHotFix(model: Model, session: HttpSession): String {
        model.addAttribute("LoginForm", LoginForm())
        val validSDU = ValidSessionDataUtil(session)
        model.addAttribute("cartsize", validSDU.productListSize)
        model.addAttribute("carttotal", validSDU.cartTotal)
        return "contact"
    }


    @RequestMapping("/contact/**")
    fun getPageAnt(model: Model, request: HttpServletRequest, session: HttpSession): String {
        model.addAttribute("LoginForm", LoginForm())
        val validSDU = ValidSessionDataUtil(session)
        model.addAttribute("cartsize", validSDU.productListSize)
        model.addAttribute("carttotal", validSDU.cartTotal)
        println(request.requestURI)
        val newUrl = request.requestURI
        newUrl.replace("/contact", "")
        return newUrl
    }

}