package com.pro.sky.ScoolHogwartsMagic.Controllers;

import com.pro.sky.ScoolHogwartsMagic.Model.Faculty;
import com.pro.sky.ScoolHogwartsMagic.Model.Student;
import com.pro.sky.ScoolHogwartsMagic.Services.FacultyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;
    private static final Logger logger= LoggerFactory.getLogger(FacultyController.class);

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty){
        logger.info("Запрос на создание факультета");
        return facultyService.createFaculty(faculty);
    }
    @GetMapping
    public ResponseEntity<List<Faculty>> findFacultyByColor(@RequestParam String color){
        logger.info("Запрос факультета на цвет: "+color);
        return ResponseEntity.ok(facultyService.getFacultyByColor(color));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Faculty>> getAllFaculty(){
        logger.info("Запрос на выдачу всего списка факультетов");
        return ResponseEntity.ok(facultyService.getAllFaculty());
    }
    @GetMapping("{id}")
    public ResponseEntity<List<Student>> getStudentByFaculty(@RequestParam Long id){
        logger.info("Запрос на выдачу списка студентов факультета");
        return ResponseEntity.ok(facultyService.getStudentByFaculty(id));
    }

    @DeleteMapping
    public ResponseEntity<Faculty> delFaculty(@RequestParam Long id){
        logger.info("Запрос на удаление факультета");
        return ResponseEntity.ok(facultyService.deleteFaculty(id));
    }
    @GetMapping("/longfaculty")
    public String getMaxLenNameToFaculty(){
        logger.info("Запрос на выдачу самого длинного названия факультета");
        return facultyService.getMaxLongNameToFaculty();
    }
}
