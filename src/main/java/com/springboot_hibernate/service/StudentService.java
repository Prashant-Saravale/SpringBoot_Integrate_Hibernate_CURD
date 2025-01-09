package com.springboot_hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot_hibernate.dao.StudentDao;
import com.springboot_hibernate.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao dao;

	public String addStudent(Student student) {
		return dao.addStudent(student);

	}

	public List<Student> showAllStudent() {
		return dao.showAllStudent();
	}

	
	
	public boolean updateStudent(int roll, Student student) {
		Student existingstudent = dao.findByRoll(roll);
		if (existingstudent != null) {
			//existingstudent.setRoll(student.getRoll());
			existingstudent.setName(student.getName());
			existingstudent.setMark(student.getMark());
			//System.out.println(existingstudent);
			//System.out.println("i am in service");
			dao.updateStudent(existingstudent);

			//System.out.println("i am in service");
			return true;

		} else {
			return false;
		}
	}

	public Student  getroll(int roll) {
		
	
		return dao.findByRoll(roll);
		// TODO Auto-generated method stub
		
	}

	public String deleteStudent(int roll) {
		// TODO Auto-generated method stub
		
		boolean Status=dao.deleteStudent(roll);
		if( Status)
		{
			 return "delete Student succefully....";
		}
		else
		{
			return "Roll number not found for delete....";
		}
	
	}
	
	

}
