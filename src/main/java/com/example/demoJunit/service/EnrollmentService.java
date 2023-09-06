package com.example.demoJunit.service;

import com.example.demoJunit.model.Course;
import com.example.demoJunit.model.Enrollment;
import com.example.demoJunit.model.Student;
import com.example.demoJunit.repository.CourseRepository;
import com.example.demoJunit.repository.EnrollmentRepository;
import com.example.demoJunit.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Enrollment enrollStudent(Integer studentId, Integer courseId) {
        // Retrieve student and course entities
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);

        // Create and save enrollment
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(new Date());

        return enrollmentRepository.save(enrollment);
    }

}
