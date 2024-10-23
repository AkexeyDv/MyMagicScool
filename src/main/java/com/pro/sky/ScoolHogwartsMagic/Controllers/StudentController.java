package com.pro.sky.ScoolHogwartsMagic.Controllers;

import com.pro.sky.ScoolHogwartsMagic.Model.Student;
import com.pro.sky.ScoolHogwartsMagic.Services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent() {
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @GetMapping("{letter}")
    public ResponseEntity<List<Student>> getStudentWithChar(@RequestParam char letter) {
        return ResponseEntity.ok(studentService.getAllStusentByLetter(letter));
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping
    public Student editStudent(@RequestBody Student student) {
        return studentService.editStudent(student);
    }

}
