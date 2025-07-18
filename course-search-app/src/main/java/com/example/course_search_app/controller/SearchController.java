package com.example.course_search_app.controller;

import com.example.course_search_app.dto.SearchRequest;
import com.example.course_search_app.dto.SearchResponse;
import com.example.course_search_app.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class SearchController {
    
    private final SearchService searchService;
    
    @PostMapping
    public SearchResponse searchCourses(@RequestBody SearchRequest request) {
        return searchService.searchCourses(request);
    }
    
    @GetMapping
    public SearchResponse searchCourses(
        @RequestParam(required = false) String query,
        @RequestParam(required = false) String category,
        @RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "10") Integer size) {
        
        SearchRequest request = SearchRequest.builder()
            .query(query)
            .category(category)
            .page(page)
            .size(size)
            .build();
            
        return searchService.searchCourses(request);
    }
}