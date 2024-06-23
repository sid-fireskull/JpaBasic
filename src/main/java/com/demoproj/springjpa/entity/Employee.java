package com.demoproj.springjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass // This is not part of inheritance of entity, so @Entity annotation is not used, Noting related to this class is mapped to db
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED) // Common fields are belongs to parent table and class specific fields are created in individual table, joined perform during retrieval of data
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // Per table for per subclass
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="employeeType") // Used for SINGLE_TABLE strategy to specify the type of the employee in single table
public abstract class Employee {
	
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private String name;
	
	
	public Employee() {
		super();
	}
	
	public Employee(String name) {
		super();
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}
}
