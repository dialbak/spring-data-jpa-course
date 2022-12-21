package com.example.demo;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Enrolment")
@Table(name = "enrolment")
public class Enrolment {

    @Id
    @SequenceGenerator(
            name = "enrolment_sequence",
            sequenceName = "enrolment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "enrolment_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "enrolment_students",
            joinColumns = @JoinColumn("enrolment_id"),
            inverseJoinColumns = @JoinColumn("student_id")
    )
    private List<Student> students;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP NOT NULL"
    )
    private LocalDateTime createdAt;

}
