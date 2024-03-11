package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.PacmanGame;

@Configuration
public class GamingConfiguration {
	
		@Bean
		public GamingConsole game() {
			var game = new PacmanGame();
			return game;
		}
		
		
		
		@Bean
		public GameRunner gameRunner(GamingConsole game) {
			var gameRunner = new GameRunner(game);
			return gameRunner;
		}
		
		
		
		
		
		
		
	//var game = new MarioGame();
			//var game = new SuperContraGame(); 
			//var gameRunner = new GameRunner(game); 
			//2: Object Creation + Wiring of Dependencies
			// Game is a Dependency of GameRunner 게임을 실행하려면 게임이 있어야 하므로 게임이 의존성이
			//	gameRunner.run();

}
