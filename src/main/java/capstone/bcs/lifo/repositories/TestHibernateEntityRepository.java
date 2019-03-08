package capstone.bcs.lifo.repositories;

import capstone.bcs.lifo.model.TestHibernateEntity;
import org.springframework.data.repository.CrudRepository;

public interface TestHibernateEntityRepository extends CrudRepository<TestHibernateEntity,Long> {

}
