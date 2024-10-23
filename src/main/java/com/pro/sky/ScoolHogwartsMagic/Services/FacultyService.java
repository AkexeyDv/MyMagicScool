package com.pro.sky.ScoolHogwartsMagic.Services;

import com.pro.sky.ScoolHogwartsMagic.Exception.AppException;
import com.pro.sky.ScoolHogwartsMagic.Model.Faculty;
import com.pro.sky.ScoolHogwartsMagic.Model.Student;
import com.pro.sky.ScoolHogwartsMagic.Repositorys.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;

@Service

public class FacultyService {
    private final FacultyRepository facultyRepository;
    private static final Logger logger = LoggerFactory.getLogger(FacultyService.class);

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        logger.info("Запущен сервис факультета");
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        logger.info("Запущен метод создания факультета " + faculty.toString());
        if (facultyRepository.findById(faculty.getId()).isPresent()) {
            throw new AppException("Факультет с таким Id уже существует");
        }
        return facultyRepository.save(faculty);
    }

    public List<Faculty> getFacultyByColor(String color) {
        logger.info("Запущен метод поиска факультета по цвету");
        List<Faculty> findColor = facultyRepository.findAllByColor(color);
        System.out.println(findColor.toString());
        return findColor;
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    public Faculty deleteFaculty(Long id) {
        logger.info("Запуск метода удаления факультета по id: " + id);
        if (facultyRepository.findById(id).isEmpty()) {
            throw new AppException("Нет факультета с id: " + id);
        }
        Faculty delFaculty = facultyRepository.findById(id).get();
        facultyRepository.delete(delFaculty);
        return delFaculty;
    }

    public List<Student> getStudentByFaculty(Long id){
        logger.info("Запущен метод вызова списка студентов факультета с id: "+id);
        return facultyRepository.findById(id).get().getStudents();
    }


}


