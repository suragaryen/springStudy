package com.in28minutes.learnspringframework.examples.g1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//import com.in28minutes.learnspringframework.examples.c1.DataService;

import jakarta.inject.Inject;
import jakarta.inject.Named;

/*
 CDI
 어노테이션 그룹을 정의한 구현
 inject = Autowired
 Named = Component
 
*/



//@Component
@Named

class BusinessService{
	private DataService dataService;

	
	
	public DataService getDataService() {
		
		return dataService;
	}


	//@Autowired
	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("Setter Injection");
		this.dataService = dataService;
	}
	
	
}

@Component
class DataService{
	
}

@Configuration
@ComponentScan//("com.in28minutes.learnspringframework.examples.a1;") 패키지가 같을 경우에는 명시적으로 정의해 줄 필요가 없다 
public class CdiContextLauncherApplication {

	public static void main(String[] args) {

		
		try(var context = 
				new AnnotationConfigApplicationContext
				(CdiContextLauncherApplication.class)){

				Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
				
				System.out.println(context.getBean(BusinessService.class)
						.getDataService());
			
		}
		
			

	}

}
