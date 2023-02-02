package com.example.school_system.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Date startDate;
    private Date endDate;
    private int ectsPoints;
    private int maxStudents;

    @ManyToOne
    private Teacher teacher;
    @ManyToOne
    private Student student;
}
