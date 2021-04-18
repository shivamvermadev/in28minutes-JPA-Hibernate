package com.start.SpringJDBC_JPA.Repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.start.SpringJDBC_JPA.Entity.Person;

@Repository
public class PersonJDBC {
	
	/*
	 * JdbcTemplate works like a jdbc connection ie making a connection with database
	 * using steps
	 */
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/*
	 * BeanPropertyRowMapper is a mapper used to map the all variables in a class to a
	 * table inside a database
	 */
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper(Person.class));
	}
	
	//	new object array replaces ? from the content of object[]
	public Person findById(int id) {
		return (Person) jdbcTemplate.queryForObject("select * from person where id=?", new Object[] {id},
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person findByName(String name) {
		return (Person) jdbcTemplate.queryForObject("select * from person where name=?", new Object[] {name},
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	public List<Person> findByLocation(String location) {
		return jdbcTemplate.query("select * from person where location=?", new Object[] {location},
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id=?", new Object[] {id});
	}
	
	public int insert(Person person) {
		return jdbcTemplate.update("insert into person (id, name, location, birth_date) "
				+ "values (?, ?, ?, ?)", 
				new Object[] {
						person.getId(), 
						person.getName(), 
						person.getLocation(), 
						new Timestamp(person.getBirthDate().getTime())
					});
	}
	
	public int update(Person person) {
		return jdbcTemplate.update("update person set name = ?, location = ?, birth_date = ? where id = ?",
				new Object[] {
						person.getName(),
						person.getLocation(),
						person.getBirthDate(),
						person.getId()
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
