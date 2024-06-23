package com.demoproj.springjpa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demoproj.springjpa.entity.Course;
import com.demoproj.springjpa.entity.Passport;
import com.demoproj.springjpa.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class StudentCrudRepo {

	@Autowired
	EntityManager manager;
	
	@Transactional
	public Student findById(long id)
	{
		Student student= manager.find(Student.class, id);
		Passport passport = student.getPassport();
		System.out.println(passport.getNumber());
		return student;
	}
	
	@Transactional
	public Course save(Course course)
	{
		return manager.merge(course);
	}
	
	@Transactional
	public void deleteById(long studentId)
	{
		Student course = this.findById(studentId);
		manager.remove(course);
	}
	
	
}
