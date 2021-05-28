package com.inheritance.statApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) creates table for all the classses super and parent as well 
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // for enabling inheritance and its default ie the strategy is default SINGLE_TABLE 
//@DiscriminatorColumn(name = "EmployeeType") //rename the column made of inherited tables(renaming DTYPE) when using InheritanceType.SINGLE_TABLE 


/**
 * @author SHIVAM VERMA
 *
 */
@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // creates tables for concrete class ie non-abstract class
public abstract class Employee {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	public Employee() {

	}

	public Employee(String name) {
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
		return "Employee [id=" + id + ", name=" + name + "]";
	}
}
