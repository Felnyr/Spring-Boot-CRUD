package io.felnyrius.testappjpa.Test.dao;

import io.felnyrius.testappjpa.Test.models.SimpleDto;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SimpleDAOImpl implements SimpleDAO {

    @Autowired
    private final EntityManager entityManager;


    public SimpleDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<SimpleDto> getAgeMoreThan5() {
        return null;
    }
}
