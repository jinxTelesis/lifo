package capstone.bcs.lifo.model;

import javax.persistence.*;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;


@Entity
public class Product implements Comparator<Product>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private Integer productCat;

    private double productPrice;
    private double totalPrice;

    private double productTax = 0.2;
    private double productDiscount = 0.1;

    private String productImage;
    private String productDimensions;

    @Lob
    private String description1;

    @Lob
    private String description2;

    @Lob
    private String description3;

    @Lob
    private String description4;

    public Product(){

    }

    Product(String productName, Integer productCat, double productPrice, String productImage, String productDimensions, String description1, String description2, String description3) {
        this.productName = productName;
        this.productCat = productCat;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productDimensions = productDimensions;
        this.description1 = description1;
        this.description2 = description2;
        this.description3 = description3;
    }

    // not a default getter don't do this at home kids

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

    public Product(Long id) {
        this.id = id;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    @Column (updatable = true,name="description1",columnDefinition = "text")
    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) { this.description1 = description1; }

    @Column (updatable = true,name="description2",columnDefinition = "text")
    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) { this.description2 = description2; }

    @Column (updatable = true,name="description3",columnDefinition = "text")
    public String getDescription3() {
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    @Column (updatable = true,name="description4",columnDefinition = "text")
    public String getDescription4() {
        return description4;
    }

    public void setDescription4(String description4) {
        this.description4 = description4;
    }

    public String getProductDimensions() {
        return productDimensions;
    }

    public void setProductDimensions(String productDimensions) {
        this.productDimensions = productDimensions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProductCat() {
        return productCat;
    }

    public void setProductCat(Integer productCat) {
        this.productCat = productCat;
    }


    @Override
    public int compare(Product o1, Product o2) {

        String strComp1 = o1.getProductName();
        String strComp2 = o2.getProductName();

        return strComp1.compareTo(strComp2);
    }

    @Override
    public Comparator<Product> reversed() {
        return null;
    }

    @Override
    public Comparator<Product> thenComparing(Comparator<? super Product> other) {
        return null;
    }

    @Override
    public <U> Comparator<Product> thenComparing(Function<? super Product, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return null;
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Product> thenComparing(Function<? super Product, ? extends U> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Product> thenComparingInt(ToIntFunction<? super Product> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Product> thenComparingLong(ToLongFunction<? super Product> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Product> thenComparingDouble(ToDoubleFunction<? super Product> keyExtractor) {
        return null;
    }
}
