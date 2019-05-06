package capstone.bcs.lifo.controllers

import capstone.bcs.lifo.services.ProductService
import capstone.bcs.lifo.util.ValidSessionDataUtil
import org.springframework.stereotype.Component
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpSession

@Component
class ReviewControllerKt internal constructor(private val productService: ProductService) {

    @RequestMapping("/review/{id}")
    fun getProductById(model: Model, @PathVariable id: Int?, session: HttpSession): String {
        model.addAttribute("product", productService.findById(Integer.toUnsignedLong(id!!)))
        val validSDU = ValidSessionDataUtil(session)
        model.addAttribute("cartsize", validSDU.productListSize)
        model.addAttribute("carttotal", validSDU.cartTotal)
        return "review"
    }

}