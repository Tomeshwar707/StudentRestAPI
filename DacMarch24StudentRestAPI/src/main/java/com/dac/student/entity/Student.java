package com.dac.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private int id;
    private String name;
    private String email;
    private String city;
    private String password;

   public Student() {
   }

   public Student(String name, String email, String password, String city) {
       this.name = name;
       this.email = email;
       this.password = password;
       this.city = city;
   }

   public Student(int id, String name, String email, String password, String city) {
       this.id = id;
       this.name = name;
       this.email = email;
       this.password = password;
       this.city = city;
   }

   public int getId() {
       return id;
   }

   public String getName() {
       return name;
   }

   public String getEmail() {
       return email;
   }

   public String getPassword() {
       return password;
   }

   public String getCity() {
       return city;
   }

   public void setId(int id) {
       this.id = id;
   }

   public void setName(String name) {
       this.name = name;
   }

   public void setEmail(String email) {
       this.email = email;
   }

   public void setPassword(String password) {
       this.password = password;
   }

   public void setCity(String city) {
       this.city = city;
   }

   @Override
   public String toString() {
       return "Student{" + "id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", city=" + city + '}';
   }
    
}
