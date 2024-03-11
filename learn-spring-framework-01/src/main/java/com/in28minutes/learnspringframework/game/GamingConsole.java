package com.in28minutes.learnspringframework.game;


//GameRunner 클래스가 GamingConsole 이라는 인터페이스와 상호작용하도록 하고
//모든 게임 클래스가 GamingConsole 인터페이스를 도입하도록 해보자 

public interface GamingConsole {
	void up();
	void down();
	void left();
	void right();
}
