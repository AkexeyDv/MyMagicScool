package com.pro.sky.ScoolHogwartsMagic.Repositorys;

import com.pro.sky.ScoolHogwartsMagic.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByNameStartingWith(String letter);
    @Query(value = "SELECT AVG(student.age) FROM student",nativeQuery = true)
    Double findAverageAge();
}
