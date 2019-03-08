package capstone.bcs.lifo.bootstrap;

import capstone.bcs.lifo.model.TestHibernateEntity;
import capstone.bcs.lifo.repositories.TestHibernateEntityRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private TestHibernateEntityRepository testHibernateEntityRepository;

    public Bootstrap(TestHibernateEntityRepository testHibernateEntityRepository)
    {
        this.testHibernateEntityRepository = testHibernateEntityRepository;
    }

    // prob want the image in memory not reading off the database
    //ToDO

    private void initializeTestData() {
        TestHibernateEntity testProd0 = new TestHibernateEntity(0,"stamps",99.00,4,"a package of stamps", "stamppicture.jpg");
        TestHibernateEntity testProd1 = new TestHibernateEntity(1,"hair dryer",29.99,1000,"no frils hair dryer","hairdryer.jpg");
        TestHibernateEntity testProd2 = new TestHibernateEntity(2,"space ship",100000.0,1,"nasa would love it", "saturnfive.jpg");
        TestHibernateEntity testProd3 = new TestHibernateEntity(2,"russian space ship",1.0,1,"nasa would still love it", "sauyize.jpg");
        TestHibernateEntity testProd4 = new TestHibernateEntity(3,"razor wire", 5.95,100000,"ready for the beachhead", "dday.jpg");
        TestHibernateEntity testProd5 = new TestHibernateEntity(4,"ice cream",2.99,100000,"already melted","icecreamsunday.jpg");
        TestHibernateEntity testProd6 = new TestHibernateEntity(5, "lip gloss", 2.99,1000,"looks great!","somechick.jpg");
        TestHibernateEntity testProd7 = new TestHibernateEntity(6, "lawn mower of doom", 4000.00,10,"works like a charm","lawnmower.jpg");
        testHibernateEntityRepository.save(testProd0);
        testHibernateEntityRepository.save(testProd1);
        testHibernateEntityRepository.save(testProd2);
        testHibernateEntityRepository.save(testProd3);
        testHibernateEntityRepository.save(testProd4);
        testHibernateEntityRepository.save(testProd5);
        testHibernateEntityRepository.save(testProd6);
        testHibernateEntityRepository.save(testProd7);

    }

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initializeTestData();
    }


}
