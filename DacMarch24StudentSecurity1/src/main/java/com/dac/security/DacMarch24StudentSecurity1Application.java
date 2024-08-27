package com.dac.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dac.security.entity.Student;
import com.dac.security.repo.StudentRepository;



@SpringBootApplication
public class DacMarch24StudentSecurity1Application implements CommandLineRunner{

	@Autowired
	StudentRepository repository;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(DacMarch24StudentSecurity1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Student s1=new Student("Piyush","piyush@gmail.com", "Nagpur", passwordEncoder.encode("piyu"),"ROLE_ADMIN");
//		Student s2=new Student("Sani","sani@gmail.com", "Nagpur",passwordEncoder.encode("sani"),"ROLE_NORMAL");
//
//		repository.save(s1);
//		repository.save(s2);		
	}

}
