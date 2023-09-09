package com.ms.exception;

import java.util.ArrayList;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * This is @GlobalExceptionhandler class.
 */
@RestControllerAdvice
public class GlobalExceptionhandler {
    /**
     * This is @existEmail method.
     * @param ex
     * @return obj
     */
    @ExceptionHandler(EmailExistException.class)
    public ResponseEntity<CustomErrorResponse> handleEmailAlreadyExist(
            final EmailExistException ex) {
        CustomErrorResponse res = new CustomErrorResponse(false,
                ex.getMessage());
        return new ResponseEntity<>(res, HttpStatus.CONFLICT);
    }

    /**
     * This is @handleMethodArgumentNotValidException method.
     * @param ex
     * @return obj
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomApiResponse> handleMethodArgumentNotValidException(
            final MethodArgumentNotValidException ex) {
        List<String> response = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String message = error.getDefaultMessage();
            response.add(message);
        });
        CustomApiResponse res = new CustomApiResponse(false, response);
        return new ResponseEntity<CustomApiResponse>(res,
                HttpStatus.BAD_REQUEST);
    }

    /**
     * This is @handleUserNotFoundException method.
     * @param ex
     * @return CustomErrorResponse object
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleUserNotFoundException(
            final UserNotFoundException ex) {
        CustomErrorResponse res = new CustomErrorResponse(false,
                "User not found");
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

    /**
     * This is @handleIncorrectPasswordException method.
     * @param ex
     * @return CustomErrorResponse object
     */
    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<CustomErrorResponse> handleIncorrectPasswordException(
            final IncorrectPasswordException ex) {
        CustomErrorResponse res = new CustomErrorResponse(false,
                "User Credentails are wrong");
        return new ResponseEntity<>(res, HttpStatus.UNAUTHORIZED);
    }

    /**
     * This is resourceNotFoundException method.
     * @param exception
     * @return
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> resourceNotFoundException(
            ResourceNotFoundException exception) {
        String message = exception.getMessage();
        CustomErrorResponse apiResponse = new CustomErrorResponse(false,
                message);
        return new ResponseEntity<CustomErrorResponse>(apiResponse,
                HttpStatus.NOT_FOUND);
    }

    /**
     * This is handleMessageNotReadableException method.
     * @param ex
     * @return CustomErrorResponse
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<CustomErrorResponse> handleMessageNotReadableException(
            HttpMessageNotReadableException ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(false,
                "Technology name is not valid!");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
