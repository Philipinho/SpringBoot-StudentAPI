package com.litesoftwares.studentapi.controller;

import com.litesoftwares.studentapi.exception.StudentNotFoundException;
import com.litesoftwares.studentapi.model.Student;
import com.litesoftwares.studentapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> allStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student findById(@PathVariable("id") long id){
        Optional<Student> student = studentRepository.findById(id);
        if (!student.isPresent()){
            throw new StudentNotFoundException("Student not found");
        }
        return student.get();
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        studentRepository.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") long id){
        Optional<Student> savedStudent = studentRepository.findById(id);
        if (!savedStudent.isPresent()){
            throw new StudentNotFoundException("Student Not Found");
        }
        return studentRepository.save(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") long id){
        Optional<Student> student = studentRepository.findById(id);
        if (!student.isPresent()){
            throw new StudentNotFoundException("Student not found");
        }
        studentRepository.deleteById(id);
    }
}
