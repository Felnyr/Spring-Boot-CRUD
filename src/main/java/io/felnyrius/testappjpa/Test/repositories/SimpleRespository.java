package io.felnyrius.testappjpa.Test.repositories;

import io.felnyrius.testappjpa.Test.models.SimpleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SimpleRespository extends JpaRepository<SimpleDto, Integer> {
    @Query(value = "SELECT * FROM simple WHERE simple.age > 5", nativeQuery = true)
    List<SimpleDto> getAgeMoreThan5();
}
