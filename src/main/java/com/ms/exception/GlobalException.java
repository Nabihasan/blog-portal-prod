package com.ms.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ms.dto.ApiResponse;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException exception) {

		String message = exception.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		
		Map<String,String> response =new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) ->{
			String fieldName= ((FieldError) error).getField();
			String message= error.getDefaultMessage();
			response.put(fieldName, message);
		});
		return new ResponseEntity<Map<String,String>>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmailExistException.class)
	public String existEmail(EmailExistException emailExitException) {
		return  emailExitException.getMessage();
	}
	
	  @ExceptionHandler(UserNotFoundException.class)
	    public CustomErrorResponse handleUserNotFoundException(
	            final UserNotFoundException ex) {
	        return new CustomErrorResponse(false, "User not found");
	    }

	  
	    @ExceptionHandler(IncorrectPasswordException.class)
	    public CustomErrorResponse handleIncorrectPasswordException(
	            final IncorrectPasswordException ex) {
	        return new CustomErrorResponse(false, "User Credentails are wrong");
	    }
}
