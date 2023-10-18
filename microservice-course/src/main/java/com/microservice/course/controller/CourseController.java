package com.microservice.course.controller;

import com.microservice.course.entity.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Course course) {
        courseService.save(course);
    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Course>> findAllStudents() {
        return ResponseEntity.ok(courseService.findAll());
    }


    @GetMapping("search/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Course> findById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.findById(id));
    }


    @GetMapping("search-student/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<StudentByCourseResponse> findStudentByIdCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(courseService.findStudentByIdCourse(courseId));
    }

}
