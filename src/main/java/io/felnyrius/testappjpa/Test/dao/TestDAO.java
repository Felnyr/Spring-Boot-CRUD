package io.felnyrius.testappjpa.Test.dao;

import io.felnyrius.testappjpa.Test.models.TestDTO;

import java.util.List;

public interface TestDAO {
    public List<TestDTO> findAll();

    public TestDTO findById(int theId);

    public void save(TestDTO theTest);

    public void deleteById(int theId);
}
