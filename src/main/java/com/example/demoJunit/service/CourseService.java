package com.example.demoJunit.service;

import com.example.demoJunit.model.Course;
import com.example.demoJunit.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public void addCourse(Course c){
        courseRepository.save(c);
    }

    public List<Course> getAll() {
        return courseRepository.findAll();
    }
}
