package com.in28minutes.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		
		//1: Launch a Spring Context - 
		//@Configuration  클래스로 Spring 컨텍스트를 시작
		
	var context = 
		new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		
		
		//2: Configure the things that we want Spring to manage 
		//HelloWorldCOnfiguration - @Configuration
		// name - @Bean
	
		//3:Retrieving Beans managed by Spring
		System.out.println(context.getBean("name"));
		System.out.println(context.getBean("age"));
		System.out.println(context.getBean("person"));
	
		
		// Spring이 관리하는 Bean 프레임워크를 모두 나열할 수 있다. 
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
		
		
		
		
		/*
		 1. JVM
		 2. Spring 에게 Bean을 관리하라는 명령을 내린다 (Bean 생성)
		 */
		
	}

}
