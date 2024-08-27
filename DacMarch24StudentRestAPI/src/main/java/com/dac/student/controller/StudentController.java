package com.dac.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dac.student.entity.Student;
import com.dac.student.service.StudentService;

@RestController
public class StudentController {

//	@RequestMapping(path = "/home", method = RequestMethod.GET) //default get method
//	@GetMapping("/home")
//	@PostMapping("/home")
//	@PutMapping("/home")
//	@DeleteMapping("/home")
//	public String home() {
//		return "This is Home Page";
//	}
	
	  @Autowired
		StudentService studentService;
	    
	    @GetMapping("/students")
	    public ResponseEntity<List<Student>> getAllStudents()
	    {
	    	List<Student> lst = studentService.getAllStudent();
	    	if(lst.isEmpty()) {
	    		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    	}
	    	return ResponseEntity.status(HttpStatus.FOUND).body(lst);
	    }
	    
	    @GetMapping("/students/{id}")
	    public ResponseEntity<Student> getStudent(@PathVariable("id") int id)
	    {
	    	Student stud = studentService.getStudent(id);
	    	if(stud==null) {
	    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	    	}else {
	    		return ResponseEntity.status(HttpStatus.FOUND).body(stud);
	    	}
	    	
	    }
	   
	   
	    @PostMapping("/students")
	    	public ResponseEntity<Void> insertStudent(@RequestBody Student student) 
	        {
	    	Student stud= studentService.insertStudent(student);
	    	if(stud==null)
	    	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	    	
	    	return ResponseEntity.status(HttpStatus.CREATED).build();
	        }
	  
	    @PutMapping("/students/{id}")
		public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student)
	    {
	    	Student stud= studentService.updateStudent(student, id);
	    	if(stud==null)
	    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	    	return ResponseEntity.status(HttpStatus.OK).body(stud);
	    }
	    
	    @DeleteMapping("/students/{id}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable("id") int id)
	    {
	    	Student stud= studentService.deleteStudent(id);
	    	if(stud==null)
	    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    	return ResponseEntity.status(HttpStatus.OK).build();
	    }
}
