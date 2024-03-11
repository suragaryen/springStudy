package com.in28minnutes.springboot.learnjpaandhibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minnutes.springboot.learnjpaandhibernate.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long>{

	//entityManater 같은걸 사용할 필요 없이 interface를 extends만 시켜줘도 쿼리를 실행시킬 수 있다.  
	//
	
	
	List<Course> findByAuthor (String author);
	List<Course> findByName (String name);
}
