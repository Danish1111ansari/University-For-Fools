package com.example.student.service;

import org.springframework.stereotype.Service;

import com.example.student.client.CourseClient;
import com.example.student.dto.CourseResponseDTO;
import com.example.student.dto.StudentRequestDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class StudentService {

    private final CourseClient courseClient;

    public StudentRequestDTO createStudent(StudentRequestDTO studentRequestDTO) {
        // Fetch course details from Course Service
       CourseResponseDTO course = courseClient.getCourseById(1L);

        // You can add additional logic here if needed

        return studentRequestDTO;
    }
    
}
