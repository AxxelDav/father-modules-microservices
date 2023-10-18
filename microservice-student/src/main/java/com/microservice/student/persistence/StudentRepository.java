package com.microservice.student.persistence;

import com.microservice.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM STUDENTS s WHERE s.COURSE_ID = :courseId", nativeQuery = true)
    List<Student> findAllStudentsByCourseId(Long courseId);

    //List<Student> findAllByCourseId(Long courseId);
}
