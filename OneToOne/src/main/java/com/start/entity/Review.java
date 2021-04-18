package com.start.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "review")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "rating")
	private String rating;
	
	@Column(name = "description")
	private String description;
	
	// this annotation @CreationTimestamp keeps the record of row creation
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAtTime;
	
	// this annotation @UpdateTimestamp keeps the record of row updation
	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAtTime;
	
	public Review() {
		
	}
	
	public Review(String rating) {
		this.rating = rating;
	}
	
	public Review(Long id, String rating) {
		this.id = id;
		this.rating = rating;
	}
	

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating =" + rating + ", description=" + description + ", createdAtTime="
				+ createdAtTime + ", updatedAtTime=" + updatedAtTime + "]";
	}
}
