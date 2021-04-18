package com.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.start.entity.Course;
import com.start.repository.CourseRepository;
import com.start.repository.HibernateWorkingInDetail;
import com.start.repository.JPQLRepository;
import com.start.repository.NativeQuery;

@SpringBootApplication
public class JpaHibernateInDepthApplication implements ApplicationRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	JPQLRepository jpqlRepository;
	
	@Autowired
	private NativeQuery nativeQuery;
	
	@Autowired
	private HibernateWorkingInDetail hibernateWorkingInDetail;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateInDepthApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("\n {} ", courseRepository.findById(1001L).toString());
		
		//for updating
		//courseRepository.save(new Course(1001L, "aabra ka dabra"));
		courseRepository.save(new Course("and new data"));
		courseRepository.save(new Course("here is the new data"));
		
		courseRepository.playWithEntityManager();
		courseRepository.playWithEntityManager_Two();
		
		/* select * from course */
		for(Object o : jpqlRepository.getAll()) {			
			logger.info("select * from Course" + o.toString());
		}
		
		/* select * from course where name like '%spring' */
		for(Object o : jpqlRepository.jpql_Where()) {			
			logger.info("select * from course where name like '%spring'" + o.toString());
		}
		
		jpqlRepository.namedQuery();
		
		nativeQuery.nativeQueryWithParameter();
		nativeQuery.nativeQueryWithNamedParameter();
		nativeQuery.nativeQueryUpdate();
		
		hibernateWorkingInDetail.TrackHibernate();
	}
}
