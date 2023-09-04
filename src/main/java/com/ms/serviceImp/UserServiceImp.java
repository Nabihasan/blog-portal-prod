package com.ms.serviceImp;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ms.dto.LoginRequest;
import com.ms.dto.UserDto;
import com.ms.entity.User;
import com.ms.exception.EmailExistException;
import com.ms.exception.IncorrectPasswordException;
import com.ms.exception.UserNotFoundException;
import com.ms.outdto.LoginResponse;
import com.ms.outdto.SignupResponse;
import com.ms.service.UserService;
import com.ms.userRepo.UserRepo;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	 @Autowired
	  private PasswordEncoder passwordEncoder;
	 
	 @Override
	    public SignupResponse register(final UserDto userDto) {
	        String email = userDto.getEmail();
	        if (userRepo.findByEmail(email).isPresent()) {
	            throw new EmailExistException("Email already exists");
	        }
	        User user = new User();
	        user.setUserID(userDto.getUserID());
	        user.setFirstName(userDto.getFirstName());
	        user.setLastName(userDto.getLastName());
	        user.setContact(userDto.getContact());
	        user.setDesignation(userDto.getDesignation());
	        user.setGender(userDto.getGender());
	        user.setEmail(userDto.getEmail());
	        user.setRole("User");
	        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
	        userRepo.save(user);
	        SignupResponse response = new SignupResponse();
	        response.setSuccess(true);
	        response.setMessage("User Registered Successfully");
	        response.setUser(user);
	        return response;
	    }

	    /**
	     * This is login method.
	     * @param login
	     * @return LoginResponse
	     */
	    @Override
	    public LoginResponse login(final LoginRequest login) {
	        String email = login.getEmail();
	        String password = login.getPassword();
	        Optional<User> optionalUser = userRepo.findByEmail(email);
	        User user = optionalUser
	                .orElseThrow(() -> new UserNotFoundException("User not Found"));
	        if (!passwordEncoder.matches(password, user.getPassword())) {
	            throw new IncorrectPasswordException("incorrect Credential !!");
	        }
	        LoginResponse response = new LoginResponse();
	        response.setEmail(user.getEmail());
	        response.setUserID(user.getUserID());
	        response.setFirstname(user.getFirstName());
	        response.setRole(user.getRole());
	        return response;
	    }

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

//	@Override
//	public UserDto addUser(UserDto userDto) {
//
//		User user = this.dtoToUser(userDto);
//
//		User saveUser = userRepo.save(user);
//		System.out.println(user);
//		return this.userToDto(saveUser);
//	}
//
//	public User dtoToUser(UserDto userdto) {

		//User user = modelMapper.map(userdto, User.class);
//		user.setId(userdto.getId());
//		user.setUserName(userdto.getUserName());
//		user.setPassword(userdto.getPassword());
//		user.setComEmail(userdto.getComEmail());
//		user.setAbout(userdto.getAbout());
//		return user;
//
//	}
//
//	public UserDto userToDto(User user) {
//		UserDto userdto = modelMapper.map(user, UserDto.class);
//		userRepo.findById(user.getUserID());

		// userdto.setId(user.getId());
//		userdto.setUserName(user.getUserName());
//		userdto.setComEmail(user.getComEmail());
//		userdto.setPassword(user.getPassword());
//		userdto.setAbout(user.getAbout());
//		return userdto;
//	}

//	@Override
//	public List<User> findByComEmail(String comEmail) {
//		return userRepo.findByComEmail(comEmail);
//	}
//
//	@Override
//	public User createUser(UserDto userDto) {
//		if (userRepo.existsByEmail(userDto.getEmail())) {
//			throw new EmailExistException("email exist");
//		}
//		User user = new User();
//		user.setUserID(userDto.getUserID());
//		user.setFirstName(userDto.getFirstName());
//		 user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//		user.setEmail(userDto.getEmail());
//		user.setLastName(userDto.getLastName());
//		user.setContact(userDto.getContact());
//		user.setRole(userDto.getRole());
//
//		return userRepo.save(user);
//	}
//
//
//@Override
//public LoginRequest loginUser(LoginRequest loginRequest) {
//
//	LoginRequest login = userRepo.findByEmail(loginRequest.getEmail())
//			.orElseThrow(() -> new UserNotFoundException("User " + "doesnt exist"));
//	if (login != null && passwordEncoder.matches(loginRequest.getPassword(), login.getPassword())) {
//		return login;
//	}
//	return null;
//}
	
	

}
