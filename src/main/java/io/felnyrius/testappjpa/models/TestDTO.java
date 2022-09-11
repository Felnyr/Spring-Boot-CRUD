package io.felnyrius.testappjpa.models;

import javax.persistence.*;

@Entity
@Table(name = "tests")
public class TestDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    // Define constructors (empty and params)
    public TestDTO() {

    }

    public TestDTO(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Define Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // to string generate
    @Override
    public String toString() {
        return "TestDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
