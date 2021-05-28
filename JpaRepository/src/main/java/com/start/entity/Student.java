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
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	// this annotation @CreationTimestamp keeps the record of row creation
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAtTime;
	
	// this annotation @UpdateTimestamp keeps the record of row updation
	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAtTime;
	
	/*
	 * what happens is when we fetch the student using entitymanager the related
	 * table(passport) is also fetched (this is called EAGER fetching) which impacts
	 * the performance of application, so we want to fetch the related table when
	 * needed (this called LAZY fetching and is done by 
	 * (@OneToOne(fetch = FetchType.LAZY)))
	 */
	
	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;
	
	public Student() {
		
	}
	
	public Student(String name) {
		this.name = name;
	}
	
	public Student(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", createdAtTime=" + createdAtTime + ", updatedAtTime="
				+ updatedAtTime + ", passport=" + passport + "]";
	}
}
