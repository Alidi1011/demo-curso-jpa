package com.example.demo_curso_jpa.controller;


import com.example.demo_curso_jpa.model.Course;
import com.example.demo_curso_jpa.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/courses")
public class CourseController {
	@Autowired
	CourseRepository repo;

	@GetMapping("/hola")
	public String index(){

		return "Hello from Azure Deployment demo-curso-jpa!!!!";
	}
	@GetMapping
	public List<Course> getCourses() {
		return repo.findAll();
	}

	@PostMapping
	public Course saveCourse(@RequestBody Course course)	{
		return repo.save(course);
	}

	@GetMapping("/{id}")
	public Course getCourse(@PathVariable Long id){
		Optional<Course> optionalCourse = repo.findById(id);
		return optionalCourse.get();
	}

	@PutMapping
	public Course updateCourse(@RequestBody Course course) {
		return repo.save(course);
	}

	@DeleteMapping("/{id}")
	public void deleteCourse(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
