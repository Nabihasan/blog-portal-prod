package com.ms.outdto;

import java.util.HashMap;
import java.util.Map;

import com.ms.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignupResponse {

	private String message;

	private boolean success;

//	private User user;

	public Map<String, Object> customReponse() {
		Map<String, Object> map = new HashMap<>();
		map.put("message", message);
		map.put("success", success);
		//map.put("User", user);
		return map;
	}

	public SignupResponse(final String message, final boolean success) {
		super();
		this.message = message;
		this.success = success;
	}
}
