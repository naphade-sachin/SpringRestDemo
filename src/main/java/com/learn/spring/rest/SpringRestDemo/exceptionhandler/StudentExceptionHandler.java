package com.learn.spring.rest.SpringRestDemo.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.learn.spring.rest.SpringRestDemo.exception.StudentErrorResponse;
import com.learn.spring.rest.SpringRestDemo.exception.StudentNotFoundException;

@ControllerAdvice
public class StudentExceptionHandler {

	//Method to Handle StudentNotFoundException
		 @ExceptionHandler
		 public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exe){
			 StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
			 studentErrorResponse.setHttp_status(HttpStatus.NOT_FOUND.value());
			 studentErrorResponse.setMessage(exe.getMessage());
			 studentErrorResponse.setTimeStamp(System.currentTimeMillis());
			 return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
		 }
		 
		 
		//Method to Handle StudentNotFoundException
			 @ExceptionHandler
			 public ResponseEntity<StudentErrorResponse> handleException(Exception exe){
				 StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
				 studentErrorResponse.setHttp_status(HttpStatus.BAD_REQUEST.value());
				 studentErrorResponse.setMessage(exe.getMessage());
				 studentErrorResponse.setTimeStamp(System.currentTimeMillis());
				 return new ResponseEntity<>(studentErrorResponse,HttpStatus.BAD_REQUEST);
			 }
}
