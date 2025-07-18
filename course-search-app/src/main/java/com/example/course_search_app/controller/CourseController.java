package com.example.course_search_app.controller;

import com.example.course_search_app.model.Course;
import com.example.course_search_app.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {
    
    private final CourseService courseService;
    
    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }
    
    @PostMapping("/bulk")
    public List<Course> createCourses(@RequestBody List<Course> courses) {
        return courseService.saveAllCourses(courses);
    }
    
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }
}