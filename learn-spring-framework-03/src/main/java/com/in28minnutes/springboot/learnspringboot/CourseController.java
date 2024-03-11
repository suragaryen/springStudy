package com.in28minnutes.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses(){
		return Arrays.asList(
				
				new Course(1, "LearnAWS", "in28minutes"),
				new Course(2, "Learn DevOps", "in28minutes")
				
				);
	}
		
}
