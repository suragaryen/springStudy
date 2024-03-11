package com.in28minnutes.springboot.learnjpaandhibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity //(name = "CourseDetails") 클래스 이름과 테이블 이름이 다를 때 
public class Course {
	
	
	@Id // 기본키로 정의하는 어노테이션  
	private long id;
	
	//@Column(name = "name") //이름이 name인 column에 매핑
	private String name;
	
	//@Column(name = "author") //이름이 author인 column에 매핑
	private String author;
	
	public Course() {
		
	}
	
	
	
	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}



	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
		
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}



	public void setId(long id) {
		this.id = id;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	
}
