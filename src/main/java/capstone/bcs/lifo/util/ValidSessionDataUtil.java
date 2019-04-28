package capstone.bcs.lifo.util;


import capstone.bcs.lifo.model.CartProductV2;
import capstone.bcs.lifo.model.CartV2;
import capstone.bcs.lifo.model.Product;
import capstone.bcs.lifo.repositories.ProductRepository;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


public class ValidSessionDataUtil {

    private ProductRepository productRepository;

    HttpSession localSession = null;
    CartV2 cartV2 = null;
    double cartTotal = 0;
    CartUtil cartUtil = new CartUtil();

    // == Autowired for intention == //
    public ValidSessionDataUtil(HttpSession localSession) {
        this.localSession = localSession;

        try {
            this.cartV2 = (CartV2) localSession.getAttribute("cart");
        } catch (Exception e){

        }
    }

    // for intention only ==
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public boolean validSession(){
        if(localSession.getAttribute("cart") !=null){
            return true;
        } else {
            return false;
        }
    }

    public int getProductListSize(){
        if(localSession.getAttribute("cart") != null)
        {
            int temp;
            temp = cartV2.getProductList().size();
            return temp;
        }
        else
        {
            return 0;
        }
    }

    public String getUsersName(){
        if(localSession.getAttribute("cart") !=null) {
            CartV2 cartV2 = (CartV2) localSession.getAttribute("cart");
            String temp = cartV2.getCustomerV2().getpFirstName();
            temp += " " + cartV2.getCustomerV2().getpLastName();
            temp +="'";
            return temp;
        }else
        {
            String temp = "Not logged in";
            return temp;
        }
    }

    // this next one needs to pull up products via the ids not return cart products
    public List<Product> getProductsInShoppingCart(){
        Product dummyProduct = new Product();
        dummyProduct.setProductPrice(0.0f);
        dummyProduct.setDescription1("nothing ordered");
        dummyProduct.setProductName("empty cart");
        dummyProduct.setProductCat(0);
        dummyProduct.setProductImage("bark_off.jpg");
        dummyProduct.setId(99l);

        List<Product> productList = new ArrayList<>();
        List<CartProductV2> cartProductV2s = null;
        Product tempProduct = null;
        Integer index = 0;

        if(localSession.getAttribute("cart") !=null){
            CartV2 cartV2 = (CartV2) localSession.getAttribute("cart");

            cartProductV2s = cartV2.getProductList();

            if(cartV2.getProductList().size() == 0)
            {
                productList.add(dummyProduct);
                return productList;
            }

            for(int i = 0; i < cartProductV2s.size();i++)
            {
                index = cartProductV2s.get(i).getProductId();
                Long longa = new Long(index);
                // this threw a npe
                tempProduct = productRepository.findById(longa).get();
                productList.add(tempProduct);
            }
            return productList;

        }else
        {
            productList.add(dummyProduct);
            return productList;
        }
    }

    public double getCartTotal(){

        if(localSession.getAttribute("cart") != null)
        {
            cartTotal = cartUtil.cartTotal(cartV2.getProductList());
            return Math.floor(cartTotal * 100)/100;
        }
        else
        {
            return 0.0f;
        }
    }



}
