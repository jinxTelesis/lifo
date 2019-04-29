package capstone.bcs.lifo.util;

public class ThymeleafUtil {

    private boolean emptyCart;
    private boolean discount;
    private boolean submitted;
    private double discountDouble =0.1;
    private double tax = 0.2;


    public boolean isEmptyCart() {
        return emptyCart;
    }

    public void setEmptyCart(boolean emptyCart) {
        this.emptyCart = emptyCart;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }
}