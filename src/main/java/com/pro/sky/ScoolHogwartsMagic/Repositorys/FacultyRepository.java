package com.pro.sky.ScoolHogwartsMagic.Repositorys;

import com.pro.sky.ScoolHogwartsMagic.Model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {

    List<Faculty> findAllByColor(String color);
}
