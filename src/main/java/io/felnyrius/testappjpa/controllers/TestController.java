package io.felnyrius.testappjpa.controllers;

import io.felnyrius.testappjpa.models.TestDTO;
import io.felnyrius.testappjpa.repositories.TestRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    //Inject tests DAO
    private final TestRepositoryImpl testRepo;

    @Autowired
    public TestController(TestRepositoryImpl testRepo) {
        this.testRepo = testRepo;
    }

    // Expose "/tests" & return list of employees
    @GetMapping("/tests")
    public List<TestDTO> getAllTests() {
        return testRepo.findAll();
    }

    // Add mapping for GET /tests/{testId}
    @GetMapping("/tests/{testId}")
    public TestDTO getTest(@PathVariable(name = "testId") int tId) {

        TestDTO testDTO = this.testRepo.findById(tId);

        if (testDTO == null) {
            throw new RuntimeException("Test id not found - " + tId);
        }

        return testDTO;
    }

    // Add mapping for POST /tests - add new test
    @PostMapping("/tests")
    public TestDTO addTest(@RequestBody TestDTO test) {

        // just in case user pass an id in JSON, set id to 0
        // This is to force a save of new item instead of update

        test.setId(0);

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

        TestDTO tempTest = this.testRepo.findById(eId);
        System.out.println("Found");
        System.out.println(tempTest);

        if (tempTest == null) {
            throw new RuntimeException("Test id not found - " + eId);
        }

        this.testRepo.deleteById(eId);

        return "Deleted test id - " + eId;

    }
}
