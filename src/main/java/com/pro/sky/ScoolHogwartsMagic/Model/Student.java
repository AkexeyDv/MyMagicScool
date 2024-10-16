package com.pro.sky.ScoolHogwartsMagic.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private Long id;
    private String name;
    private int age;

}
