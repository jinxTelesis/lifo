package capstone.bcs.lifo.repositories.examples;

import capstone.bcs.lifo.model.examples.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
