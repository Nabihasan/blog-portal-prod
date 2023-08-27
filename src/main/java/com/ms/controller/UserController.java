package com.ms.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ms.dto.LoginRequest;
import com.ms.dto.UserDto;
import com.ms.entity.User;

import com.ms.service.UserService;

import jakarta.validation.Valid;

/**
 * 
 */
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/register")
	public User createUser(@RequestBody @Valid UserDto userDto) {
		return userService.createUser(userDto);
	}

//	@PostMapping
//	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
//		UserDto user = userService.addUser(userDto);
//		Pattern pattern = Pattern.compile("^[a-z]{2,}[.][a-z]{2,}+@nucleusteq.com$");
//		java.util.regex.Matcher matcher = pattern.matcher(userDto.getComEmail());
//		if (!matcher.matches()) {
//			return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
//		}
//
//		return new ResponseEntity<UserDto>(HttpStatus.CREATED);
//	}

//	@PostMapping("/login")
//	public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
//
//		List<User> users = userService.findByEmail(loginRequest.getEmail());
//
//		System.out.println(users);
//		for (User user : users) {
//
//			if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
//
//				return ResponseEntity.ok(user);
//
//			}
//		}
//
//		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//
//	}

	@PostMapping("/login")
	public ResponseEntity<String> userLogin(@RequestBody LoginRequest loginRequest) {

		if (userService.loginUser(loginRequest) == null) {

			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("incorrect login ID");

		}
		return ResponseEntity.ok(userService.loginUser(loginRequest).getFirstName() + "  login Successfully");

	}

}
