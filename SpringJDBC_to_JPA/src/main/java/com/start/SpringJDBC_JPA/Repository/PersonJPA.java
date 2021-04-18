package com.start.SpringJDBC_JPA.Repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.start.SpringJDBC_JPA.Entity.Person;


@Repository
@Transactional
public class PersonJPA {
	
	//connection to a database
	@PersistenceContext
	EntityManager entityManager;
	
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	
	/*
	 * merge works for both update and insert when the id is present it updates that
	 * record when id is not present it inserts that record
	 */
	
	public Person update(Person person) {
		return entityManager.merge(person);
	}
	
	
	public Person insert(Person person) {
		return entityManager.merge(person);
	}
	
	public void deleteById(int id) {
		entityManager.remove(findById(id));
	}
	
	
	// watch the last video 18 of section - 3
	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	
	}
}

