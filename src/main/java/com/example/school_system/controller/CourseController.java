package com.example.school_system.controller;

import com.example.school_system.entity.Course;
import com.example.school_system.entity.Student;
import com.example.school_system.service.CourseService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    //list all courses
    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    //create a course
    @PostMapping("/courses")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.addCourse(course), HttpStatus.CREATED);
    }

    //edit course
    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> editCourse(@RequestBody Course course, @PathVariable("id") Long id){
        courseService.editCourse(course, id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    //delete course
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable("id") Long id){
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
