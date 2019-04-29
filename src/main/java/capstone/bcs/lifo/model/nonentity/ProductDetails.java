package capstone.bcs.lifo.model.nonentity;

public class ProductDetails {

    private double totalPrice;
    private double productTax = 0.2;
    private double productDiscount = 0.1;
    private double productPrice;

    private String productName;
    private String description1;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getTotalPrice() {
        return Math.floor((productPrice - getProductDiscount())*(this.productTax+1))*100/100;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getProductTax() {
        return Math.floor((this.productTax * this.productPrice) * 100)/100;
    }

    public void setProductTax(double productTax) {
        this.productTax = productTax;
    }

    // not a default getter don't do this at home kids
    public double getProductDiscount() {
        return Math.floor((this.productDiscount * this.productPrice)*100)/100;
    }

    public void setProductDiscount(double productDiscount) {
        this.productDiscount = productDiscount;
    }
}
