package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacmanGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;


public class App03GamingSpringBeans {

	public static void main(String[] args) {
		
		//Spring 컨텍스트에서 Bean을 가져와 실행
		
		try(var context = 
				new AnnotationConfigApplicationContext
				(GamingConfiguration.class)){
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
		
		
//		var game = new PacmanGame();	//1: Object Creation
//		//var game = new MarioGame();
//		//var game = new SuperContraGame(); 
//		var gameRunner = new GameRunner(game); 
//		//2: Object Creation + Wiring of Dependencies
//		// Game is a Dependency of GameRunner 게임을 실행하려면 게임이 있어야 하므로 게임이 의존성이
//			gameRunner.run();

	}

}
