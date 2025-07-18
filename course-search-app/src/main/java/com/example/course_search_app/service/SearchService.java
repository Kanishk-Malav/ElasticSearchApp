package com.example.course_search_app.service;

import com.example.course_search_app.dto.SearchRequest;
import com.example.course_search_app.dto.SearchResponse;
import com.example.course_search_app.model.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final ElasticsearchOperations elasticsearchOperations;

    public SearchResponse searchCourses(SearchRequest request) {
        Criteria criteria = new Criteria();

        if (request.getQuery() != null && !request.getQuery().isBlank()) {
            Criteria titleCriteria = new Criteria("title").contains(request.getQuery());
Criteria descCriteria = new Criteria("description").contains(request.getQuery());
criteria = criteria.and(titleCriteria).or(descCriteria);
        }

        if (request.getCategory() != null) {
            criteria = criteria.and("category").is(request.getCategory());
        }

        if (request.getType() != null) {
            criteria = criteria.and("type").is(request.getType());
        }

        if (request.getMinAge() != null) {
            criteria = criteria.and("minAge").greaterThanEqual(request.getMinAge());
        }

        if (request.getMaxAge() != null) {
            criteria = criteria.and("maxAge").lessThanEqual(request.getMaxAge());
        }

        if (request.getMinPrice() != null) {
            criteria = criteria.and("price").greaterThanEqual(request.getMinPrice());
        }

        if (request.getMaxPrice() != null) {
            criteria = criteria.and("price").lessThanEqual(request.getMaxPrice());
        }

        if (request.getStartDate() != null) {
            criteria = criteria.and("nextSessionDate").greaterThanEqual(request.getStartDate());
        }

        PageRequest pageRequest = PageRequest.of(request.getPage(), request.getSize());

        CriteriaQuery query = new CriteriaQuery(criteria, pageRequest);

        SearchHits<Course> hits = elasticsearchOperations.search(query, Course.class);

        List<Course> courses = hits.getSearchHits().stream()
            .map(SearchHit::getContent)
            .collect(Collectors.toList());

        return SearchResponse.builder()
            .total(hits.getTotalHits())
            .page(request.getPage())
            .size(request.getSize())
            .courses(courses)
            .build();
    }
}
