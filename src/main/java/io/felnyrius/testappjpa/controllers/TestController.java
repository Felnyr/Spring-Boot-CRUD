package io.felnyrius.testappjpa.controllers;

import io.felnyrius.testappjpa.models.TestDTO;
import io.felnyrius.testappjpa.repositories.TestRepository2;
import io.felnyrius.testappjpa.repositories.TestRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TestController {

    //Inject tests DAO
    private final TestRepository2 testRepo;

    @Autowired
    public TestController(TestRepository2 testRepo) {
        this.testRepo = testRepo;
    }

    // Expose "/tests" & return list of employees
    @GetMapping("/tests")
    public List<TestDTO> getAllTests() {
        return testRepo.findAll();
    }

    // Add mapping for GET /tests/{testId}
    @GetMapping("/tests/{testId}")
    public Optional<TestDTO> getTest(@PathVariable(name = "testId") int tId) {

        Optional<TestDTO> testDTO = this.testRepo.findById(tId);
        if (testDTO.isEmpty()) {
            throw new RuntimeException("Test id not found - " + tId);
        }

        return testDTO;
    }

    // Add mapping for POST /tests - add new test
    @PostMapping("/tests")
    public TestDTO addTest(@RequestBody TestDTO test) {

        // just in case user pass an id in JSON, set id to 0
        // This is to force a save of new item instead of update

//        test.setId(0);
        Long howMany = this.testRepo.count();
        System.out.println(howMany);
        this.testRepo.save(test);

        return test;
    }

    // Add mapping for PUT /tests - update existing test
    @PutMapping("/tests")
    public TestDTO updateTest(@RequestBody TestDTO test) {

        this.testRepo.save(test);

        return test;
    }

    // Add mapping for DELETE /tests/{testId} - delete employee
    @DeleteMapping("/tests/{testId}")
    public String deleteTest(@PathVariable(name = "testId") int eId) {

        Optional<TestDTO> tempTest = this.testRepo.findById(eId);

        if (tempTest.isEmpty()) {
            throw new RuntimeException("Test id not found - " + eId);
        }

        this.testRepo.deleteById(eId);

        return "Deleted test id - " + eId;

    }
}
