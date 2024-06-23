package com.demoproj.springjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	private Long id;
	private String number;
	/* mappedBy="passport" declaring student table is owning table of passport, to prevent duplication.
	 * "passport" is the instance variable name of Passport class in Student Entity
	 */
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
	private Student student;

	public Passport(Long id, String number) {
		super();
		this.id = id;
		this.number = number;
	}

	public Passport() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Passport{" + "id=" + id + ", number='" + number + '\'' + '}';
	}
}
