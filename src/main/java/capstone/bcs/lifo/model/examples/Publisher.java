package capstone.bcs.lifo.model.examples;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity // makes h2 entity can log into h2 database
public class Publisher {

    @Id // auto generated id for database
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name; // fields
    private String address; // fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
