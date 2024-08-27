package com.dac.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dac.student.entity.Student;
import com.dac.student.repositry.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}

	public List<Student> getAllStudent() {
		return (List<Student>) studentRepository.findAll();

	}

	public Student insertStudent(Student student) {
		Student stud=null;
		try {
		stud= studentRepository.save(student);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return stud;
	}

	public Student updateStudent(Student student, int id) {
		Student stud=null;
		if(student.getId()==id) {
		Student oldStudent=studentRepository.findById(id).get();
		oldStudent.setName(student.getName());
		oldStudent.setEmail(student.getEmail());
		oldStudent.setPassword(student.getPassword());
		oldStudent.setCity(student.getCity());
		
		stud= studentRepository.save(oldStudent);
		}
		return stud;
	}

	public Student deleteStudent(int id) {
		Student student=null;
		try {
		student= studentRepository.findById(id).get();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if(student != null) {
			studentRepository.deleteById(id);	
		}
		return student;
	}

	public Student getStudent(int id) {
		Student student=null;
		try {
		return studentRepository.findById(id).get();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return student;
	}

	
}
