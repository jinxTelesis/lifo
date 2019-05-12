package capstone.bcs.lifo.repositories;


import capstone.bcs.lifo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

    /** these are all crud repositories they abstract writing specific JDBC commands

     */

}
