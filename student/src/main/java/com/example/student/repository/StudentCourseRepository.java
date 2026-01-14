package com.example.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student.entity.StudentCourse;
import com.example.student.entity.StudentCourseId;

public interface StudentCourseRepository  extends JpaRepository<StudentCourse, StudentCourseId> { 
    
}
