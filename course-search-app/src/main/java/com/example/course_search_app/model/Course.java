package com.example.course_search_app.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "courses")
public class Course {
    @Id
    private String id;
    @Field(type = FieldType.Keyword)
private String category;

@Field(type = FieldType.Keyword)
private String type;

@Field(type = FieldType.Keyword)
private String gradeRange;

@Field(type = FieldType.Integer)
private Integer minAge;

@Field(type = FieldType.Integer)
private Integer maxAge;

@Field(type = FieldType.Double)
private Double price;

@Field(type = FieldType.Date)
private Instant nextSessionDate;

}