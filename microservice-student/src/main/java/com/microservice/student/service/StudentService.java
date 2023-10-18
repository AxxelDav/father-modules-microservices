package com.microservice.student.service;

import com.microservice.student.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(Long id);

    void save(Student student);

    List<Student> findAllStudentsByCourseId(Long courseId);

}
