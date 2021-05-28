package com.inheritance.statApplication.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inheritance.statApplication.entity.Employee;

@Repository
@Transactional
public class EmployeeRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insert(Employee employee) {
		em.persist(employee);
	}

	public List<Employee> getEmployees() {
		return em.createQuery("select e from Employee e", Employee.class).getResultList();
	}
	
}
