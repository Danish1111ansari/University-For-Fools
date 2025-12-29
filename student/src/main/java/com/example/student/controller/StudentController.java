package com.example.student.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.student.dto.StudentRequestDTO;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/v1/students")

public class StudentController {


    @PostMapping
    
    public ResponseEntity<?> createStudent(@RequestBody @Valid StudentRequestDTO studentRequestDTO) {
        // Implementation for creating a student
        return ResponseEntity.status(HttpStatus.CREATED).body(studentRequestDTO);
    }
    

}
