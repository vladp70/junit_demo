package com.example.demoJunit.controller;

import com.example.demoJunit.dto.StudentDTO;
import com.example.demoJunit.model.Student;
import com.example.demoJunit.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public void createStudent(@RequestBody StudentDTO studentDTO) {
        studentService.addStudent(new Student(studentDTO.getName(), studentDTO.getEmail()));
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}