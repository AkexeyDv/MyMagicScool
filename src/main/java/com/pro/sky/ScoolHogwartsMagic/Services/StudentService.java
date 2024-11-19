package com.pro.sky.ScoolHogwartsMagic.Services;

import com.pro.sky.ScoolHogwartsMagic.Exception.AppException;
import com.pro.sky.ScoolHogwartsMagic.Model.Faculty;
import com.pro.sky.ScoolHogwartsMagic.Model.Student;
import com.pro.sky.ScoolHogwartsMagic.Repositorys.FacultyRepository;
import com.pro.sky.ScoolHogwartsMagic.Repositorys.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final static Logger logger = LoggerFactory.getLogger(StudentService.class);
    @Autowired
    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;
    private Object objectForSinchron=new Object();
    private final Integer minCountStudentName=6;

    @Autowired
    public StudentService(StudentRepository studentRepository, FacultyRepository facultyRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
    }

    public Student createStudent(Student student) {
        logger.info("Запущен метод создания студента с id: " + student.getId());
        if (student == null) {
            logger.error("Передан пустой объект student");
            throw new AppException("Переданный объект содержит null");
        }
        if (studentRepository.findById(student.getId()).isPresent()) {
            logger.error("Передан объект student с уже существующим id");
            throw new AppException("Студент с id " + student.getId() + " уже существует");
        }
        Optional<Faculty> facultyStudentOptional = facultyRepository
                .findById(student.getFaculty().getId());
        if (facultyStudentOptional.isEmpty()) {
            logger.error("Попытка создать студента в несуществующем факультете с id "
                    + facultyStudentOptional.get().getId());
            throw new AppException("Факультет с id " + facultyStudentOptional.get().getId()
                    + " указанный при создании студента не существует");
        }
        return studentRepository.save(student);
    }

    public Student editStudent(Student student) {
        logger.info("Запущен метод редактирования студента");
        if (student == null) {
            logger.error("Передан пустой объект student");
            throw new AppException("Переданный объект содержит null");
        }

        Student editingStudent = studentRepository.findById(student.getId()).get();
        editingStudent.setName(student.getName());
        editingStudent.setAge(student.getAge());
        return studentRepository.save(editingStudent);

    }


    public List<Student> getAllStudent() {
        logger.info("Запущен метод получения всех студентов");
        return studentRepository.findAll();
    }

    public List<String> getAllStusentByLetter(char letter) {
        logger.info("Запущен метод получения имен студентов, начинающихся с символа " + letter);
        String startChar = letter + "";
        List<Student> students = studentRepository.findByNameStartingWith(startChar);
        return students.stream().map(Student::getName)
                .filter(name -> name.charAt(0) == letter)
                .sorted().toList();
    }

    public Double getMidAgeStudent() {
        logger.info("Запущен метод получениясреднего возраста студентов");
        return studentRepository.findAverageAge();
    }

    private void printToConsole(String name){
        System.out.println(name);
    }
    private void printToConsoleSynchron(String name){
        synchronized (objectForSinchron){
            System.out.println(name);
        }

    }

    public void parallelThread(){
        List<String> name=getAllStudent().stream()
                .map(Student::getName)
                .toList();
        if(name.size()<minCountStudentName) {
            printToConsole(name.get(0));
            printToConsole(name.get(1));
            Thread thread1 = new Thread(() -> {
                printToConsole(name.get(2));
                printToConsole(name.get(3));
            });
            Thread thread2 = new Thread(() -> {
                printToConsole(name.get(4));
                printToConsole(name.get(5));
            });
            thread1.start();
            thread2.start();
        }
    }
    public void parallelThreadSynchron(){
        List<String> name=getAllStudent().stream()
                .map(Student::getName)
                .toList();
        if(name.size()<minCountStudentName) {
            printToConsoleSynchron(name.get(0));
            printToConsoleSynchron(name.get(1));
            Thread thread1 = new Thread(() -> {
                printToConsoleSynchron(name.get(2));
                printToConsoleSynchron(name.get(3));
            });
            Thread thread2 = new Thread(() -> {
                printToConsoleSynchron(name.get(4));
                printToConsoleSynchron(name.get(5));
            });
            thread1.start();
            thread2.start();
        }
    }


}
