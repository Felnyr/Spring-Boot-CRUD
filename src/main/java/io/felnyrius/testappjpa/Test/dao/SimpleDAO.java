package io.felnyrius.testappjpa.Test.dao;

import io.felnyrius.testappjpa.Test.models.SimpleDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SimpleDAO {

     List<SimpleDto> getAgeMoreThan5();

}
