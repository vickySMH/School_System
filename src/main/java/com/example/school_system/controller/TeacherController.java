package com.example.school_system.controller;

import com.example.school_system.entity.Teacher;
import com.example.school_system.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    //list all teachers
    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    //find teacher by name
    @GetMapping("/teachers/{name}")
    public ResponseEntity<List<Teacher>> getTeachersByName(@PathVariable("name") String name){
        return new ResponseEntity<>(teacherService.teachersByName(name), HttpStatus.OK);
    }

    //find teacher by id
    @GetMapping("/teachers/{id}")
    public Optional<Teacher> getTeacherById(@PathVariable("id") Long id){
        return teacherService.getTeacherById(id);
    }

    //add teacher
    @PostMapping("/teachers")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher){
        return new ResponseEntity<>(teacherService.addTeacher(teacher), HttpStatus.CREATED);
    }

    //edit teacher
    @PutMapping("/teachers/{id}")
    public ResponseEntity<Teacher> editTeacher(@RequestBody Teacher teacher, @PathVariable("id") Long id){
        if(teacherService.editTeacher(teacher, id)!= null){;
            teacherService.editTeacher(teacher, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //delete teacher
    @DeleteMapping("/teachers/{id}")
    public ResponseEntity<Teacher> deleteTeacher(@PathVariable("id") Long id){
        if(teacherService.getTeacherById(id).isPresent()){
            teacherService.deleteTeacher(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
