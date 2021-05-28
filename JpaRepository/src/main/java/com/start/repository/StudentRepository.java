package com.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.start.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {
	
}
