package com.example.school_system.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String emailAddress;

    @OneToMany
    @JsonBackReference
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Set<Course> courses = new HashSet<>();

}
