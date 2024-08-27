package com.dac.student.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.dac.student.model.Student;



@Controller
public class StudentTempController {

//	@RequestMapping("/home")
//	public String myHome(Model m) {
//		m.addAttribute("name","Tomeshwar");
//		return "home";
//	}
	
	@Autowired
	RestTemplate restTemplate;
	    
	    @GetMapping("/")
	    public String getAllStudents(Model m)
	    {
	    	ResponseEntity<Student[]> studentResponse=restTemplate.getForEntity("http://localhost:8080/students", Student[].class);
	    	List<Student> lst= Arrays.asList(studentResponse.getBody());
	    	m.addAttribute("students",lst);
	    	return "home";
	    }
	    
	    @GetMapping("/new")
	    public String showForm(Model m)
	    {
	    	Student s = new Student();
	    	m.addAttribute("student",s);
	    	return "registerStudent";
	    }
	    
	    @PostMapping("/insert")
	    	public String insertStudent(@ModelAttribute Student student)
	        {
		     restTemplate.postForEntity("http://localhost:8080/students", student, Student.class);
	        	return "redirect:/";
	        }
	    
	    @GetMapping("/edit/{id}")
	    public String editStudent(@PathVariable("id") int id,Model m)
	    {
	    	ResponseEntity<Student> studResponse=restTemplate.getForEntity("http://localhost:8080/students/"+id, Student.class);
	    	Student s = studResponse.getBody();
	    	m.addAttribute("student",s);
	    	return "registerStudent";
	    }
	    
	    @PostMapping("/update")
		public String updateStudent(@ModelAttribute Student stud)
	    {
	    	System.out.println("Going to Update "+stud);
	    	restTemplate.put("http://localhost:8080/students/"+stud.getId(), stud);
	    	return "redirect:/";
	    }
	    
	    @GetMapping("/delete/{id}")
	    public String deleteStudent(@PathVariable("id") int id)
	    {

	    	restTemplate.delete("http://localhost:8080/students/"+id);
	    	return "redirect:/";
	    }
}
