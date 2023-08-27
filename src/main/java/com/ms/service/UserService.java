package com.ms.service;

import java.util.List;

import com.ms.dto.LoginRequest;
import com.ms.dto.UserDto;
import com.ms.entity.User;

public interface UserService {
	UserDto addUser(UserDto user);

	//List<User> findByEmail(String email);
//	List<User> findByUsernames(String userName);
	User createUser(UserDto userDto);

	
	public LoginRequest loginUser(LoginRequest loginRequest);
}
