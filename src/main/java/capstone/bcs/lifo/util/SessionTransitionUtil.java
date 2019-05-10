package capstone.bcs.lifo.util;

import capstone.bcs.lifo.model.CartV2;

import javax.servlet.http.HttpSession;

public class SessionTransitionUtil {

    public boolean validSession(HttpSession session){
        if(session != null) {
            return true;
        } else {
            return false;
        }
    }

    public HttpSession AnonSession(HttpSession session) {
        if(session.getAttribute("cart") == null)
        {
            CartV2 cartV2 = new CartV2();
            cartV2.setAnnonoymousAccount(true);
            session.setAttribute("cart",cartV2);
        }
        return session;

    }
}
