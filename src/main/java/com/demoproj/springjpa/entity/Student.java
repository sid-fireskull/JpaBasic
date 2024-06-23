package com.demoproj.springjpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

    @Id
    private Long id; 
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;
    @ManyToMany
    /* 
     * Configure joining table
     * @JoinTable(name ="...." is used for naming the table name
     * joinColumns used to set the current table id to the joining table
     * inverseJoinColumns used to set for reverse lookup from the other table
     * joinColums & inverseJoinColumns allow us to customize the name of the column name for relationship between the table
     * */
    @JoinTable(name="student_course",
    			joinColumns = @JoinColumn(name= "student_id"),
    			inverseJoinColumns = @JoinColumn(name="course_id"))
    private List<Course> courses = new ArrayList<>();

    public Student() {
    }

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}

	@Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
