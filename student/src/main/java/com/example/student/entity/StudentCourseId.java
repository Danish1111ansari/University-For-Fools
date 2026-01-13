package com.example.student.entity;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode



public class StudentCourseId  implements Serializable{

    private Long studentId;
    private Long courseId;
    
}
