package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacmanGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

//Coupling / 강한결합  
/*
 * 	How much work is involved in changing something?
 *  결합 : 무언가를 변경하는데 얼마나 많은 작업이 관련되어 있는지에 대한 측정 
 * 
 *  GameRunner 클래스가 특정 게임과 강하게 결합되어 있다(마리오게임에서 수퍼콘트라 게임으로 바꾸는것이 쉽지 않음)
 * 	예시)
 * 	An engine is tightly coupled to a Car -> 자동차에서 엔진은 쉽게 바꿀 수 없는 (강한결합) 
 *  A wheel is loosely coupled to a Car -> 자동차에서 바퀴는 쉽게 바꿀 수 있음 (느슨한결합) 
 * 
 * - 결합은 소프트웨어를 구축할 때 중요한 부분 
 * - 비지니스, 프레임워크, 코드, 등 모든것들이 변화하기때문에 가능한 느슨한 결합으로 쉽게 변화를 줄 수 있어야 한다 
 * - 가능한 코드를 적게 변경하며 기능을 변경할 수 있어야 한
 * 
 * */
//프로그래머가 명시적으로 코드를 작성하여 의존성을 통해 객체 생성  
public class App01GamingBagic {

	public static void main(String[] args) {
		var game = new PacmanGame();	//1: Object Creation
		//var game = new MarioGame();
		//var game = new SuperContraGame(); 
		var gameRunner = new GameRunner(game); 
		//2: Object Creation + Wiring of Dependencies
		// Game is a Dependency of GameRunner 게임을 실행하려면 게임이 있어야 하므로 게임이 의존성이
			gameRunner.run();

	}

}
