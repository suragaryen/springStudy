package com.in28minnutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	//private static List<Todo> todos; //NullPointerException
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "udemy", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "udemy", "Learn java", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "udemy", "Learn springboot", LocalDate.now().plusYears(3), false));
		
		
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate 
		= todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}

	
	public void deleteById (int id) {
		//todo.getId() == id
	
		
		//람다함수 작성 순서 
		//bean이름 정의 -> 하이픈(->) -> 부등호 -> predicate 
		// todo -> todo.getId() == id
		//모든 행에 있는 모든 Bean 즉 Todo에 있는 모든 Bean에 대해 이 조건을 실행 
		
		//todos 리스트에서 id 값과 동일한 Todo 객체를 찾아 제거
		
		Predicate<? super Todo> predicate = todo -> todo.getId() == id ; //predicate 지역변수 생성
		
		todos.removeIf(predicate);
		//todos 리스트에서 predicate 조건을 만족하는 요소를 제거.
		//removeIf 메서드는 Predicate를 인수로 받아서 리스트 내의 요소를 조건에 따라 제거한다
		// 따라서 predicate에 해당하는 조건을 만족하는 요소만이 제거됨.
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate 
		= todo -> todo.getId() == id ; //predicate 지역변수 생성
		
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		
		
		
		//Stream 메서드는 데이터의 연속된 흐름을 다루는 개념입니다. 
		//이전에는반복 작업을 수행할 때 for 루프를 사용하여 요소를 하나씩 처리했지만, 
		//스트림을 사용하면 더욱 간결하고 효율적으로 데이터를 다룰 수 있다.
		
		
		/*
		todos 리스트를 스트림으로 변환한 후, filter 메소드를 사용하여 predicate 조건에 맞는 요소만 필터링합니다. 
		그리고 findFirst()를 호출하여 첫 번째로 해당하는 요소를 찾고, get()을 사용하여 해당 요소를 반환합니다.
		마지막으로, 찾은 Todo 객체를 반환합니다.
		이 메소드는 주어진 id에 해당하는 Todo 객체를 반환하며, 만약 해당하는 객체가 없을 경우 NoSuchElementException이 발생할 수 있으므로 주의해야 합니다.
		
		*/
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
		
	}
}
