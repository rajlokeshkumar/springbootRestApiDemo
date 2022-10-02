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

	public Employee getEmployeeDetails(String id) {
		Employee aEmployee = employeeRepository.findById(id).get();
		return aEmployee;
	}

	public String saveEmployee(EmployeeRequestDto emplRequestDto) {
		Employee employee = new Employee();
		employee.setRollnumber(emplRequestDto.getId());
		employee.setName(emplRequestDto.getName());
		employee.setPincode(emplRequestDto.getPincode());
		employee.setAddress(emplRequestDto.getAddress());
		employee.setMobileNumber(emplRequestDto.getMobileNumber());
		employeeRepository.save(employee);
		return "Success";
	}

	public String updateEmployee(EmployeeRequestDto emplRequestDto) {
		Employee employee = employeeRepository.findById(emplRequestDto.getId()).get();
		employee.setName(emplRequestDto.getName());
		employee.setAddress(emplRequestDto.getAddress());
		employee.setPincode(emplRequestDto.getPincode());
		employeeRepository.save(employee);
		return "success";
	}

	public String deleteEmployee(String id) {

		Boolean emp = employeeRepository.existsById(id);
		if (emp) {
			employeeRepository.deleteById(id);
			return "Success";
		}

		return "not exist";
	}

}
