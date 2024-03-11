package com.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
//어노테이션 기반의 Configuration과 클래스패스 스캐닝을 사용할 때, 자동 감지에 대한 후보로 간주  
//Spring이 우리에게 PacmanGame의 인스턴스를 생성해주는 것 
//GamingConsole로 auto wiring 해준다 
public class PacmanGame implements GamingConsole{

	
	public void up() {
		System.out.println("up!!");
		
	}
	
	
	public void down() {
		System.out.println("Sit down!!");
	}
	
	public void left() {
		System.out.println("Go back!!");
	}
	
	public void right() {
		System.out.println("Shoot a bullet!!");
	}

}
