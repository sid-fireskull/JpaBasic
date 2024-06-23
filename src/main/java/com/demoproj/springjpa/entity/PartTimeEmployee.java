package com.demoproj.springjpa.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {
	
	private BigDecimal hourlyWages;
	
	public PartTimeEmployee()
	{
		super();
	}
	
	public PartTimeEmployee(String name, BigDecimal hourlyWages) {
		super(name);
		this.hourlyWages = hourlyWages;
	}

	public BigDecimal getHourlyWages() {
		return hourlyWages;
	}

	public void setHourlyWages(BigDecimal hourlyWages) {
		this.hourlyWages = hourlyWages;
	}

}
