package com.example.restapidemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.restapidemo.dto.EmployeeRequestDto;
import com.example.restapidemo.entity.Employee;
import com.example.restapidemo.repository.EmployeeRepository;

@Component
public class DetailsService {

@Autowired
private EmployeeRepository employeeRepository;	
	
	
public String getStudentName(String id) {
	
	Employee aEmployee=employeeRepository.findById(id).get();
	return aEmployee.getName();
}
	
public String updateEmployeeAddress(EmployeeRequestDto emplRequestDto) {
	
	Employee aEmployee=employeeRepository.findById(emplRequestDto.getId()).get();
	
	aEmployee.setAddress(emplRequestDto.getAddress());
	
	employeeRepository.save(aEmployee);
	
	return "success";
	
}


}
