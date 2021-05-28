package com.start.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.start.entity.Student;
import com.start.repository.StudentRepository;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Student findById(Long id) {
		Optional<Student> studentOptional = studentRepository.findById(id);
		logger.info("Student present {}", studentOptional.isPresent());
		logger.info("student info {}", studentOptional.get());
		return studentOptional.get();
	}
	
	public void insertStudent() {
		Student student = new Student("Kailash");
		studentRepository.save(student);
	}
	
	public void updateStudent() {
		Student student = studentRepository.findById(2001L).get();
		student.setName("Max");
		studentRepository.save(student);
	}
	public void removeStudent() {
		studentRepository.deleteById(2001L);
	}
	
	public void getAllStudentsSorted() {
		List<Student> sortedStudents = studentRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
		logger.info("sorted students {}", sortedStudents);
	}
	
	public void pagination() {
		PageRequest pageRequest = PageRequest.of(0, 1);
		Page<Student> studentPage = studentRepository.findAll(pageRequest);
		List<Student> students = studentPage.getContent();
		logger.info("\nStudents list {} ",students);
	}
}
