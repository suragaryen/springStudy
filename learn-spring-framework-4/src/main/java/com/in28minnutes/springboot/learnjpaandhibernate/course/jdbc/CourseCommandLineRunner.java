package com.in28minnutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minnutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minnutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{
	
	//@Autowired
	//private CourseJdbcRepository repository;
	

	
	@Override
	public void run(String... args) throws Exception {
		
		//repository.insert(new Course(1, "Learn JPA Now", "in28min"));
		//repository.insert(new Course(1, "Learn 메롱 Now", "in28min"));
		//repository.insert(new Course(1, "Learn 메론 Now", "in28min"));
		
		//repository.delete(1);
		
	}

}
