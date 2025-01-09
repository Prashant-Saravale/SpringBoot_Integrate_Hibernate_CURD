package com.springboot_hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot_hibernate.model.Student;

@Repository
public class StudentDao {

	@Autowired
	private SessionFactory factory;

	@SuppressWarnings("deprecation")
	public String addStudent(Student student) {

		Session session = factory.openSession();
		session.save(student);
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		return " Student added....";
	}

	public List<Student> showAllStudent() {
		Session session = factory.openSession();
		List<Student> students = session.createQuery("from Student", Student.class).getResultList();

		return students;
	}

	public Student findByRoll(int roll) {
		// Get the current Hibernate session
		Session session = factory.openSession();

		// Fetch the student by ID
		return session.get(Student.class, roll); // Returns null if not found
	}

	@SuppressWarnings("deprecation")
	public void updateStudent(Student student) {

		System.out.println("i am in dao");
		Session session = factory.openSession();
		System.out.println(student);
		session.update(student);
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		System.out.println("i am in dao compltete");

	}

	@SuppressWarnings("deprecation")
	public boolean deleteStudent(int roll) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Student student = session.get(Student.class, roll);
		if (student != null) {
			session.delete(student);
			transaction.commit();
			return true;

		} else {
			return false;
		}
	}

}
