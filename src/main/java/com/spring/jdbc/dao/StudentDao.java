package com.spring.jdbc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.jdbc.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	// insert object
	@Transactional
	public int insert(Student student) {
		//returns id of the inserted row
		return (Integer) this.hibernateTemplate.save(student);
	}

	// get single object
	public Student getStudent(int studentId) {
		return this.hibernateTemplate.get(Student.class, studentId);
	}

	// get all objects
	public List<Student> getAllStudent() {
		return (List<Student>) this.hibernateTemplate.loadAll(Student.class);
	}

	// delete single object
	@Transactional
	public void deleteStudent(int studentId) {
		Student deleteStudent = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(deleteStudent);
	}

	// update object
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	
}
