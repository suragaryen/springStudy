package com.in28minnutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticatte(String username, String password) {
		
		//equalsIgnoreCase = 대소문자를 무시하고 비교
		boolean isValidUserName = username.equalsIgnoreCase("a");
		boolean isValidUserPassword = password.equalsIgnoreCase("123");
		
		
		return isValidUserName && isValidUserPassword;
	}

}
