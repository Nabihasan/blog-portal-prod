package com.ms.userRepo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ms.dto.LoginRequest;
import com.ms.dto.UserDto;
import com.ms.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserRepo extends MongoRepository<User, String> {

//	User findByUsername(String userName);

	// List<User> findByUserName(String comEmail);

//	List<User> findByComEmail(String comEmail);
	
//	boolean existsByEmail(String email);
//	
//	Optional<LoginRequest> findByEmail(String email);
	 Optional<User> findByEmail(String email);
}
