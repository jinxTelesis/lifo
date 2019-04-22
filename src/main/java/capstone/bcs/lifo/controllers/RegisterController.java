package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.commands.LoginForm;
import capstone.bcs.lifo.commands.RegistrationForm;
import capstone.bcs.lifo.model.Cart;
import capstone.bcs.lifo.model.CartProducts;
import capstone.bcs.lifo.model.Customer;
import capstone.bcs.lifo.repositories.CartProductsRepository;
import capstone.bcs.lifo.repositories.CartRespository;
import capstone.bcs.lifo.services.CartProductsService;
import capstone.bcs.lifo.services.CartService;
import capstone.bcs.lifo.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegisterController {

    // cd to in bin of mariadb install location
    // mysqld --console
    // if it refused to connect your db is not on
    // might need to have admin privilege

    private CustomerService customerService;
    private CartService cartService;
    private CartProductsService cartProductsService;

    // add save operations to the service??
    private CartRespository cartRespository;
    private CartProductsRepository cartProductsRepository;

    RegisterController(CustomerService customerService,CartService cartService,CartProductsService cartProductsService, CartRespository cartRespository,
                       CartProductsRepository cartProductsRepository) {
        this.customerService = customerService;
        this.cartService = cartService;
        this.cartProductsService = cartProductsService;
        this.cartRespository = cartRespository;
        this.cartProductsRepository = cartProductsRepository;
    }


    @RequestMapping("/register")
    public String oldCustomer(Model model){
        System.out.println("the general page got called");
        model.addAttribute("registrationForm", new RegistrationForm());
        model.addAttribute("LoginForm", new LoginForm());
        return "register";
    }

    @RequestMapping("/register/{id}")
    public String getPageVar(HttpServletRequest request, @PathVariable("id") Integer id, Model model) {
        model.addAttribute("LoginForm", new LoginForm());
        model.addAttribute("registrationForm", new RegistrationForm());
        return "redirect:" + "register";
    }




    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String saveOrUpdate(Model model,@Valid RegistrationForm registrationForm, BindingResult bindingResult) {
        model.addAttribute("LoginForm", new LoginForm());
        System.out.println("general post got called");

        if(bindingResult.hasErrors())
        {
            System.out.println("the form return got called");
            return "register";
        }
        else
        {
            // this needs to set the id for the other items
            // not automatically set

            System.out.println("The new customer form got called");
            Customer newCustomer = customerService.saveOrUpdateRegistrationForm(registrationForm);
            Cart cart = new Cart();
            cartRespository.save(cart);
            CartProducts cartProducts = new CartProducts();
            cartProductsRepository.save(cartProducts);
            return "product_summary"; // this needs to be a new page for success
        }
    }

    // text backup == delete later ==
    // text backup == delete later ==
    // text backup == delete later ==

//    @RequestMapping("/register")
//    public String oldCustomer(Model model){
//        System.out.println("the general page got called");
//        model.addAttribute("registrationForm", new RegistrationForm());
//        return "register";
//    }
//
//    @RequestMapping(value = "/register",method = RequestMethod.POST)
//    public String saveOrUpdate(@Valid RegistrationForm registrationForm, BindingResult bindingResult) {
//        System.out.println("general post got called");
//
//        if(bindingResult.hasErrors())
//        {
//            System.out.println("the form return got called");
//            return "register";
//        }
//        else
//        {
//            System.out.println("The new customer form got called");
//            Customer newCustomer = customerService.saveOrUpdateRegistrationForm(registrationForm);
//
//            return "register"; // this needs to be a new page for success
//        }
//    }
}
