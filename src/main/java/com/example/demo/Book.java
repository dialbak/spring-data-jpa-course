package com.example.demo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Book")
@Table(name = "book")
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "student_id_fk")
    )
    private Student student;

    @Column(
            name = "book_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String book_name;


    @Column(
            name = "created_At",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private LocalDateTime createdAt;

    public Book() {
    }

    public Book(Student student, String book_name, LocalDateTime createdAt) {
        this.student = student;
        this.book_name = book_name;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
