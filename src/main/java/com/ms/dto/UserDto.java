package com.ms.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	
	private String userID;
	@NotEmpty(message="required")
	private String firstName;
	@NotEmpty(message="required")
	@Pattern(regexp = "^[a-z]{2,}[.][a-z]{2,}+@nucleusteq.com$")
	private String email;
	private String lastName;
	private String contact;
	private String role;
	@NotEmpty(message="required")
	private String password;
	private String gender;
	public Object getAbout() {
		// TODO Auto-generated method stub
		return null;
	}

}

