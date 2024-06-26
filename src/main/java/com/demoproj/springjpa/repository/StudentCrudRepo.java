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
		Student stud = this.findById(studentId);
		manager.remove(stud);
	}
	
	@Transactional
	public void getCoursesByStudent(long studentId)
	{
		Student stud = manager.find(Student.class, studentId);
		stud.getCourses().stream().forEach(System.out::println);
	}
	
	@Transactional
	public void saveHardCodedNewStudentAndCourse()
	{
		Student stud = new Student("Tony Stark");
		Course cr = new Course("Rust");
		manager.persist(cr);
		manager.persist(stud);
		
		stud.addCourse(cr);
		cr.addStudents(stud);
		manager.persist(stud);
	}
}
