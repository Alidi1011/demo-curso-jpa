package com.example.demo_curso_jpa.repository;

import com.example.demo_curso_jpa.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
