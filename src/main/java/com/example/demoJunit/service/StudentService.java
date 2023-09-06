package com.example.demoJunit.service;

import com.example.demoJunit.model.Student;
import com.example.demoJunit.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(Student c){
        studentRepository.save(c);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
