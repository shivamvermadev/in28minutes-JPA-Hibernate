package com.start.SpringJDBC_JPA;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.start.SpringJDBC_JPA.Entity.Person;
import com.start.SpringJDBC_JPA.Repository.PersonJPA;


/*	Application Runner and Command Line Runner interfaces lets you to execute the code after the Spring Boot 	application is started. You can use these interfaces to perform any actions immediately after the 	application has started*/

@SpringBootApplication
public class SpringJdbcJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJPA personJPA;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(personJPA.findById(1001).toString());
		logger.info("data inserted is : " + personJPA.insert(new Person("vided", "adfad", new Date())));
		logger.info("data inserted is : " + personJPA.update(new Person(1001, "deee", "ljkoim", new Date())));
		personJPA.deleteById(1003);
		logger.info(personJPA.findAll().toString());
	}
}
