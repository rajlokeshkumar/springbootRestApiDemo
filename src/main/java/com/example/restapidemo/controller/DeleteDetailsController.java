package com.example.restapidemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapidemo.service.DetailsService;

@RestController
public class DeleteDetailsController {

	@Autowired
	private DetailsService detailsService;

	@DeleteMapping(path = "deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") String id) throws Throwable {

		System.out.println("Entering into delete Method");

		String msg = detailsService.deleteEmployee(id);
		
		System.out.println("DELETE MESSAGE: " + msg);
		return new ResponseEntity<>("OK", HttpStatus.OK);

	}

}