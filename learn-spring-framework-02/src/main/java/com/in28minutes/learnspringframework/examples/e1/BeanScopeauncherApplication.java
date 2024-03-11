package com.in28minutes.learnspringframework.examples.e1;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/*
 Bean의 Scope
싱글톤과 프로토 타입의 차이
1. 싱글톤
- 싱글톤은 오직 하나의 인스턴스만을 생성하고, 그 인스턴스에 대한 접근을 제공하는 패턴입니다.
- 주로 어떤 클래스가 딱 하나의 인스턴스만 필요하고, 그 인스턴스를 여러 곳에서 공유하여 사용할 때 사용됩니다. 
- 예를 들어, 설정 관리자, 로깅 시스템, 캐시 등이 싱글톤 패턴을 사용할 수 있습니다.
- 보통은 전역 변수를 사용하여 인스턴스에 접근합니다.

2. 프로토타입
- 객체를 생성하는 데에 템플릿 역할을 하는 클래스를 정의하는 패턴입니다.
- 새로운 객체를 생성하기 위해 기존 객체를 복제합니다. 이는 객체 생성에 필요한 초기화 과정이 복잡하거나 비용이 많이 들 때 유용합니다.
- 각 객체가 독립적으로 존재해야 하고, 서로 다른 상태를 가질 필요가 있는 경우에 사용됩니다. 
- 예를 들어, 게임에서 캐릭터를 생성할 때 각 캐릭터는 서로 다른 상태를 가지게 됩니다.
 
 
 
 */




@Component
class NormalClass{
	
}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//프로토타입 클래스 : 다른 객체를 만들기 위한 기본틀 또는 모델을 제공하는 클래스  
@Component
class PrototypeClass{
	
	
}

@Configuration
@ComponentScan//("com.in28minutes.learnspringframework.examples.a1;") 패키지가 같을 경우에는 명시적으로 정의해 줄 필요가 없다 
public class BeanScopeauncherApplication {

	
	public static void main(String[] args) {
		
		//Spring 컨텍스트에서 Bean을 가져와 실행
		
		try(var context = 
				new AnnotationConfigApplicationContext
				(BeanScopeauncherApplication.class)){
			
				System.out.println(context.getBean(NormalClass.class));
				System.out.println(context.getBean(NormalClass.class)); // 해시코드 일치 (같은 인스턴스 호출) 
			
				System.out.println(context.getBean(PrototypeClass.class)); 
				System.out.println(context.getBean(PrototypeClass.class));
				System.out.println(context.getBean(PrototypeClass.class)); //3개가 각자 다른 해시코드가 출력된다
																		   // 매번 Spring 컨텍스트에서 새로운 Bean을 가져온다  
																		  //Bean을 참조할 때마다 매번 다른 인스턴스를 생성할 경우 프로토 타입 사용 
			
		}
		
			

	}

}
