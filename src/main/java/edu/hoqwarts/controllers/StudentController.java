package edu.hoqwarts.controllers;

import edu.hoqwarts.services.StudentServices;
import edu.hoqwarts.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentServices studentServices;

    @Autowired
    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentServices.getStudents();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentServices.createStudent(student);
    }


    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentServices.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentServices.deleteStudent(id);
    }
}
