package com.start.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.start.entity.Course;

@Repository
public class NativeQuery {
	
	@PersistenceContext
	private EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/* native queries are useful for doing large things in one like inserting, updating data into table at once
	 * other wise we have to find tha id of data and then update it 
	*/
	
	public void nativeQueryWithParameter() {
		Query query = em.createNativeQuery("select * from course where id = ?", Course.class);
		query.setParameter(1, 1001L); // starting position is 1
		for(Object c : query.getResultList()) {
			logger.info(c.toString());
		}
	}
	
	public void nativeQueryWithNamedParameter() {
		Query query = em.createNativeQuery("select * from course where id = :id", Course.class);
		query.setParameter("id", 1002L); // id get replaced by 1002L
		for(Object c : query.getResultList()) {
			logger.info(c.toString());
		}
	}

	@Transactional
	public void nativeQueryUpdate() {
		Query query = em.createNativeQuery("update course set name ='go to hell' ", Course.class);
		int rowsEffected = query.executeUpdate();
		logger.info("rows affected ", rowsEffected);
	}
}
