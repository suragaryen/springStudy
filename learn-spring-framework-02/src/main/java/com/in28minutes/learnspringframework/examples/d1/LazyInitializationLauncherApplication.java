package com.in28minutes.learnspringframework.examples.d1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.in28minutes.learnspringframework.examples.c1.ClassA;

//지연초기화란?
/*
 	- Spring Bean의 기본초기화는 즉시 초기화 이다.
 	- @Lazy 어노테이션을 지정하지 않는 한, 각각의 Spring Bean은 시작할 때 즉시 초기화 된다.
 	- Spring 구성에 오류가 있을 경우 즉시 초기화를 사용하면 애플리케이션이 시작할 때 오류를 바로 확인 가능하기 때문에 즉시 초기화 추
 	- 지연초기화는 자주 사용되지 않는다. -> 복잡한 초기화 논리가 많고 시작 시 지연시키고 싶지 않은 상황일때 Spring bean 지연 초기화 고려 
 	
 
 
 
 */



@Component
//Bean 생김  
class ClassA {

}




@Component
@Lazy
//Bean이 자동으로 초기화 되는 것 방지(Bean을 지연하여 초기화할지 여부)
//ClassB Bean이 시작할 때 초기화 되지 않는다.(사용할때 초기화 됨)
//사용하려고 할때만 로딩
/*
class ClassB {
	
	private ClassA classA;
	
	public Class ClassB(ClassA classA) {
		//Logic
		//classA Bean을 사용하여 초기화
		//Bean을 로드하지 않고 Bean에서 메서드를 호출하지 않더라도 자동으로 Bean이 초기화 된다. 
		System.out.println("Some Initialization logic ");
		this.classA = classA;
	}
	
}
*/
public void doSomething() {
	System.out.println("Do something in here");
}



@Configuration
@ComponentScan//("com.in28minutes.learnspringframework.examples.a1;") 패키지가 같을 경우에는 명시적으로 정의해 줄 필요가 없다 
public class LazyInitializationLauncherApplication {

	public static void main(String[] args) {

		
		try(var context = 
				new AnnotationConfigApplicationContext
				(LazyInitializationLauncherApplication.class)){

				System.out.println("Initialization of context is completed");
				context.getBean(ClassB.class).doSomething();
			
		}
		
			

	}

}
