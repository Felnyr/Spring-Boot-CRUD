package io.felnyrius.testappjpa.Test.dao;

import io.felnyrius.testappjpa.Test.models.TestDTO;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TestDAOImpl implements TestDAO {

    @Autowired
    public TestDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private final EntityManager entityManager;

    @Override
    public List<TestDTO> findAll() {
        // Get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // Create a query mapped to type not table name
        Query<TestDTO> theQuery = currentSession.createQuery("from TestDTO", TestDTO.class);

        // Execute query and get result list
        List<TestDTO> tests = theQuery.getResultList();

        // Return the results
        return tests;
    }

    @Override
    public TestDTO findById(int theId) {
        // Get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // Get the employee
        TestDTO theTest = currentSession.get(TestDTO.class, theId);

        // Return the employee
        return theTest;
    }

    @Override
    public void save(TestDTO theTest) {
        // Get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
//        currentSession.save(theTest);
        // Save employee
        currentSession.saveOrUpdate(theTest);
    }

    @Override
    public void deleteById(int theId) {
        // Get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // Delete the test by primary key
        Query<?> theQuery = currentSession.createQuery("delete from TestDTO where id = :testId");

        theQuery.setParameter("testId", theId);

        theQuery.executeUpdate();
    }
}
