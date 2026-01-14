package com.example.student.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "students" , indexes = { @Index(name = "idx_student_email", columnList = "email", unique = true   ) })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String firstName;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String lastName;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private boolean active = true;

    @OneToOne(
    mappedBy = "student",
    cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,
    optional = false
    )   
    private Address address;


@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
@JsonIgnore
private Set<StudentCourse> courses = new HashSet<>();





    
}
