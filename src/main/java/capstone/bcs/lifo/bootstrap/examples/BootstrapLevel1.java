package capstone.bcs.lifo.bootstrap.examples;

import capstone.bcs.lifo.model.examples.Author;
import capstone.bcs.lifo.model.examples.Book;
import capstone.bcs.lifo.model.examples.Publisher;
import capstone.bcs.lifo.repositories.examples.AuthorRepository;
import capstone.bcs.lifo.repositories.examples.BookRepository;
import capstone.bcs.lifo.repositories.examples.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class BootstrapLevel1 implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public BootstrapLevel1(AuthorRepository authorRepository,
                           BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private PublisherRepository publisherRepository;

    private void initData(){

        Publisher pub1 = new Publisher();
        pub1.setName("Bobby");
        publisherRepository.save(pub1);

        Author timmy = new Author("Eric", "Evans");
        Book TheGreatGatsby = new Book("Domain Driven Design", "1234", pub1);
        timmy.getBooks().add(TheGreatGatsby);
        TheGreatGatsby.getAuthors().add(timmy);



        authorRepository.save(timmy);
        bookRepository.save(TheGreatGatsby);

        //Rod
        Author Dick = new Author("Dick", "Johnson");
        Book whaleTales = new Book("Java Rules", "9999", pub1);
        Dick.getBooks().add(whaleTales);

        authorRepository.save(Dick);
        bookRepository.save(whaleTales);


    }





    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
