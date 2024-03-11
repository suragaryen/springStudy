package com.in28minnutes.springboot.learnjpaandhibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.in28minnutes.springboot.learnjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional//클래스의 각 메서드가 트랜잭션 컨텍스트 내에서 실행되도록 보장합니다. 즉, 메서드 중 하나가 실패하면 데이터 일관성을 유지하기 위해 트랜잭션이 롤백됩니다.
public class CourseJpaRepository {
	
	@PersistenceContext //Autowired  대신에 더 구체적인 어노테이션 사용  
	private EntityManager entityManager;//JPA에서 엔티티 관리를 담당하는 핵심 클래스 중 하나이며, 데이터베이스와의 상호 작용을 처리합니다.
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
}
