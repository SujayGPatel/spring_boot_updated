package com.demo.jpa.service;

import com.demo.jpa.model.Student;
import com.demo.jpa.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findByName(String name) {
        return  studentRepository.findByName(name);
    }

    public Student create(Student studentEntity){
        return studentRepository.save(studentEntity);
    }

    public void delete(int id) {
        Student student = studentRepository.getById(id);
        studentRepository.delete(student);
    }

    public void update(int id, Student studentDto) {
        Student student = studentRepository.getById(id);
        student.setName(studentDto.getName());
        studentRepository.save(student);
    }



}
