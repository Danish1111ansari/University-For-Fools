package com.example.student.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String street;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String city;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String state;


    @NotBlank
    @Column(nullable = false, length = 50)
    private String country;

    @NotBlank
    @Column(nullable = false, length = 20)
    private String zipCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id",
        nullable = false,
        unique = true
    )
    
    private Student student;

    
}
