package capstone.bcs.lifo.util;


import capstone.bcs.lifo.model.CartV2;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

public class ValidSessionDataUtil {

    HttpSession localSession = null;
    CartV2 cartV2 = null;
    int productNum =0;
    double cartTotal = 0;
    CartUtil cartUtil = new CartUtil();

    public ValidSessionDataUtil(HttpSession localSession) {
        this.localSession = localSession;

        try {
            this.cartV2 = (CartV2) localSession.getAttribute("cart");
        } catch (Exception e){

        }
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
