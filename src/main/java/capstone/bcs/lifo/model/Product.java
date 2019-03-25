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
