package io.felnyrius.testappjpa.repositories;

import io.felnyrius.testappjpa.dao.TestDAOImpl;
import io.felnyrius.testappjpa.models.TestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class TestRepositoryImpl implements Test {

    @Autowired
    public TestRepositoryImpl(TestDAOImpl testDAO) {
        this.testDAO = testDAO;
    }

    private final TestDAOImpl testDAO;

    @Override
    @Transactional
    public List<TestDTO> findAll() {
        return this.testDAO.findAll();
    }

    @Override
    @Transactional
    public TestDTO findById(int theId) {
        return this.testDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(TestDTO testDto) {
        this.testDAO.save(testDto);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        this.testDAO.deleteById(theId);
    }
}
