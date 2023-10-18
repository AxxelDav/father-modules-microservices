package com.microservice.course.service.impl;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDto;
import com.microservice.course.entity.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.persistence.CourseRepository;
import com.microservice.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentClient studentClient;


    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id)
                                .orElseThrow();
    }

    @Override
    public void save(Course student) {
        courseRepository.save(student);
    }


    @Override
    public StudentByCourseResponse findStudentByIdCourse(Long courseId) {

        Course course = courseRepository.findById(courseId)
                                        .orElse(new Course());

        List<StudentDto> studentDtoList = studentClient.findAllStudentsByCourseId(courseId);

        return StudentByCourseResponse.builder()
                                      .courseName(course.getName())
                                      .teacher(course.getTeacher())
                                      .studentDtoList(studentDtoList)
                                      .build();

    }

}
