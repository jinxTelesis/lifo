package capstone.bcs.lifo.services.examples;

import capstone.bcs.lifo.model.examples.Author;

import java.util.List;

public interface AuthorService {

    List<Author> listAll();

    Author getById(Long id);

    Author saveOrUpdate(Author author);

    void delete(Long id);

}
