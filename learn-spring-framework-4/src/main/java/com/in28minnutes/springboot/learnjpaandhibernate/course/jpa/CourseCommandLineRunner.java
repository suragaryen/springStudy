package com.in28minnutes.springboot.learnjpaandhibernate.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minnutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minnutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{
	
	//@Autowired
	//private CourseJdbcRepository repository;
	
	//@Autowired
	//private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		//CourseJpaRepository
		/*
		 * 
		repository.insert(new Course(1, "Learn JPA Now", "in28min"));
		repository.insert(new Course(1, "Learn 메롱 Now", "in28min"));
		repository.insert(new Course(1, "Learn 메론 Now", "in28min"));
		
		repository.deleteById(1);
		
		repository.findById(1);
		
		*/
		
		
		//CourseSpringDataJpaRepository
		repository.save(new Course(1, "Learn JPA Now", "in28min")); //save는 엔터티를 업데이트하거나 인서트 할 때 사용
		repository.save(new Course(1, "Learn 메롱 Now", "in28min"));
		repository.save(new Course(1, "Learn 메론 Now", "in28min"));
		
		repository.deleteById(1l);
		
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(2l));
		
		//repository.findAll();
		repository.count();
		
		System.out.println(repository.findByAuthor("in28minutes")); //커스텀
		System.out.println(repository.findByAuthor(""));
		
		//System.out.println(repository.findByName("in28minutes"));
		//System.out.println(repository.findByName(""));
		
		
	}

}
