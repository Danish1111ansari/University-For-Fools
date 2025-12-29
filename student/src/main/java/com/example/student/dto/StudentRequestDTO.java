package com.example.student.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StudentRequestDTO {


    @NotBlank(message = "Name must not be blank")
    private String name;

    @NotBlank(message = "Email must not be blank")
    private String email;

    @NotNull(message = "Age must not be null")
    @Min(value = 18, message = "Student must be at least 18 years old")
    private int age;


}
