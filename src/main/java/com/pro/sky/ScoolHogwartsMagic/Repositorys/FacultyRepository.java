package com.pro.sky.ScoolHogwartsMagic.Repositorys;

import com.pro.sky.ScoolHogwartsMagic.Model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {

    List<Faculty> findAllByColor(String color);
    @Query(value = "SELECT * FROM faculty ORDER BY LENGTH(faculty.name) DESC LIMIT 1",nativeQuery = true)
    Faculty findMaxLenName();

}
