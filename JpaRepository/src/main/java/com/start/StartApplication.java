package com.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.start.service.StudentService;

@SpringBootApplication
public class StartApplication implements CommandLineRunner{


	@Autowired
	StudentService studentService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		studentService.findById(2001L);
		studentService.insertStudent();
		studentService.updateStudent();
		studentService.removeStudent();
		studentService.getAllStudentsSorted();
		studentService.pagination();
	}

}
