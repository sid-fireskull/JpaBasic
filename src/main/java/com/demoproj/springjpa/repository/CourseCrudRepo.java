package com.demoproj.springjpa.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demoproj.springjpa.entity.Course;
import com.demoproj.springjpa.entity.Review;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class CourseCrudRepo {

	@Autowired
	EntityManager manager;
	
	public Course findById(long id)
	{
		//return manager.find(Course.class, id);
        Query query = manager.createNamedQuery("Course.findCourseById", Course.class);
        query.setParameter("courseId", id);
        return (Course) query.getSingleResult();
	}
	
	@Transactional
	public Course save(Course course)
	{
		return manager.merge(course);
	}
	
	@Transactional
	public void deleteById(long courseId)
	{
		Course course = this.findById(courseId);
		manager.remove(course);
	}
	
	@Transactional
	public void addReviews(long courseId, List<Review> reviews)
	{
		Course course = findById(courseId);
		reviews.stream().forEach(e -> {
			course.addReview(e);
			e.setCourse(course);
			manager.persist(e);
		});
	}	
}
