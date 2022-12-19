package com.example.demo;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Student")
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "firstName", nullable = false, columnDefinition = "TEXT")
    private String firstName;
    @Column(name = "lastName", nullable = false, columnDefinition = "TEXT")
    private String lastName;

    @Column(name = "email", nullable = false, columnDefinition = "TEXT", unique = true)
    private String email;
    @Column(name = "age", nullable = false)
    private int age;

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
