package com.in28minutes.learnspringframework.examples.a0;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


// 필드, 세터, 생성자 의존성 주입
// Spring은 생성자 생성자 기반 주입을 추천한다
// 초기화가 하나의 메소드에서 발생되기 때문이다 
// 초기화가 완료되면 Bean을 사용할 준비가 된 건데, 이것이 바로 Spring 팀이 생성자 주입을 추천하는 이유이다
// 생성자 의존성 주입은 @Autowired 를 사용할필요도 없음 
@Component
class YourBusinessClass{
	
	
	//Field injection
	//1. Field에 의존성 주입 
	//No setter or constructor Dependency is injected using reflection. 
	
	//@Autowired
	Dependency1 dependency1;
	
	//@Autowired
	Dependency2 dependency2;
	
	
	//3.Constructor Dependency
	//생성자 의존성 주입  
	//@Autowired @Autowired를 추가하지 않아도 여기 있는 모든 의존성으로 생성자를 생성한다면
	//Spring이 자동으로 생성자를 사용해서 객체를 만든다. 
	//Dependencies are set by creating the Bean using its Constructor
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor Injection - YourBusinessClass");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}


	//setter 생성
	//2. Setter에 의존성 주입  
	// Dependencies are set by calling setter methods on your beans 
//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Setter Injection - setDependency1");
//		this.dependency1 = dependency1;
//	}
//
//
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("Setter Injection - setDependency2");
//		this.dependency2 = dependency2;
//	}



	public String toString() {
		return "Using" + dependency1 + "and" + dependency2;
	}
	
}

@Component
class Dependency1{
	
}

@Component
class Dependency2{
	
}





@Configuration
@ComponentScan//("com.in28minutes.learnspringframework.examples.a1;") 패키지가 같을 경우에는 명시적으로 정의해 줄 필요가 없다 
public class SimpleSpringContextLauncherApplication {

	public static void main(String[] args) {

		
		try(var context = 
				new AnnotationConfigApplicationContext
				(SimpleSpringContextLauncherApplication.class)){

				Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
		}
		
			

	}

}
