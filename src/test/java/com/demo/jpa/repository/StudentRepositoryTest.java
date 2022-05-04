package com.demo.jpa.repository;

import com.demo.jpa.model.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@EntityScan(basePackageClasses = Student.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveStudentTest(){

        Student student = getStudent();
        studentRepository.save(student);

        Assertions.assertThat(student.getId()).isGreaterThan(0);
    }



    @Test
    @Order(4)
    public void should_find_single_student() {
        Student result = studentRepository.findById(101).get();
        assertEquals(1848095, result.getId());
    }

    @Test
    @Order(5)
    public void should_find_all_students() {
        Iterable<Student> students = studentRepository.findAll();
        assertThat(students).hasSizeGreaterThan(0);
    }

    private Student getStudent() {
        Student student = new Student();
        student.setId(101);
        student.setName("ruchi");
        return student;
    }



}
