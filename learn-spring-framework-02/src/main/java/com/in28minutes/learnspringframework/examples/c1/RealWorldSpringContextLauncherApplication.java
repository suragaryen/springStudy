package com.in28minutes.learnspringframework.examples.c1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan//("com.in28minutes.learnspringframework.examples.a1;") 패키지가 같을 경우에는 명시적으로 정의해 줄 필요가 없다 
public class RealWorldSpringContextLauncherApplication {

	public static void main(String[] args) {

		
		try(var context = 
				new AnnotationConfigApplicationContext
				(RealWorldSpringContextLauncherApplication.class)){

				Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
				
				System.out.println(
				context.getBean(BusinessCalculationService.class).findMax());
		}
		
			

	}

}
