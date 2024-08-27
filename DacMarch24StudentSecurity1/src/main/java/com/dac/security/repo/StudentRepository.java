package com.dac.security.repo;

import org.springframework.data.repository.CrudRepository;

import com.dac.security.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	public Student findByName(String name);

}
