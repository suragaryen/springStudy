package com.in28minnutes.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	private UserDaoService service;
	
	public UserResource (UserDaoService service) {
		this.service = service;
	}
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll(); 
	}
	
	//Hateoas
	//EntityModel 도메인 객체를 랩핑하여 링크를 추가 
	//WebMvcLinkBuilder
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUsers(@PathVariable int id){
	// EntityModel 클래스는 HATEOAS(Hypermedia as the Engine of Application State) 디자인 원칙을 따르는 RESTful API에서 사용
	//
		
		User user = service.findOne(id);
		
		if(user==null)
			throw new UserNotFoundException("id:" + id);
		
		EntityModel<User> entityModel = EntityModel.of(user);//특정 객체를 표현하고 이를 위한 링크를 포함하는데 사용
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));//링크에 관계(rel)를 추가하여 클라이언트가 이 링크의 의미를 이해할 수 있도록 함. 
		//컨트롤러 메소드를 가리키는 링크를 생성. 
		// 링크 생성 및 관리를 쉽게 할 수 있도록 도와줌 
		
		return entityModel; 
	} 
	
	@DeleteMapping("/users/{id}")
	public void deleteUsers(@PathVariable int id){
			service.deleteById(id);
			//삭제 작업이 완료되면 200 반환

	} 
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) { //웹 요청을 보낼 때 요청 본문을 보냄 .
		//사용자가 생성되면 201을 반환하게 한 후 생성된 리소스의 location 값을 응답값 헤더에 넣어서 반환. 
		
		
		User savedUser = service.save(user); 
		// /users/4 => /users /{id}, user.getID
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{/id}") //요청에 추가하고싶은 
				.buildAndExpand(savedUser.getId()) //변수를({/id}) 생성된 사용자의 아이디로 바꿔줌  
				.toUri(); //Url 로 변환하고 반환 
		return ResponseEntity.created(location).build();

		
		// /user/id ->url 반환하기 
	}
	
	
}
