package com.in28minutes.learnspringframework.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//클래스가 하나 이상의 Bean 메서드를 선언함
//Spring에서 관리하는 것 = Spring Bean
//설정 클래스에서 메서드를 정의하여 Spring Bean 생성 가능


// record란?
//Eliminate verbosity in creating Java Beans
// Public accessor method, constructor,
// equals, hashcode and toString are automatically created.
//Released in JDK 16.
//to Sring을 자동으로 호출한


record Person (String name, int age) {};
//레코드를 사용하면 게터세터 생성자 등을 만들 필요가 없다  	


//Bean에 대한 모든 정의가 있는 설정파일(Spring컨테이너를 만들기 위한 인풋) = HelloWorldConfiguration 
@Configuration
public class HelloWorldConfiguration {
	
	@Bean //스프링 컨테이너가 관리  
	public String name() {
		return "Ranga";
	}
	
	@Bean //스프링 컨테이너가 관리  
	public int age() {
		return 15;
	}
	
	@Bean
	public Person person() {
		//var person = new Person("Ravi", 20);
		//return person;
		
		return new Person("Ravi", 20);
	}
	
}
