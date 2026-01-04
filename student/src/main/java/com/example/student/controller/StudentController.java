package com.example.student.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.student.dto.StudentRequestDTO;
import com.example.student.response.ApiResponse;
import com.example.student.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor

public class StudentController {

    private final StudentService studentService;


    @PostMapping
    public ResponseEntity<ApiResponse<StudentRequestDTO>> createStudent(@RequestBody @Valid StudentRequestDTO studentRequestDTO) {
        // Implementation for creating a student
        StudentRequestDTO savedStudent = studentService.createStudent(studentRequestDTO);


        ApiResponse<StudentRequestDTO> response = ApiResponse.success(
            HttpStatus.CREATED.value(),
            "Student created successfully",
            savedStudent,
            "/api/v1/students"
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    

      }
}