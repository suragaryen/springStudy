package com.in28minutes.learnspringframework.game;

public class GameRunner {
		//MarioGame game;
		GamingConsole game;
		
		public GameRunner(GamingConsole game) {
			this.game = game;
		}


		public void run() {
			System.out.println("Running game: " + game);
			//System.out 보다 로깅 프레임워크를 사용하는것이 좋다  
			game.up();
			game.down();
			game.left();
			game.right();
			
		}
	
}
