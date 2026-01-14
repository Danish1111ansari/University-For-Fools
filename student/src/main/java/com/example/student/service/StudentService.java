package com.example.student.service;

import org.springframework.stereotype.Service;

import com.example.student.client.CourseClient;
import com.example.student.dto.CourseResponseDTO;
import com.example.student.dto.StudentRequestDTO;
import com.example.student.entity.Student;
import com.example.student.entity.StudentCourse;
import com.example.student.repository.CourseRepository;
import com.example.student.repository.StudentRepository;
import com.example.student.entity.Course;
import com.example.student.entity.StudentCourseId;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional

public class StudentService {

    private final CourseClient courseClient;

    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    public StudentService(CourseClient courseClient, StudentRepository studentRepository,
            CourseRepository courseRepository) {
        this.courseClient = courseClient;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }



    public Student createStudent(Student  student) {
       if(student.getAddress()!=null){
        student.getAddress().setStudent(student);
       }
       return studentRepository.save(student);  
    }

public Student enrollCourse(Long studentId, Long courseId) {

    Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student not found"));

    Course course = courseRepository.findById(courseId)
            .orElseThrow(() -> new RuntimeException("Course not found"));

    StudentCourse studentCourse = StudentCourse.builder()
            .student(student)
            .course(course)
            .semester(1)
            .active(true)
            .build();

    // maintain both sides
    student.getCourses().add(studentCourse);

    // save owning side via cascade
    return studentRepository.save(student);
}



    public Student getStudent(Long id){
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

}
