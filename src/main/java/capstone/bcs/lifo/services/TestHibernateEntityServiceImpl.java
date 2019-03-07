package capstone.bcs.lifo.services;

import capstone.bcs.lifo.model.TestHibernateEntity;
import capstone.bcs.lifo.repositories.TestHibernateEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestHibernateEntityServiceImpl implements TestHibernateEntityService {

    private TestHibernateEntityRepository testHibernateEntityRepository;

    @Autowired // == Autowired for intention only should find anyways ==
    public TestHibernateEntityServiceImpl(TestHibernateEntityRepository testHibernateEntityRepository) {
        this.testHibernateEntityRepository = testHibernateEntityRepository;
    }


    @Override
    public List<TestHibernateEntity> listAll() {
        List<TestHibernateEntity> testEntities = new ArrayList<>();
        testHibernateEntityRepository.findAll().forEach(testEntities::add); //fun with Java 8
        return testEntities;
    }

    @Override
    public TestHibernateEntity getById(Long id) {
        return testHibernateEntityRepository.findById(id).orElse(null);
    }

    @Override
    public TestHibernateEntity saveOrUpdate(TestHibernateEntity entity) {
        testHibernateEntityRepository.save(entity);
        return entity;
    }

    @Override
    public void delete(Long id) {
        testHibernateEntityRepository.deleteById(id);
    }
}
