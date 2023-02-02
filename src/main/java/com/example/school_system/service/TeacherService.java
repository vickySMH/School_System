package com.example.school_system.service;

import com.example.school_system.entity.Teacher;
import com.example.school_system.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    //list all teachers
    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public List<Teacher> teachersByName(String name){
        return teacherRepository.findTeachersByName(name);
    }

    //find teacher by id
    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    //add teacher
    public Teacher addTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    //edit teacher
    public Teacher editTeacher(Teacher teacher, Long id){
        if(teacherRepository.findById(id).isPresent()){
            teacher.setId(id);
            return teacherRepository.save(teacher);
        }
        return null;
    }

    //delete teacher
    public void deleteTeacher(Long id){
        teacherRepository.deleteById(id);
    }
}
