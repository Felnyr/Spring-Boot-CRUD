package io.felnyrius.testappjpa.Test.repositories;

import io.felnyrius.testappjpa.Test.models.SimpleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleRespository extends JpaRepository<SimpleDto, Integer> {
}
