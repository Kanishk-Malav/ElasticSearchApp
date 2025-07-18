package com.example.course_search_app.dto;

import java.time.Instant;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchRequest {

    // Full-text search
    private String query;

    // Exact filters
    private String category;
    private String type;

    // Range filters
    private Integer minAge;
    private Integer maxAge;
    private Double minPrice;
    private Double maxPrice;

    // Date filter
    private Instant startDate;

    // Pagination
    private int page = 0;
    private int size = 10;

    // Sorting
    private String sortBy = "nextSessionDate";   // default field to sort by
    private String sortDirection = "asc";        // asc or desc
}
