package capstone.bcs.lifo.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categories_id;

    private int parent_id;

    private String category_name;

    private int sort_order;

    private int categories_status;

    @CreatedDate
    private Date date_added;

    @LastModifiedDate
    private Date last_modified;


    public int getCategories_id() {
        return categories_id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getSort_order() {
        return sort_order;
    }

    public void setSort_order(int sort_order) {
        this.sort_order = sort_order;
    }

    public Date getDate_added() {
        return date_added;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

    public Date getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(Date last_modified) {
        this.last_modified = last_modified;
    }

    public int getCategories_status() {
        return categories_status;
    }

    public void setCategories_status(int categories_status) {
        this.categories_status = categories_status;
    }

}
