package com.in28minnutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	// 모든 사용자 검색
	// 특정 사용자의 상세정보 저장
	// 정적 ArrayList를 만들고 UserDaoService를 활용해 ArrayList와 소통

	private static List<User> users = new ArrayList<>();
	private static int userCount = 0;

	static {
		users.add(new User(++userCount, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(++userCount, "Eve", LocalDate.now().minusYears(25)));
		users.add(new User(++userCount, "jal", LocalDate.now().minusYears(31)));
	}

	public List<User> findAll() {
		return users;
	}

	public User findOne(int id) {

		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);

	}

	public void deleteById(int id) {

		Predicate<? super User> predicate = user -> user.getId().equals(id);
		
		users.removeIf(predicate); //주어진 아이디 값이 같다면 해당 사용자 삭제  

	}

	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}

}
