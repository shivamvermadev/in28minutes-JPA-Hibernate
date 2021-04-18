package com.start;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.start.entity.Course;
import com.start.repository.CourseRepository;

@SpringBootTest
class JpaHibernateInDepthApplicationTests {

	@Autowired
	CourseRepository courseRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	void findByID_Test_One() {
		assertEquals("Learn spring hibernate-jpa", courseRepository.findById(1001L).getName());
	}
	
	@Test
	void findById_Test_Two() {
		assertEquals("Learn spring-boot", courseRepository.findById(1002L).getName());
	}
	
	
	/*
	 * any test that changes the state of an application database should also
	 * restore it to previous state so that other test do not fail to prevent that
	 * we use @DirtiesContext
	 */
	@Test
	@DirtiesContext
	void deleteById_Test_One() {
		courseRepository.deleteById(1001L);
		assertNull(courseRepository.findById(1001L));
	}
	
	@Test
	@DirtiesContext
	void save_Test() {
		Course course = courseRepository.findById(1001L);
		logger.info(course.getName());
		assertEquals("Learn spring hibernate-jpa", course.getName());
		
		course.setName("spring boot in 28 minutes");
		logger.info("123" + course.getName());
		courseRepository.save(course);
		logger.info("123" + course.getName());
		Course course1 = courseRepository.findById(1001L);
		logger.info("123" + course1.getName());
		assertEquals("spring boot in 28 minutes", course1.getName());
	}
}
