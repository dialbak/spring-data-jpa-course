package com.example.demo;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository,
            StudentIdCardRepository studentIdCardRepository,
            BookRepository bookRepository) {
        return args -> {

            Faker faker = new Faker();




            // studentRepository.deleteById(1L);
            // generateRandomStudents(studentRepository);
            // sorting(studentRepository);
            // paginationExample(studentRepository);
        };
    }

    private void generateRandomStudents(StudentRepository studentRepository) {
        Faker faker = new Faker();
        for (int i = 0; i < 20; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@amigoscode.edu", firstName, lastName);
            Student student = new Student(
                    firstName,
                    lastName,
                    email,
                    faker.number().numberBetween(17, 55));
            studentRepository.save(student);
        }
    }

    private static void paginationExample(StudentRepository studentRepository) {
        PageRequest pageRequest = PageRequest.of(
                0,
                5,
                Sort.by("firstName").ascending());
        Page<Student> page = studentRepository.findAll(pageRequest);
        System.out.println("page = " + page);
    }

    private void sorting(StudentRepository studentRepository) {
        Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
        studentRepository
                .findAll(sort)
                .forEach(
                        student -> System.out.println(student.getFirstName())
                );
    }

}
