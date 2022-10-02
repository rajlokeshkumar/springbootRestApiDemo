package com.example.restapidemo.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapidemo.entity.Employee;
import com.example.restapidemo.service.DetailsService;

@RestController
public class GetDetailsController {

	@Autowired
	private DetailsService detailsService;
	
	@GetMapping(path = "employee" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getEmployeeDetails(@RequestParam String id) {
		Employee name=detailsService.getEmployeeDetails(id);
		return new ResponseEntity<>(name,HttpStatus.OK);
	}

	@GetMapping(path = "employee/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getEmployeeDetailsPathVariable(@PathVariable String id) {
		Employee name=detailsService.getEmployeeDetails(id);
		return new ResponseEntity<>(name,HttpStatus.OK);
	}
	
	@GetMapping(path = "employee1" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getEmployeeDetailsPathParam(@PathParam("id") String id) {
		Employee name=detailsService.getEmployeeDetails(id);
		return new ResponseEntity<>(name,HttpStatus.OK);
	}
	
}