package com.pro.sky.ScoolHogwartsMagic.Repositorys;

import com.pro.sky.ScoolHogwartsMagic.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
