package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student Ibrahim =  new Student(
                    "Ibrahim",
                    "Himahany1368@gmail.com",
                    LocalDate.of(1999, 03, 23));


            Student Karim = new Student(
                    "Karim",
                    "KarimMohamed1368@gmail.com",
                    LocalDate.of(1999, 04, 07));
            repository.saveAll(
                    List.of(Ibrahim,Karim)
            );
        };
    }

}
