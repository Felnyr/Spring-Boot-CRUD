package io.felnyrius.testappjpa.repositories;

import io.felnyrius.testappjpa.models.TestDTO;

import java.util.List;

public interface Test {
    public List<TestDTO> findAll();

    public TestDTO findById(int theId);

    public void save(TestDTO testDto);

    public void deleteById(int theId);
}
