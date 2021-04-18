package com.start.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.start.entity.Course;

@Repository
public class JPQLRepository {

	@PersistenceContext
	EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	/*
	 * sql works in tables 
	 * jpql works in entities
	 */

	
	
	/* select * from courses */
	public List<Course> getAll() {
		//normal query 
		List<Course> listCourse = em.createQuery("Select c from Course c").getResultList();
		
		
		//TypedQuery  is very specific as it describes the class involved in query
		TypedQuery<Course> query = em.createQuery("Select c from Course c", Course.class);
		List<Course> list = query.getResultList();
		return list;
	}
	
	public List<Course> jpql_Where() {
		TypedQuery<Course> query = 
				em.createQuery("Select c from Course c where c.name ='a new course 3' ", Course.class);
		List<Course> list = query.getResultList();
		return list;
	}
	
	public void namedQuery() {
		TypedQuery<Course> query = em.createNamedQuery("select_all_courses", Course.class);
		List<Course> list = query.getResultList();
		for(Course course : list) {
			logger.info("named query " + course.toString());			
		}
		
		TypedQuery<Course> query1 = em.createNamedQuery("select_all_courses_where_name='a new course 3'", 															Course.class);
		List<Course> list1 = query1.getResultList();
		for(Course course : list1) {
			logger.info("named query second " + course.toString());			
		}
	}
}
