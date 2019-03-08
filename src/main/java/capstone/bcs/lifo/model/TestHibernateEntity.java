package capstone.bcs.lifo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class TestHibernateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idIndex;

    private Integer category; // don't change to string please
    private String productName;
    private double price;
    private Integer numberInStock;
    private String description;
    private String image;

    // == category number to category table / map ==
    // == 0 is accessories ==
    // == 1 is appliances ==
    // == 2 is cleaning ==
    // == 3 is cooking ==
    // == 4 is hardware ==
    // == 5 is health & beauty ==
    // == 6 is home ==
    // == toys ==

    public TestHibernateEntity(){

    }

    public TestHibernateEntity(Integer category, String productName, double price, Integer numberInStock, String description, String image) {
        this.category = category;
        this.productName = productName;
        this.price = price;
        this.numberInStock = numberInStock;
        this.description = description;
        this.image = image;
    }

    // == for testing only serve up specific categories in the thymeleaf dont use toString() ==
    @Override
    public String toString() {
        return "TestHibernateEntity{" +
                "category=" + category +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", numberInStock=" + numberInStock +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestHibernateEntity that = (TestHibernateEntity) o;
        return Objects.equals(idIndex, that.idIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIndex);
    }

    public Long getIdIndex() {
        return idIndex;
    }

    public void setIdIndex(Long idIndex) {
        this.idIndex = idIndex;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(Integer numberInStock) {
        this.numberInStock = numberInStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
