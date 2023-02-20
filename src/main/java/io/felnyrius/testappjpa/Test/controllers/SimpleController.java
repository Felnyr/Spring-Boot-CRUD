package io.felnyrius.testappjpa.Test.controllers;

import io.felnyrius.testappjpa.Test.models.SimpleDto;
import io.felnyrius.testappjpa.Test.repositories.SimpleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simple")
public class SimpleController {

    @Autowired
    private final SimpleRespository simpleRepo;

    public SimpleController(SimpleRespository simpleRepo) {
        this.simpleRepo = simpleRepo;
    }

    @GetMapping()
    List<SimpleDto> getSimple(){
        return simpleRepo.findAll();
    }

    @PostMapping()
    SimpleDto addSimple(@RequestBody SimpleDto simpleDto){
        return simpleRepo.save(simpleDto);
    }

    @GetMapping("/more5")
    List<SimpleDto> getAgeMoreThan5(){
        return simpleRepo.getAgeMoreThan5();
    }

    @GetMapping("/text")
    List<SimpleDto> getByText(@RequestParam String text) {
        return simpleRepo.getSimpleByText(text);
    }
}
