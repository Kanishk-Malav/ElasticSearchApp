package com.example.course_search_app.service;

import com.example.course_search_app.model.Course;
import com.example.course_search_app.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    
    private final CourseRepository courseRepository;
    
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
    
    public List<Course> saveAllCourses(List<Course> courses) {
        return (List<Course>) courseRepository.saveAll(courses);
    }
    
    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}