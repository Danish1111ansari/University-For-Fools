package com.example.course.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.dto.CourseResponseDTO;
import com.example.course.exception.CourseNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/v1/courses")
public class CourseController { 

    @GetMapping("/{id}")
   public ResponseEntity<CourseResponseDTO> getCourseById(@PathVariable Long id) {
        // Implementation for retrieving a course by ID
        if(id != 1L) {
           throw new CourseNotFoundException(id);
        } 


        CourseResponseDTO course = new CourseResponseDTO(1L, "Sample Course", true);
        return ResponseEntity.ok(course);
    }
    
    
}
