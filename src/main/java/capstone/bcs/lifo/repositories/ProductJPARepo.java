package capstone.bcs.lifo.repositories;

import capstone.bcs.lifo.model.ProductJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJPARepo extends JpaRepository<ProductJPA,Long> {

}
