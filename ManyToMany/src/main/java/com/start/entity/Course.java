package com.start.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
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
	
	/* OneToMany has by default lazy fetching */
	@OneToMany(mappedBy = "course")
	private List<Review> reviews = new ArrayList<>();
	
	// by default ManyToMany do lazy fetching
	@ManyToMany(mappedBy = "courses")
	private List<Student> students = new ArrayList<>();
	
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
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}
	
	public void removeReview(Review review) {
		this.reviews.remove(review);
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", createdAtTime=" + createdAtTime + ", updatedAtTime="
				+ updatedAtTime + ", reviews=" + reviews + "]";
	}
}
