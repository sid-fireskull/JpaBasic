package com.demoproj.springjpa.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demoproj.springjpa.entity.Employee;
import com.demoproj.springjpa.entity.FullTimeEmployee;
import com.demoproj.springjpa.entity.PartTimeEmployee;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeCrudRepo {

	@Autowired
	EntityManager manager;
	
	public void insertPartTimeEmployee(PartTimeEmployee employee)
	{
		manager.persist(employee);
	}
	
	public void insertFullTimeEmployee(FullTimeEmployee employee)
	{
		manager.persist(employee);
	}
	
	public List<Employee> retriveAllEmployee()
	{
		return manager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
	}
	
}
