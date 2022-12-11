package io.felnyrius.testappjpa.Test.repositories;

import io.felnyrius.testappjpa.Test.models.TestDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository2 extends JpaRepository<TestDTO, Integer> {
}
