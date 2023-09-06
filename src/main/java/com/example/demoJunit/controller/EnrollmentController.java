package com.example.demoJunit.controller;

import com.example.demoJunit.dto.EnrollmentDTO;
import com.example.demoJunit.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public void enrollStudent(@RequestBody EnrollmentDTO enrollmentDTO) {
        enrollmentService.enrollStudent(enrollmentDTO.getStudentId(), enrollmentDTO.getCourseId());
    }
}
