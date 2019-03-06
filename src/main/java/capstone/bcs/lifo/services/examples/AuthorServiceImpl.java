package capstone.bcs.lifo.services.examples;

import capstone.bcs.lifo.model.examples.Author;
import capstone.bcs.lifo.repositories.examples.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired // == for intent only Service will autowire I believe
    AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Author> listAll() {
        List<Author> products = new ArrayList<>();
        authorRepository.findAll().forEach(products::add); //fun with Java 8
        return products;
    }

    @Override
    public Author getById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Author saveOrUpdate(Author author) {
        authorRepository.save(author);
        return author;
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
