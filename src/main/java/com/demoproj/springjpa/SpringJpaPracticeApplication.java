package com.demoproj.springjpa;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demoproj.springjpa.entity.Course;
import com.demoproj.springjpa.entity.FullTimeEmployee;
import com.demoproj.springjpa.entity.PartTimeEmployee;
import com.demoproj.springjpa.repository.CourseCrudRepo;
import com.demoproj.springjpa.repository.EmployeeCrudRepo;
import com.demoproj.springjpa.repository.StudentCrudRepo;

@SpringBootApplication
public class SpringJpaPracticeApplication implements CommandLineRunner{

	@Autowired
	CourseCrudRepo courseRepo;
	@Autowired
	StudentCrudRepo studentRepo;
	@Autowired
	EmployeeCrudRepo employeeRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaPracticeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//  System.out.println(courseRepo.findById(10003));
		//  System.out.println(studentRepo.findById(1001));
		//  studentRepo.getCoursesByStudent(1001);
		//	System.out.println(repo.save(new Course(10002L,"AI & Machine Learning")));
		//	repo.deleteById(10003);
		//  studentRepo.saveHardCodedNewStudentAndCourse();
		
		employeeRepo.insertFullTimeEmployee(new FullTimeEmployee("Bill Gates", new BigDecimal(10000)));
		employeeRepo.insertPartTimeEmployee(new PartTimeEmployee("Steve Jobs", new BigDecimal(50)));
		
		// employeeRepo.retriveAllEmployee().stream().forEach(System.out::println);
	}

}
