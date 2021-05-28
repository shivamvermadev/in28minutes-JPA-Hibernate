package com.start.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.start.entity.Course;
import com.start.entity.Review;

@Repository
@Transactional
public class CourseRepository {

	@PersistenceContext
	EntityManager em;
	
	public void addReviewToCourse() {
		Course course = em.find(Course.class, 1002L);
		Review review1 = new Review("5", "leared so many things");	
		Review review2 = new Review("5", "great course on spring boot");	
		
		/* adding review to the course */
		course.addReview(review1);
		course.addReview(review2);	
		
		/* adding couse to the review also as the mapping is done by reiew table */
		review1.setCourse(course);
		review2.setCourse(course);
		
		/* saving review to the db */
		em.persist(review1);
		em.persist(review2);
	}
	
	public void addReviewToCourse(Long courseId, List<Review> reviews) {
		Course course = em.find(Course.class, courseId);
		if(course == null) {
			return;
		}
		for(Review review: reviews) {
			course.addReview(review);
			review.setCourse(course);
			em.persist(review);
		}
	}
}
