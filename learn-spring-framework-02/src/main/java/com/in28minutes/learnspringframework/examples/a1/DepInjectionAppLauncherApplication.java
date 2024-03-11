package com.in28minutes.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan//("com.in28minutes.learnspringframework.examples.a1;") 패키지가 같을 경우에는 명시적으로 정의해 줄 필요가 없다 
public class DepInjectionAppLauncherApplication {


	/*
	 
	GameRunner 클래스에 @Component 어노테이션을 달아줌으로써 Bean을 따로 생성하지 않아도 됌(주석처리)  
	- 중요한점 : 코드의 양이 훨씬 줄었다는 것!
	 
	@Bean
	public GamingConsole game() {
		var game = new PacmanGame();
		return game;
	}
	
	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		System.out.println("Paramter:" + game);
		var gameRunner = new GameRunner(game);
		return gameRunner;
	}
	
	//PacmanGame에 @Conponent 어노테이션만 추가했을때 에러발생
	//NoSuchBeanDefinitionException
	//Spring이 game을 찾지 못했기 때문에 발생 -> @Component를 찾지 못함  
	//특정 패키지에서 PacmanGame을 검색해야 한다고 Spring프레임워크에게 알려줘야 함!! -> @ComponentScan으로 패키지 위치 알려
	//Spring이 PacmanGame의 인스턴스를 생성하고 이 인스턴스가 이곳에 와이어링 됐음  
	
	*/
	
	public static void main(String[] args) {
		
		//Spring 컨텍스트에서 Bean을 가져와 실행
		
		try(var context = 
				new AnnotationConfigApplicationContext
				(DepInjectionAppLauncherApplication.class)){

				Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
		}
		
			

	}

}
