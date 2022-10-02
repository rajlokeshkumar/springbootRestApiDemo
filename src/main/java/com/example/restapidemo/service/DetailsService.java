package com.example.restapidemo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.restapidemo.dto.EmployeeRequestDto;
import com.example.restapidemo.dto.EmployeeResponseDto;
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


public Set<EmployeeResponseDto> getAllEmployeeDetails() {
	List<Employee> aEmployee=(List<Employee>) employeeRepository.findAll();
	Set<EmployeeResponseDto> aHashSet=new HashSet<>();
	//for loop old loop
	for(int i=0;i<aEmployee.size();i++) {
		EmployeeResponseDto aEmployeeResponseDto=new EmployeeResponseDto();
		aEmployeeResponseDto.setAddress(aEmployee.get(i).getAddress());
		aEmployeeResponseDto.setMobileNumber(aEmployee.get(i).getMobileNumber());
		aEmployeeResponseDto.setName(aEmployee.get(i).getName());
		aEmployeeResponseDto.setPincode(aEmployee.get(i).getPincode());
		aEmployeeResponseDto.setRollnumber(aEmployee.get(i).getRollnumber());
		System.out.println(aHashSet.add(aEmployeeResponseDto));
		System.out.println(aEmployee.get(i).getName());
	}
	System.out.println("count"+aHashSet.size());
	return aHashSet;
}

	
public String updateEmployeeAddress(EmployeeRequestDto emplRequestDto) {
	
	Employee aEmployee=employeeRepository.findById(emplRequestDto.getRollnumber()).get();
	
	aEmployee.setAddress(emplRequestDto.getAddress());
	
	employeeRepository.save(aEmployee);
	
	return "success";
	
}


}
