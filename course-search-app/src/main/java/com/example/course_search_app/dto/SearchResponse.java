package com.example.course_search_app.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

import com.example.course_search_app.model.Course;

@Data
@Builder
public class SearchResponse {
    protected Long total;
    protected Integer page;
    protected Integer size;
    protected List <Course> courses;
}