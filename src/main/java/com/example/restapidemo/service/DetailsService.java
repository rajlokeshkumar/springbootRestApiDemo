package com.example.restapidemo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.restapidemo.dto.EmployeeRequestDto;
import com.example.restapidemo.dto.EmployeeResponseDto;
import com.example.restapidemo.entity.Employee;
import com.example.restapidemo.exception.RollNumberNotFoundException;
import com.example.restapidemo.exception.UnableToDeleteEmployeeException;
import com.example.restapidemo.repository.EmployeeRepository;

@Component
public class DetailsService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public String getStudentName(String id) throws Throwable {

		Employee aEmployee = employeeRepository.findById(id).get();
		if (aEmployee == null) {
			throw new RollNumberNotFoundException();
		}
		return aEmployee.getName();
	}

	public Set<EmployeeResponseDto> getAllEmployeeDetails() {

		List<Employee> aEmployee = (List<Employee>) employeeRepository.findAll();

		Set<EmployeeResponseDto> aHashSet = new HashSet<>();

		for (Employee employee : aEmployee) {
			EmployeeResponseDto aEmployeeResponseDto = new EmployeeResponseDto();
			aEmployeeResponseDto.setAddress(employee.getAddress());
			aEmployeeResponseDto.setMobileNumber(employee.getMobileNumber());
			aEmployeeResponseDto.setName(employee.getName());
			aEmployeeResponseDto.setPincode(employee.getPincode());
			aEmployeeResponseDto.setRollnumber(employee.getRollnumber());
		}

		System.out.println("count" + aHashSet.size());
		return aHashSet;
	}

	public String updateEmployee(EmployeeRequestDto employee) {

//		EmployeeRequestDto emp = Emp
		return null;
	}

	public String updateEmployeeAddress(EmployeeRequestDto emplRequestDto) {

		Employee aEmployee = employeeRepository.findById(emplRequestDto.getRollnumber()).get();

		aEmployee.setAddress(emplRequestDto.getAddress());

		employeeRepository.save(aEmployee);

		return "success";

	}

	public String deleteEmployee(String id) throws Throwable {

		System.out.println("Delete Service");

		Boolean aEmployee = employeeRepository.findById(id).isPresent();

		System.out.println("Employee Availability" + aEmployee);

		if (!aEmployee) {
			throw new UnableToDeleteEmployeeException();
		}

		employeeRepository.delete(employeeRepository.findById(id).get());

		return "Success";

	}

}