package capstone.bcs.lifo.controllers

import capstone.bcs.lifo.commands.LoginForm
import capstone.bcs.lifo.commands.RegistrationForm
import capstone.bcs.lifo.model.*
import capstone.bcs.lifo.repositories.CartV2Repository
import capstone.bcs.lifo.services.CustomerService
import capstone.bcs.lifo.util.SessionTransitionUtil
import capstone.bcs.lifo.util.ValidSessionDataUtil
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession
import javax.validation.Valid


@Controller
class RegisterController internal constructor(private val customerService: CustomerService, private val cartV2Repository: CartV2Repository) {

    /**
     * the registration controller works with a posted user form
     * the form uses registration form validator that i wrote
     * if the binding results don't match you don't get to enter any data into the database
     * the form now containers custom validators which are within the config package

     */


    @RequestMapping("/register")
    fun oldCustomer(model: Model, session: HttpSession): String {
        model.addAttribute("registrationForm", RegistrationForm())
        model.addAttribute("LoginForm", LoginForm())
        val validSDU = ValidSessionDataUtil(session)
        model.addAttribute("cartsize", validSDU.productListSize)
        model.addAttribute("carttotal", validSDU.cartTotal)
        return "register"
    }

    @RequestMapping("/products/register")
    fun oldCustomerHotFix(model: Model, session: HttpSession): String {
        model.addAttribute("registrationForm", RegistrationForm())
        val validSDU = ValidSessionDataUtil(session)
        model.addAttribute("cartsize", validSDU.productListSize)
        model.addAttribute("carttotal", validSDU.cartTotal)
        model.addAttribute("LoginForm", LoginForm())
        return "register"
    }

    @RequestMapping("/register/{id}")
    fun getPageVar(request: HttpServletRequest, session: HttpSession, @PathVariable("id") id: Int?, model: Model): String {
        model.addAttribute("LoginForm", LoginForm())
        model.addAttribute("registrationForm", RegistrationForm())
        val validSDU = ValidSessionDataUtil(session)
        model.addAttribute("cartsize", validSDU.productListSize)
        model.addAttribute("carttotal", validSDU.cartTotal)
        return "redirect:" + "register"
    }


    @RequestMapping("/register", method = [RequestMethod.POST])
    fun saveOrUpdate(model: Model, @Valid registrationForm: RegistrationForm, bindingResult: BindingResult, session: HttpSession): String {
        var session = session
        val sU = SessionTransitionUtil()
        session = sU.AnonSession(session)


        model.addAttribute("LoginForm", LoginForm())
        val validSDU = ValidSessionDataUtil(session)
        model.addAttribute("cartsize", validSDU.productListSize)
        model.addAttribute("carttotal", validSDU.cartTotal)

        if (bindingResult.hasErrors()) {
            println("the form return got called")
            return "register"
        } else {
            println("The new customer form got called")

            // the registration form is being altered to save session data

            val customerV2 = customerService.saveOrUpdateRegistrationForm(registrationForm)

            // get session cart and pull cart details from it
            val localCart = session.getAttribute("cart") as CartV2
            localCart.annonoymousAccount = false
            localCart.customerV2 = customerV2

            // saves the session again
            session.setAttribute("cart", localCart) // after registration we go to cart
            // session now have user details

            cartV2Repository.save(localCart)

            return "login" // this needs to be a new page for success
        }
    }


}