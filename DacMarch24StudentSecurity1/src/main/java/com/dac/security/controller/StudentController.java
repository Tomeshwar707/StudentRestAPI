package com.dac.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dac.security.entity.Student;
import com.dac.security.service.StudentService;


@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService service;
	
	@GetMapping("/")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Student> getAllStudents() {
		List<Student> s= service.getAllStudents();
		return s;
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('NORMAL','ADMIN')")
	public Student getStudent(@PathVariable("id") int id) {
		Student s= service.getStudent(id);
		
		return s;
	}
	
	@PostMapping("/")
	@PreAuthorize("hasRole('NORMAL')")
	public  Student insertStudent(@RequestBody Student student) {
		
		return service.insertStudent(student);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Student updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
		
		return service.updateStudent(id,student);
	}
	
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteStudent(@PathVariable("id") int id) {
		service.deleteStudent(id);
	
	}
}
