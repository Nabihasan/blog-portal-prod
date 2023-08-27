package com.ms.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {
	
	@Pattern(regexp  = "^[a-z]{2,}[.][a-z]{2,}+@nucleusteq.com$")
	private String email;
	private String password;
	private String firstName;
	

}