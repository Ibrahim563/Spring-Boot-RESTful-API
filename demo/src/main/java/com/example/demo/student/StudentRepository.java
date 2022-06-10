package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/*
*
* Interface Responsible for Data Access Layer
*
* */
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {



}
