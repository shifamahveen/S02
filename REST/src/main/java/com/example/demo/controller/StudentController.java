package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Student;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	Student student;

	@PostMapping
	public String create(@RequestBody Student student) {
		this.student = student;
		return "Object created successfully";
	}
	
	@GetMapping("{id}")
	public Student read(String id) {
		return student;
	}
	
	@PutMapping
	public String update(@RequestBody Student student) {
		this.student = student;
		return "Object updated successfully";
	}
	
	@DeleteMapping("{id}")
	public String delete(String id) {
		this.student = null;
		return "Object deleted succesfully";
	}
}
