package com.example.restapidemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapidemo.dto.EmployeeRequestDto;
import com.example.restapidemo.service.DetailsService;

@RestController
public class CreateDetailsController {
	
	@Autowired
	private DetailsService detailsService;
	
//    @GetMapping("/newEmployee")
//    public String add(Model model) {
//        model.addAttribute("employee", new EmployeeRequestDto());
//        return "new";
//    }
	
	@PostMapping(path = "createEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> processUpdate(@RequestBody EmployeeRequestDto employeeRequestDto) {
		System.out.println("employeeRequestDto: "+employeeRequestDto);
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}

}
