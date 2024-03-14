package com.in28minnutes.springboot.myfirstwebapp.security;

import static org.springframework.security.config.Customizer.withDefaults;
//Spring Security 구성에 대한 기본 설정을 적용하는 데 사용
//명시적으로 구성을 지정하지 않고도 일반적인 보안 구성을 간편하게 적용
//

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //spring bean 설정  
public class SpringSecurityConfiguration {
	//LDAP or Database
	// In Memory
	
	//InMemoryUserDetailsManager
	//inMemoryUserDetailsManager(UserDetails...users)
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailManager() {
	
	//InMemoryUserDetailsManager
	//사용자의 인증 및 권한부여 처리. 
	//개발자가 사용자의 상세 정보를 코드 내에 직접 정의하고 구성
	//간단한 애플리케이션 또는 개발 및 테스트 목적으로 사용될 수 있다. 

		
		UserDetails userDetails1 = createNewUser("soo", "1234");
		UserDetails userDetails2 = createNewUser("loo", "1234");
		
		return new InMemoryUserDetailsManager(userDetails1, userDetails2 );
	}


	//createNewUser: 사용자 이름과 비밀번호를 사용하여 UserDetails 객체를 생성
	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder
		= input -> passwordEncoder().encode(input);
		//받은 문자열을 passwordEncoder() 메서드로 전달하여 암호화한 후 반환.
		//비밀번호를 입력받아 BCryptPasswordEncoder를 사용하여 암호화한 결과를 반환하는 함수
		
		UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder)
		.username(username)
		.password(password)
		.roles("USER", "ADMIN")
		.build();
		return userDetails;
		
		
		/*
		 
		 org.springframework.security.core.userdetails.UserDetails
		 
		 Spring Security는 UserDetails 인터페이스의 구현체를 직접적으로 보안 목적으로 사용하지는 않습니다. 
		 대신에 UserDetails 인터페이스의 구현체는 사용자 정보를 저장하고 나중에 Authentication 객체로 캡슐화됩니다. 
		 이를 통해 보안과 관련이 없는 사용자 정보(예: 이메일 주소, 전화번호 등)를 편리한 위치에 저장할 수 있습니다.
		 
		 Authentication에서 사용자의 정보값을 불러올 수 있음. 
		 
		 
		 */
		
		
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	// SecurityFilterChain
	//아무것도 설정하지 않았을때 기본값으로 셋팅 되는 것 
	//1. All URLs are protected
	//2. A login form is shown for unauthorized requests 승인되지 않은 요청에 대해서 로그인 양식 표시 
	//CSRF disable -> H2Database에 접근하려면 CSRF를 비활성 해주어야 한다. 
	//Frames 
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		//HttpServeltRequest에 매칭될 수 있는 필터 체인을 정의
		// 웹요청이 들어오면 언제나 이 체인이 먼저 처리 한다
		//ex ) 로그아웃 상태로 페이지를 요청하면 로그인 폼이 뜨는 것 
		
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		http.csrf().disable();
		http.headers().frameOptions().disable();
		return http.build();
		//command + shift + t 
		//command + o
		
		
	}
	
	

	
	
}
