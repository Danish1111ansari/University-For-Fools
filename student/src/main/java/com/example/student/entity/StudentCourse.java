package com.example.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_courses")
@Getter 
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class StudentCourse {


    @EmbeddedId
    private StudentCourseId id;

    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    @JsonIgnore
private Student student;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    @JsonIgnore
    private Course course;


    @Column(nullable = false)
    private Integer semester;

    @Column(nullable = false)
    private Boolean active = true;


}

