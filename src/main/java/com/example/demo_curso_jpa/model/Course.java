package com.example.demo_curso_jpa.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="courses")
@Entity
public class Course {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private  Long id;
	private  String name;
	private Integer credit;
}