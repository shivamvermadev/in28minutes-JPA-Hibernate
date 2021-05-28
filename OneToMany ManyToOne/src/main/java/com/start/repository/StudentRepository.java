package com.start.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.start.entity.Passport;
import com.start.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/*
	 * PersistenceContext act as a storgae for obejcts and provides the access to db
	 * EntityManager is an interface to PersistenceContext
	 */
	
	@PersistenceContext
	EntityManager em;
	
	public Student findById(Long id) {
		return em.find(Student.class, id);
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
	public void save(Student student) {
		
//		if(findById(student.getId()) == null) {
//			em.merge(student);
//		}
//		else {
//			em.merge(student);
//		}
		
		em.merge(student);
	}
	
	/*
	 * if we are in a transaction and we are managing something with the entity
	 * manager, whenever we are updating something or deleting or inserting in that
	 * case things are managed by entity manager until the end of transaction
	 */
	
	public void playWithEntityManager() {
		Student student = new Student("checking something");
		em.persist(student);
		student.setName("some  chages made");
		
		/*
		 * even though I had not saved the changes then also the entity manager picks up
		 * the changes this is what is being talked about in above multi line comment
		 */
	}
	
	public void playWithEntityManager_Two() {
		Student student = new Student("checking something in playWithEntityManager_Two()");
		em.persist(student);
		student.setName("some  chages made in playWithEntityManager_Two()");
		em.flush(); // flush/save the changes to the database

		Student student1 = new Student("checking something playWithEntityManager_Two()");
		em.persist(student1);
		student1.setName("student on angular js s");
		//em.detach(student1); // to detach the object from entity manager ie now entity manager does not trak changes 
		em.flush(); //flush the changes to the database
		
		//if we want to detach all the objects from entity manager then we call
		//em.clear();
		
		Student student3 = new Student("a new student 3");
		em.persist(student3);
		em.flush();
		
		student3.setName("updated student 3");
		
		//the contents of student3 will get refreshed and get replaced by the data from the database
		em.refresh(student3);
	}
	
	public void saveStudentWithPassport() {
		/* steps involved 
		 * 1- create Passport 
		 * 2 - save it to db
		 * 3 - create Student
		 * 4 - create relation b/w student and passport
		 * 5 - save Student to db
		 */
		
		Passport passport = new Passport("K34223");
		em.persist(passport);
		
		Student student = new Student("shivam");
		student.setPassport(passport);
		em.persist(student);	
	}
	
	
	/*
	 * this below function looks fine to work but the thing is that the fetch type
	 * of passport in Student class is set to LAZY so what happens the when we fetch
	 * student object using Student student = em.find(Student.class, 2001L); the
	 * transaction is only associated with entitymanager(em) so we need to
	 * use @Transactional for the whole function and it is needed why because
	 * student.getPassport() need the transaction
	 */
		
	/*
	 * PersistenceContext act as a storgae for obejcts and provides the access to db
	 */
	
	
	@Transactional
	public void retrieveStudentFromPassport() {
		Student student = em.find(Student.class, 2001L);
		logger.info("student -> {}", student);
		logger.info("passport -> {}", student.getPassport());
		em.close();
	}
	
	@Transactional
	public void retrievePassportFromStudent() {
		Passport passport = em.find(Passport.class, 4001L);
		logger.info("passport -> {}", passport);
		logger.info("student -> {}", passport.getStudent());
		em.close();
	}
}
