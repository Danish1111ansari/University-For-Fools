package com.example.student.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.student.dto.CourseResponseDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor


public class CourseClient {
    
    private final WebClient webClient;
    private static final String COURSE_SERVICE_URL = "http://course-service:8080/api/v1/courses";

    public CourseResponseDTO getCourseById(Long courseId) {
        return webClient.get()
                .uri(COURSE_SERVICE_URL + courseId)
                .retrieve()
                .bodyToMono(CourseResponseDTO.class)
                .block();
    }
}
