package com.pro.sky.ScoolHogwartsMagic.Model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String color;
    @OneToMany(mappedBy = "faculty")
    private List<Student> students = new ArrayList<>();

}
