package com.dac.student.repositry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dac.student.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
 
}
 