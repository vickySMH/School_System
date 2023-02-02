package com.example.school_system.controller;

import com.example.school_system.entity.Student;
import com.example.school_system.entity.Teacher;
import com.example.school_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    //list all students
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    //create a student
    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }

    //edit student
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> editStudent(@RequestBody Student student, @PathVariable("id") Long id){
        studentService.editStudent(student, id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    //delete student
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
