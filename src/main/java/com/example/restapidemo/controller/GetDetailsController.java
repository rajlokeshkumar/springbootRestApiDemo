package com.example.restapidemo.controller;

import java.util.Set;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapidemo.dto.EmployeeResponseDto;
import com.example.restapidemo.exception.RollNumberNotFoundException;
import com.example.restapidemo.service.DetailsService;

@RestController
public class GetDetailsController {


	@Autowired
	private DetailsService detailsService;
	
	
	@GetMapping(path = "employee" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getEmployeeDetails(@RequestParam String id) throws Throwable {
		String name=detailsService.getStudentName(id);
		return new ResponseEntity<>(name,HttpStatus.OK);
	}
	
	@GetMapping(path = "employee/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getEmployeeDetailsPathVariable(@PathVariable String id) throws Throwable {
		String name=detailsService.getStudentName(id);
		return new ResponseEntity<>(name,HttpStatus.OK);
	}
	
	@GetMapping(path = "employee1" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getEmployeeDetailsPathParam(@PathParam("id") String id) throws Throwable {
		String name=detailsService.getStudentName(id);
		return new ResponseEntity<>(name,HttpStatus.OK);
	}
	
	@GetMapping(path = "employeeDetails" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<EmployeeResponseDto>> getAllEmployeeDetails() {
		Set<EmployeeResponseDto> aEmployee=detailsService.getAllEmployeeDetails();
		return new ResponseEntity<>(aEmployee,HttpStatus.OK);
	}
	
}
