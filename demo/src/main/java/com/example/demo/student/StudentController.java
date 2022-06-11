package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService Studentservice;

    @Autowired
    public StudentController(StudentService studentservice) {
        Studentservice = studentservice;
    }

    @GetMapping
    public List<Student> getStudents() {
        return Studentservice.getStudents();
    }

    @PostMapping
    public void AddNewStudent(@RequestBody Student student) {
        Studentservice.AddNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void DeleteStudent(@PathVariable("studentId") long StudentId) {
        Studentservice.DeleteStudent(StudentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long StudentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        Studentservice.updateStudent(StudentId, name, email);
    }
}
