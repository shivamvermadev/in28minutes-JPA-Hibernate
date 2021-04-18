package com.start.SpringJDBC_JPA;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.start.SpringJDBC_JPA.Entity.Person;
import com.start.SpringJDBC_JPA.Repository.PersonJDBC;


/*	Application Runner and Command Line Runner interfaces lets you to execute the code after the Spring Boot 	application is started. You can use these interfaces to perform any actions immediately after the 	application has started*/

@SpringBootApplication
public class SpringJdbcJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJDBC personJDBC;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(personJDBC.findById(1001).toString());
		logger.info(personJDBC.findAll().toString());
		logger.info(personJDBC.findByName("dev").toString());
		List<Person> list = (List<Person>) personJDBC.findByLocation("sre");
		for(Person person : list) {
			logger.info(person.toString());			
		}
		logger.info(personJDBC.deleteById(1003) + "persons deleted" );
		logger.info("data inserted is : " + personJDBC.insert(new Person(1006, "vided", "adfad", new Date())));
		logger.info("data inserted is : " + personJDBC.update(new Person(1001, "deee", "ljkoim", new Date())));
		
	}
}
