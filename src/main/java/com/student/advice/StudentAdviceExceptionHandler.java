package com.student.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.student.exception.StudentNotFounderException;


@RestControllerAdvice
public class StudentAdviceExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArguement(MethodArgumentNotValidException ex){
		
		Map<String, String> errorMap = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			
			errorMap.put(error.getField(),error.getDefaultMessage());
			
		});
		
		return errorMap;
		
	}
	
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(StudentNotFounderException.class)
	public Map<String , String> handleBussinessException( StudentNotFounderException ex){
		
		Map<String, String> errorMap = new HashMap<>();
		
		errorMap.put("errorMessage",ex.getMessage());
		
		return errorMap;
		
	}

}
