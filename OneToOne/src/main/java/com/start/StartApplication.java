package com.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.start.repository.StudentRepository;

@SpringBootApplication
public class StartApplication implements CommandLineRunner{

	@Autowired
	StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		studentRepository.saveStudentWithPassport();
		studentRepository.retrieveStudentFromPassport();
		studentRepository.retrievePassportFromStudent();
	}

}
