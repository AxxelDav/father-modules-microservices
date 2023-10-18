package com.microservice.course.client;

import com.microservice.course.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-student", url = "localhost:8080/api/student") //Using Gateway
public interface StudentClient {

    @GetMapping("search-by-course/{courseId}")
    List<StudentDto> findAllStudentsByCourseId(@PathVariable Long courseId);
}
