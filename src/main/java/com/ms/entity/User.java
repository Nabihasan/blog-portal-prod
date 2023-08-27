package com.ms.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

	@Id
	private String userID;
	@Pattern(regexp  = "^[a-z][.][a-z]+@nucleusteq.com$")
	private String firstName;
	private String lastName;
	private String contact;
	private String role;
	private String email;
	private String password;
	private String gender;
	
	@DBRef
	private String post;

}
