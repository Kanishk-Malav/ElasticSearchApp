package com.example.course_search_app.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.course_search_app.model.Course;

@Repository
public interface CourseRepository extends ElasticsearchRepository<Course, String> {
}