package com.example.demoJunit.controller;

import com.example.demoJunit.dto.CourseDTO;
import com.example.demoJunit.model.Course;
import com.example.demoJunit.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public void createCourse(@RequestBody CourseDTO courseDTO) {
        courseService.addCourse(new Course(courseDTO.getTitle(), courseDTO.getDescription()));
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAll();
    }
}
