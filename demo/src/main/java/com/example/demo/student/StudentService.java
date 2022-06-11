package com.example.demo.student;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }


    public void AddNewStudent(Student student) {
        Optional<Student> studentOptinal =  studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptinal.isPresent()){
            throw new IllegalStateException("Email Taken");
        }
        studentRepository.save(student);
    }


    public void DeleteStudent(long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalStateException("Student with id "+ id + " Doesn't Exist");
        }
        else{
            studentRepository.deleteById(id);
        }
    }

    @Transactional
    public void updateStudent(Long id, String name, String email){
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with id "+ id + " Doesn't Exist"));
        if(name != null && !Objects.equals(student.getName(),name) && name.length() > 0){
            student.setName(name);
        }
        if(email != null && !Objects.equals(student.getEmail(),email) && email.length() > 0){
            Optional<Student> studentOptinal =  studentRepository.findStudentByEmail(email);
            if(studentOptinal.isPresent()){
                throw new IllegalStateException("Email Taken");
            }
            student.setEmail(email);
        }
    }
}
