package com.pro.sky.ScoolHogwartsMagic.Services;

import com.pro.sky.ScoolHogwartsMagic.Model.Student;
import com.pro.sky.ScoolHogwartsMagic.Repositorys.FacultyRepository;
import com.pro.sky.ScoolHogwartsMagic.Repositorys.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;


@SpringBootTest
class StudentServiceTest {

    @Mock
    private FacultyRepository mockFacultyRepository = mock(FacultyRepository.class);
    @Mock
    private StudentRepository mockStudentRepository = mock(StudentRepository.class);

    @Test
    void parallelThread() {
        StudentService out = new StudentService(mockStudentRepository, mockFacultyRepository);
        Student stud1 = new Student();
        List<Student> studentList = new ArrayList<>();
        Mockito.when(mockStudentRepository.findAll()).thenReturn(studentList);
        Assertions.assertDoesNotThrow(out::parallelThread);


    }
    @Test
    void parallelThreadSynchron() {
        StudentService out = new StudentService(mockStudentRepository, mockFacultyRepository);
        Student stud1 = new Student();
        List<Student> studentList = new ArrayList<>();
        Mockito.when(mockStudentRepository.findAll()).thenReturn(studentList);
        Assertions.assertDoesNotThrow(out::parallelThreadSynchron);
    }
}