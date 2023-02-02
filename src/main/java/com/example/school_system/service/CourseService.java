package com.example.school_system.service;

import com.example.school_system.entity.Course;
import com.example.school_system.entity.Student;
import com.example.school_system.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    //list all courses
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    //get course by id
    public Optional<Course> getCourseById(Long id){
        return courseRepository.findById(id);
    }

    //create a course
    public Course addCourse(Course course){
        return courseRepository.save(course);
    }

    //edit a course
    public Course editCourse(Course course, Long id){
        course.setId(id);
        return courseRepository.save(course);

    }

    //delete course
    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }



}
