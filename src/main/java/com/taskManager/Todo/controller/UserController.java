package com.taskManager.Todo.controller;

import static com.sun.tools.sjavac.Log.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskManager.Todo.Service.UserService;
import com.taskManager.Todo.entitiy.User;

import jdk.internal.org.jline.utils.Log;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping
public class UserController {

	private static final Void Void = null;

	@Autowired
	public UserService userService;

	private BCryptPasswordEncoder encoder;

	@GetMapping("/todo/{userName}")
	public User getUser(@PathVariable String userName) {
		User user = userService.getUserDetails(userName);
		if (user != null) {
			return user;
		} else {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", userName));
		}
	}

	@PostMapping("/todo/addUser")
	public HttpStatus createNewUser(@RequestBody User user) {
		encoder = new BCryptPasswordEncoder();
		try {
			if (user.getPassword() != null) {
				user.setPassword(encoder.encode(user.getPassword()));
				userService.createAccount(user);
			}
			System.out.println(new ResponseEntity<Void>(Void, HttpStatus.OK));
			return HttpStatus.OK;
		} catch (Exception e) {
			e.printStackTrace();
			return HttpStatus.BAD_REQUEST;
		}

	}

	@DeleteMapping("/todo")
	public void deleteUser() {

	}

	@PutMapping("/todo/editUser/{newPassword}")
	public HttpStatus editUser(@RequestBody User user, @PathVariable String newPassword) {
		try {
			encoder = new BCryptPasswordEncoder();
			User dataBaseUser = userService.getUserDetails(user.getUserName());
			if (encoder.matches(dataBaseUser.getPassword(), user.getPassword())
					&& user.getDateOfBirth().equals(dataBaseUser.getDateOfBirth())) {
				info("password match's for user : " + user.getUserName());
				user.setPassword(newPassword);
				userService.editAccount(user);
			}
			return HttpStatus.OK;
		} catch (Exception e) {
			Log.error(e);
			return HttpStatus.BAD_REQUEST;
		}

	}

}
