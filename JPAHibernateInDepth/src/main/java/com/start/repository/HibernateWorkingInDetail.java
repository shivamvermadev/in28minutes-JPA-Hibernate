package com.start.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.start.entity.Course;

@Repository
public class HibernateWorkingInDetail {
	
	@PersistenceContext
	EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Transactional
	public void TrackHibernate() {
		Course course = new Course(1001L, "a new course on vue.js");
		em.merge(course);
		
		Course course1 = em.find(Course.class, 1001L);
		logger.info("learing working of hibernate in detail", course.getName());
		
		/*
		 * what happens is when the changing is being going on the hibernate does not
		 * immediately saves that changes to the db until flush is called, instead it
		 * tracks them until the last change and while leaving the funtion it saves them
		 * to db suppose we save the object and use em.flush() to save it to db, and
		 * below that flush code written fails then hibernate rollback all the changes
		 * that has been made inside that function
		 */
		
	}
}
