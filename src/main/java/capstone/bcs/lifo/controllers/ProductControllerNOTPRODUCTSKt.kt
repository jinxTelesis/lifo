package capstone.bcs.lifo.controllers

import capstone.bcs.lifo.commands.LoginForm
import capstone.bcs.lifo.services.ProductService
import capstone.bcs.lifo.util.ValidSessionDataUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession


@Controller
class ProductControllerNOTPRODUCTS @Autowired // intention only
internal constructor(private val productService: ProductService) {


    @RequestMapping("/product/{id}")
    fun getProductByIdHotFix(request: HttpServletRequest, @PathVariable id: String, model: Model, session: HttpSession): String {
        val validSDU = ValidSessionDataUtil(session)
        model.addAttribute("cartsize", validSDU.productListSize)
        model.addAttribute("carttotal", validSDU.cartTotal)
        if (id == "product") {
            model.addAttribute("product", productService.findById(1L))
            return "product"
        }
        model.addAttribute("product", productService.findById(Integer.toUnsignedLong(Integer.parseInt(id))))
        model.addAttribute("LoginForm", LoginForm())
        return "product"
    }

}