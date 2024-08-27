package com.dac.security.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dac.security.entity.Student;


public class CustomUserDetails implements UserDetails {

	private Student student;
	
	public CustomUserDetails() {
	}
	

	public CustomUserDetails(Student student) {
		this.student = student;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<SimpleGrantedAuthority> set =new HashSet<>();
		set.add(new SimpleGrantedAuthority(student.getRole()));
		return set;
	}

	@Override
	public String getPassword() {
		return student.getPassword();

	}

	@Override
	public String getUsername() {
		return student.getName();

	}

}
