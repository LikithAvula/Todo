package com.taskManager.Todo.Basic.Auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping
public class AuthenticationController {
	
	@GetMapping("/authenticate")
	public Authentcation AuthorizeUser() {
		return new Authentcation("user authorized");
	}

}