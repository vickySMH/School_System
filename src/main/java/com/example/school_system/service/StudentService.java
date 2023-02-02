package com.example.school_system.service;

import com.example.school_system.entity.Student;
import com.example.school_system.entity.Teacher;
import com.example.school_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    //list all student
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    //create a student
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    //edit student
    public Student editStudent(Student student, Long id){
        student.setId(id);
        return studentRepository.save(student);

    }

    //delete student
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
