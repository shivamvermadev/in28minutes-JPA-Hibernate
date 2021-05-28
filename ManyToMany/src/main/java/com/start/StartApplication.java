package com.start;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.start.entity.Review;
import com.start.repository.CourseRepository;
import com.start.repository.StudentRepository;

@SpringBootApplication
public class StartApplication implements CommandLineRunner{

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		/*
		 * studentRepository.saveStudentWithPassport();
		 * studentRepository.retrieveStudentFromPassport();
		 * studentRepository.retrievePassportFromStudent();
		 */
		
		/* courseRepository.addReviewToCourse(); */
		
		/*
		 * List<Review> reviews = new ArrayList<>(); Review review1 = new Review("5",
		 * "leared so many things"); Review review2 = new Review("5",
		 * "great course on spring boot"); reviews.add(review1); reviews.add(review2);
		 * courseRepository.addReviewToCourse(1002L, reviews);
		 */
		courseRepository.retriveStudentAndCourse();
		courseRepository.retriveCourseAndStudent();
		courseRepository.insertStudentAndCourse();
	}

}
