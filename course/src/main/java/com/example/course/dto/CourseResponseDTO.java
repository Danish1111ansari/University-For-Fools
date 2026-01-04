package com.example.course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CourseResponseDTO {

    private Long id;
    private String title;
    private boolean active;
    
}
