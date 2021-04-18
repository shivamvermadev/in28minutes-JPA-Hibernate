package com.start.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.start.entity.Course;

@Repository
@Transactional
public class CourseRepository {
	
	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	/*
	 * Error: javax.persistence.TransactionRequiredException 
	 * This error typically occurs
	 * when we're trying to perform a database operation that modifies the database
	 * without a transaction. The obvious solution is to wrap any database-modifying
	 * operation in a transaction: Applying the @Transactional to the method above
	 * may solve the error. This is because the transaction will only be committed when the
	 * method exits and is about to return to the caller.
	 * 
	 * one usecase of tranaction is when using relationship - fetching data of related table without 
	 * entity manager. for ex:
	 * User u = em.find(User.class, id); // executes fine as em uses internal transaction
	 * Comments c = user.getComments(); // show error as @Trasactional is to be used when only fetchin but in relation
	 */	
	
	@Transactional
	public void deleteById(Long id) {
		em.remove(findById(id));
	}
	
	@Transactional
	public void save(Course course) {
		
//		if(findById(course.getId()) == null) {
//			em.merge(course);
//		}
//		else {
//			em.merge(course);
//		}
		
		em.merge(course);
	}
	
	/*
	 * if we are in a transaction and we are managing something with the entity
	 * manager, whenever we are updating something or deleting or inserting in that
	 * case things are managed by entity manager until the end of transaction
	 */
	
	public void playWithEntityManager() {
		Course course = new Course("checking something");
		em.persist(course);
		course.setName("some  chages made");
		
		/*
		 * even though I had not saved the changes then also the entity manager picks up
		 * the changes this is what is being talked about in above multi line comment
		 */
	}
	
	public void playWithEntityManager_Two() {
		Course course = new Course("checking something in playWithEntityManager_Two()");
		em.persist(course);
		course.setName("some  chages made in playWithEntityManager_Two()");
		em.flush(); // flush/save the changes to the database

		Course course1 = new Course("checking something playWithEntityManager_Two()");
		em.persist(course1);
		course1.setName("course on angular js s");
		//em.detach(course1); // to detach the object from entity manager ie now entity manager does not trak changes 
		em.flush(); //flush the changes to the database
		
		//if we want to detach all the objects from entity manager then we call
		//em.clear();
		
		Course course3 = new Course("a new course 3");
		em.persist(course3);
		em.flush();
		
		course3.setName("updated course 3");
		
		//the contents of course3 will get refreshed and get replaced by the data from the database
		em.refresh(course3);
	}
}
