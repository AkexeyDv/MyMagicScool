package com.pro.sky.ScoolHogwartsMagic.Controllers;

import com.pro.sky.ScoolHogwartsMagic.Model.Student;
import com.pro.sky.ScoolHogwartsMagic.Services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent() {
        logger.info("Запрос на выдачу списка студентов");
        return ResponseEntity.ok(studentService.getAllStudent());
    }


    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        logger.info("Запрос на создание студента");
        return studentService.createStudent(student);
    }


    @PutMapping
    public Student editStudent(@RequestBody Student student) {

        logger.info("Запрос на редактирование студента");
        return studentService.editStudent(student);

    }

    @GetMapping("{letter}")
    public ResponseEntity<List<String>> getStudentWithChar(@RequestParam char letter) {
        logger.info("Запрос на выдачу списка студентов, имена которых начинаются с символа " + letter);
        return ResponseEntity.ok(studentService.getAllStusentByLetter(letter));
    }

    @GetMapping("midage")
    public Double getMidAge() {
        logger.info("Запрос на выдачу среднего возраста студентов");
        return studentService.getMidAgeStudent();
    }
    @GetMapping("/print-parallel")
    public void getStudentNameParallel(){
        studentService.parallelThread();
    }
    @GetMapping("print-synchro-parallel")
    public void getStudentNameSynchroParallel(){
        studentService.parallelThreadSynchron();
    }
}
