package com.demo.jpa.controller;


import com.demo.jpa.model.Student;
import com.demo.jpa.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping(path = "")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> list = studentService.findAll();
        return new ResponseEntity<>(list, list == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping(path = "/name")
    public ResponseEntity<Student> getByName(@RequestParam String name) {
        Student student = studentService.findByName(name);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping(path = "")
    public ResponseEntity<Student> create(@RequestBody Student studentDto) {
        Student student = studentService.create(studentDto);
        return new ResponseEntity<>(student, student == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        studentService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable int id,
                                    @RequestBody Student studentDto) {
        studentService.update(id, studentDto);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
