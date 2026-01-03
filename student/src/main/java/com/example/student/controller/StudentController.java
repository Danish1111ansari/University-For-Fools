package com.example.student.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.student.dto.StudentRequestDTO;
import com.example.student.response.ApiResponse;

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
    public ResponseEntity<ApiResponse<StudentRequestDTO>> createStudent(@RequestBody @Valid StudentRequestDTO studentRequestDTO) {
        // Implementation for creating a student
        ApiResponse<StudentRequestDTO> response = ApiResponse.success(
            HttpStatus.CREATED.value(),
            "Student created successfully",
            studentRequestDTO,
            "/api/v1/students"
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    

      }
}