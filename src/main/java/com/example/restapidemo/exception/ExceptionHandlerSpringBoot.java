package com.example.restapidemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerSpringBoot {

//	@ExceptionHandler(value = Throwable.class)
//	public ResponseEntity<Object> exception(RollNumberNotFoundException exception) {
//		return new ResponseEntity<>("rollnumber not found", HttpStatus.NOT_FOUND);
//	}
//
//	@ExceptionHandler(value = Throwable.class)
//	public ResponseEntity<Object> exception(Throwable exception) {
//		return new ResponseEntity<>("System exception", HttpStatus.NOT_FOUND);
//	}

	@ExceptionHandler(value = Throwable.class)
	public ResponseEntity<Object> UnableToDeleteEmployeeException(UnableToDeleteEmployeeException e) {
		System.out.println("INSIDE EXCEPTION HANDLER");
		return new ResponseEntity<>("Undable to Delete Employee please check employee exist", HttpStatus.NOT_FOUND);
	}

}
