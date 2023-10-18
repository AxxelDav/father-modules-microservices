package com.microservice.student.controller;

import com.microservice.student.entity.Student;
import com.microservice.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student) {
        studentService.save(student);
    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Student>> findAllStudents() {
        return ResponseEntity.ok(studentService.findAll());
    }


    @GetMapping("search/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping("search-by-course/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Student>> findAllStudentsByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok(studentService.findAllStudentsByCourseId(courseId));
    }

}
