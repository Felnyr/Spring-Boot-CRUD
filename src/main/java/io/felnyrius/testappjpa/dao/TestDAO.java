package io.felnyrius.testappjpa.dao;

import io.felnyrius.testappjpa.models.TestDTO;

import java.util.List;

public interface TestDAO {
    public List<TestDTO> findAll();

    public TestDTO findById(int theId);

    public void save(TestDTO theTest);

    public void deleteById(int theId);
}
