package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

@Repository
public class CourseJdbcRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private final static String INSERT_QUERY =
			"""
				insert into course (id, name, author)
				values (?,?,?)
			""";
	
	private final static String DELETE_QUERY = 
			"""
				delete from course 
				where id = ?	
			""";
	
	private final static String SELECT_QUERY = 
			"""
					select * from course
					where id = ?
			""";
	
	public void insert(Course course) {
		jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	public void delete(long id) {
		jdbcTemplate.update(DELETE_QUERY, id);
	}
	
	public Course getById(long id) {
		// Result Set -> Bean => RowMapper
		// id
		return jdbcTemplate.queryForObject(SELECT_QUERY,
				new BeanPropertyRowMapper<>(Course.class), id);
	}
}
