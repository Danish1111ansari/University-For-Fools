import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Create student
    @PostMapping
    public ResponseEntity<Student> createStudent(
            @RequestBody Student student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    // Enroll student into course
  @PostMapping("/{studentId}/courses/{courseId}")
public ResponseEntity<Student> enrollCourse(
        @PathVariable Long studentId,
        @PathVariable Long courseId) {

    Student student = studentService.enrollCourse(studentId, courseId);

    return ResponseEntity.ok(student);
}

    // Get student
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudent(id));
    }
}
