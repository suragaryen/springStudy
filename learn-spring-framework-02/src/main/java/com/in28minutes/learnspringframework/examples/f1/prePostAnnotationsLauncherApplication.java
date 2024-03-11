package com.in28minutes.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
class SomeClass{
	private SomeDependency someDependency;
		
	public SomeClass(SomeDependency someDependemcy) {
		super();
		this.someDependency = someDependemcy;
		System.out.println("All dependencies are ready");
		
	}
	
	@PostConstruct
	//Spring은 자동으로 의존성을 연결하고, 의존성을 자동연결하는 대로 PostConstruct를 어노테이션한 메서드를 호출.
	//초기화를 수행하기 위해 의존성이 주입이 완료된 후 실행해야 하는 메서드에 사용하며, 이 메서드는 클래스를 사용하기 전에 호출되어야 한다. 
	public void initialize() {
		someDependency.getReady();
	}
	@PreDestroy
	//컨테이너에서 Bean이 삭제되기 전에, 애플리케이션 컨텍스트에서 삭제되기전에 cleanup을 수행하려는 경우에는 PreDestroy어노테이션 사용  
	//활성화된 연결을 닫을 수 있다. 
	public void cleanup() {
		System.out.println("Cleanup");
	}
	

}



@Component
class SomeDependency{
	
	public void getReady() {
		System.out.println("Some logic using SomeDependency");
	}

	}



@Configuration
@ComponentScan//("com.in28minutes.learnspringframework.examples.a1;") 패키지가 같을 경우에는 명시적으로 정의해 줄 필요가 없다 
public class prePostAnnotationsLauncherApplication {

	public static void main(String[] args) {

		
		try(var context = 
				new AnnotationConfigApplicationContext
				(prePostAnnotationsLauncherApplication.class)){

				Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
		}
		
			

	}

}
