package com.example.demo_curso_jpa.controller;


import com.example.demo_curso_jpa.model.Course;
import com.example.demo_curso_jpa.repository.CourseRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

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
	
	@Operation(summary = "Get all courses")
	@ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "The response for the user request",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Course.class))
                    )
            }),
			@ApiResponse(responseCode = "404", description = "Courses NOT FOUND", 
		    content = @Content)
    })
	@GetMapping
	public List<Course> getCourses() {
		return repo.findAll();
	}

	@PostMapping
	public Course saveCourse(@RequestBody Course course)	{
		return repo.save(course);
	}

	
	@Operation(summary = "Get course by id")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found course by id", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = Course.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid id supplied", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "Course not found", 
	    content = @Content) })
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
