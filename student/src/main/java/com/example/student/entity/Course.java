package com.example.student.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "courses",
    indexes = { @Index(name = "idx_course_name", columnList = "name", unique = true   ) }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true, length = 100)
    private String code;

    @NotBlank
    @Column(nullable = false, unique = true, length = 200)  
    private String name;

    @NotBlank
    @Column(length = 1000)
    private String description;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StudentCourse> studentCourses = new HashSet<>();



    
}
