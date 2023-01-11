package com.in28minutes.springboot.myfirstwebapp.loginAuthenticationService;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean isAuthenticated(String name, String password) {
		boolean isNameCorrect = name.equals("kerem");
		boolean isPasswordCorrect = password.equals("ersan");
		
		return isNameCorrect && isPasswordCorrect;
	}
}
