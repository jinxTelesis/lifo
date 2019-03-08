package capstone.bcs.lifo.services;

import capstone.bcs.lifo.model.TestHibernateEntity;

import java.util.List;

public interface TestHibernateEntityService {

    List<TestHibernateEntity> listAll();

    TestHibernateEntity getById(Long id);

    TestHibernateEntity saveOrUpdate(TestHibernateEntity entity);

    void delete(Long id);
}
