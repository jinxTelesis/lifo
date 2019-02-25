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

    // == these are instantiations of the repo with crud operations ==
    // == filled with the bootstrap data
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    // == just a constructor ==
    public BootstrapLevel1(AuthorRepository authorRepository,
                           BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    // == bootstrap data ==
    private void initData(){

        Publisher pub1 = new Publisher();
        pub1.setName("Bobby");
        publisherRepository.save(pub1);

        Author timmy = new Author("Biff", "barker");
        Book TheGreatGatsby = new Book("This to shale pass", "911", pub1);
        timmy.getBooks().add(TheGreatGatsby);
        TheGreatGatsby.getAuthors().add(timmy);



        authorRepository.save(timmy);
        bookRepository.save(TheGreatGatsby);

        Author Dick = new Author("Dick", "Johnson");
        Book whaleTales = new Book("Java Rules", "9999", pub1);
        Dick.getBooks().add(whaleTales);

        authorRepository.save(Dick);
        bookRepository.save(whaleTales);
    }

    @Override // == calls on refresh ==
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
