package com.start.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "passport")
public class Passport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "number", nullable = false)
	private String number;
	
	// this annotation @CreationTimestamp keeps the record of row creation
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAtTime;
	
	// this annotation @UpdateTimestamp keeps the record of row updation
	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAtTime;
	
	/*
	 * mappedBy is used on that class that does not own the relationship ie the
	 * class where the extra column is not created its like relation banega and
	 * mapping student karega. mappedBy accepts the variable name of the related
	 * class on which mapping is done in this case the passport is the variable of
	 * student class
	 */
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport") //passport variable in student 
	private Student student;
	
	public Passport() {
		
	}
	
	public Passport(String number) {
		this.number = number;
	}
	
	public Passport(Long id, String number) {
		this.id = id;
		this.number = number;
	}
	

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]";
	}		
}
