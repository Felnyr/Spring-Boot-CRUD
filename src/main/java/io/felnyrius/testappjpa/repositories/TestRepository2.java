package io.felnyrius.testappjpa.repositories;

import io.felnyrius.testappjpa.models.TestDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository2 extends JpaRepository<TestDTO, Integer> {
}
