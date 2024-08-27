package com.dac.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties.Decryption;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dac.security.entity.Student;
import com.dac.security.repo.StudentRepository;


@Service
public class StudentService {
	@Autowired
	StudentRepository repository;
	
	@Autowired
	Decryption decryption;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	public List<Student> getAllStudents() {
		
		return (List<Student>) repository.findAll();
	}

	public Student getStudent(int id) {
//		Student s=studs.stream().filter(stud->stud.get()==id).findAny().get();
		Student s=repository.findById(id).get();		
		return  s;
	}

	public Student insertStudent(Student student) {
		
	Student s=	repository.save(student);
	s.setPassword(passwordEncoder.encode(student.getPassword())); 
	s=repository.save(s);
		return s;
	}

	public Student updateStudent(int id, Student student) {
		Student s= null;
		
		Student oldData=repository.findById(id).get();
		oldData.setName(student.getName());
		oldData.setEmail(student.getEmail());
		oldData.setPassword(passwordEncoder.encode(student.getPassword()));
		oldData.setCity(student.getCity());

		s=repository.save(oldData);
		
		return s;
	}

	public void deleteStudent(int id) {
		repository.deleteById(id);
	}
	
}
