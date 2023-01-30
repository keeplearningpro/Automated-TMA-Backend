package com.example.AutomatedTalentManagementApp.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AutomatedTalentManagementApp.model.AuthenticationUser;

@CrossOrigin("*")
@RestController
@RequestMapping("/security")
public class AuthenticationController {
	

	@GetMapping("/validatelogin")
	public AuthenticationUser validateLogin() {
		return new AuthenticationUser("User successfully authenticated");
	}

}
