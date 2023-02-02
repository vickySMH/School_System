package com.example.school_system.repository;

import com.example.school_system.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

//    @Query("select teacher from Teacher teacher where teacher.name like %:name%")
//    public Teacher findTeachersByName(String name);

    public List<Teacher> findTeachersByName(String name);
}
