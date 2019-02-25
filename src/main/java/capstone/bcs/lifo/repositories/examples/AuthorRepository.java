package capstone.bcs.lifo.repositories.examples;

import capstone.bcs.lifo.model.examples.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}
