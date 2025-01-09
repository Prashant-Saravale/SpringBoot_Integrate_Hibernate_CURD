package com.springboot_hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot_hibernate.model.Student;
import com.springboot_hibernate.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	
	private StudentService service;
	
	@GetMapping("/addstudent")
	
	 public String addStudent(@RequestBody Student student)
	 {
		return service.addStudent(student);
		
	 }
	
	 @GetMapping("/showallstudent")
	 public List<Student> showAllStudent()
	 {
		return service.showAllStudent();
		 
	 }
	
	 
	 
		@PutMapping("/updatestudent/{roll}")
	 
	 public String updateStudent( @PathVariable int roll, @RequestBody Student student)
	 {
		 boolean status=service.updateStudent(roll, student);
		 if(status)
		 {
			 return "Student record updated successfully";
		 }
		 else
		 {
			 return ("Student record not found with ID: " + roll);
		 }
		 
	 } 
		
		@GetMapping("/getStudentByRoll/{roll}")
		
		public Student getroll(@PathVariable int roll)
		{
			 return service.getroll(roll);
			
			
		}
	
		
		@DeleteMapping("/deleteStudent/{roll}")
		
		public String deleteStudent(@PathVariable int roll)
		{
			
		 	 return  service.deleteStudent(roll);
		
			
		}
}
