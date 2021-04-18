package com.start.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQuery(name = "select_all_courses", query = "select c from Course c")
@NamedQuery(name = "select_all_courses_where_name='a new course 3'", query = "Select c from Course c where c.name ='a new course 3' ")
@Table(name = "course")
public class Course {
	
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
	
	public Course() {
		
	}
	
	public Course(String name) {
		this.name = name;
	}
	
	public Course(Long id, String name) {
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

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}	
	
	
}
