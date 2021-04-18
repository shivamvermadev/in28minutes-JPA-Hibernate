package com.start;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.start.entity.Student;

@SpringBootTest
class OneToOneApplicationTests {

	@PersistenceContext
	EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	void retrieveStudentAndPassport() {
		Student student = em.find(Student.class, 2001L);
		logger.info("student -> {}", student);
		logger.info("passport -> {}", student.getPassport());
		em.close();
	}
}
