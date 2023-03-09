package io.felnyrius.testappjpa.Test.controllers;

import io.felnyrius.testappjpa.Test.models.TestDTO;
import io.felnyrius.testappjpa.Test.repositories.TestRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tests")
public class TestController {

    //Inject tests DAO
    private final TestRepository2 testRepo;

    @Autowired
    public TestController(TestRepository2 testRepo) {
        this.testRepo = testRepo;
    }

    // Expose "/tests" & return list of employees
    @GetMapping()
    public List<TestDTO> getAllTests() {
        return testRepo.findAll();
    }

    // Add mapping for GET /tests/{testId}
    @GetMapping("{testId}")
    public ResponseEntity<Optional<TestDTO>> getTest(@PathVariable(name = "testId") int tId) {

        Optional<TestDTO> testDTO = this.testRepo.findById(tId);
        if (testDTO.isEmpty()) {
            throw new RuntimeException("Test id not found - " + tId);
        }
        return new ResponseEntity<>(testDTO, HttpStatus.OK);
    }

    // Add mapping for POST /tests - add new test
    @PostMapping()
    public ResponseEntity<TestDTO> addTest(@RequestBody TestDTO test) {

        // just in case user pass an id in JSON, set id to 0
        // This is to force a save of new item instead of update

//        test.setId(0);
        Long howMany = this.testRepo.count();
        System.out.println(howMany);
        this.testRepo.save(test);

        return new ResponseEntity<>(test, HttpStatus.CREATED);
    }

    // Add mapping for PUT /tests - update existing test
    @PutMapping()
    public TestDTO updateTest(@RequestBody TestDTO test) {

        this.testRepo.save(test);

        return test;
    }

    // Add mapping for DELETE /tests/{testId} - delete employee
    @DeleteMapping("{testId}")
    public String deleteTest(@PathVariable(name = "testId") int eId) {

        Optional<TestDTO> tempTest = this.testRepo.findById(eId);

        if (tempTest.isEmpty()) {
            throw new RuntimeException("Test id not found - " + eId);
        }

        this.testRepo.deleteById(eId);

        return "Deleted test id - " + eId;

    }
}
