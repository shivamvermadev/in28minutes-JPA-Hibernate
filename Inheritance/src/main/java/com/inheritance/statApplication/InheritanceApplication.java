package com.inheritance.statApplication;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.inheritance.statApplication.entity.FullTimeEmployee;
import com.inheritance.statApplication.entity.PartTimeEmployee;
import com.inheritance.statApplication.repository.EmployeeRepository;

@SpringBootApplication
public class InheritanceApplication implements CommandLineRunner{

	@Autowired
	EmployeeRepository employeeRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(InheritanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));

		logger.info("employees => {}", employeeRepository.getEmployees());
	}

}
