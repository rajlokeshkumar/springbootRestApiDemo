package com.example.restapidemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerSpringBoot {

	HttpStatus status = HttpStatus.NOT_FOUND;

//	@ExceptionHandler(value = Throwable.class)
//	public ResponseEntity<Object> exception(Throwable exception) {
//		return new ResponseEntity<>("System exception", HttpStatus.NOT_FOUND);
//	}
	
	@ExceptionHandler(value = UnableToCreateEmployeeException.class)
	public ResponseEntity<Object> unableToCreateEmployeeException(UnableToCreateEmployeeException e){
		System.out.println("UnableToCreateEmployeeException");
		return new ResponseEntity<>("Unable to Create Employee Please chack the details are valid", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = UnableToUpdateException.class)
	public ResponseEntity<Object> unableToUpdateException(UnableToUpdateException e){
		System.out.println("Unable to Update Please chack the details are valid");
		return new ResponseEntity<>("Unable to Update Please chack the details are valid", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = UnableToDeleteEmployeeException.class)
	public ResponseEntity<Object> unableToDeleteEmployeeException(UnableToDeleteEmployeeException e) {
		System.out.println("INSIDE UnableToDeleteEmployeeException HANDLER");
		return new ResponseEntity<>("Undable to Delete Employee please check employee exist", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = CrudException.class)
	static ResponseEntity<Object> urudException(CrudException e) {
		System.out.println("INSIDE EXCEPTION HANDLER");
		return new ResponseEntity<>("Unable to Create Employees PLease chack the details are valid", HttpStatus.NOT_FOUND);
	}

}
