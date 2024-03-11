package com.in28minutes.learnspringframework.examples.h1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.in28minutes.learnspringframework.game.GameRunner;



//@Configuration
//@ComponentScan//("com.in28minutes.learnspringframework.examples.a1;") 패키지가 같을 경우에는 명시적으로 정의해 줄 필요가 없다
//이 클래스는 contextCongifuration.xml 파일이 역할을 해주고 있기 때문에 어노테이션이 필요 없음 
//XML을 자주 사용하지 않는다(어노테이션을 사용하기 때문에)
//하지만 오래된 프로젝트에서 사용하기 때문에 알고 있으면 유용함. 

/*
 Anotations vs XML Configuration
 
 
 
 
 
 
 
 
 
 
 */

public class XmlConfigurationContextLauncherApplication {

	public static void main(String[] args) {

		
		try(var context = 
				new ClassPathXmlApplicationContext
				("contextCongifuration.xml")){ // Spring context 생성  

				Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
				
				System.out.println(context.getBean("name"));
				//bean에서 등록한 name Ranga 호출됨. 
				
				/*
				 	<bean id="name" class="java.lang.String">
						<constructor-arg value="Ranga" />
					</bean>
				 */
				context.getBean(GameRunner.class).run();
			
		}
		
			

	}

}
