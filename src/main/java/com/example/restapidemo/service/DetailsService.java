package com.example.restapidemo.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

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

		Set<EmployeeResponseDto> aArrayList = new TreeSet<>();

		for (Employee employee : aEmployee) {
			EmployeeResponseDto aEmployeeResponseDto = new EmployeeResponseDto();
			aEmployeeResponseDto.setAddress(employee.getAddress());
			aEmployeeResponseDto.setMobileNumber(employee.getMobileNumber());
			aEmployeeResponseDto.setName(employee.getName());
			aEmployeeResponseDto.setPincode(employee.getPincode());
			aEmployeeResponseDto.setRollnumber(employee.getRollnumber());
			System.out.println(aArrayList.add(aEmployeeResponseDto));
			System.out.println(employee.getName());
		}

		System.out.println("count" + aArrayList.size());
		return aArrayList;
	}

	public Map<Integer, EmployeeResponseDto> getAllEmployeeDetailsInMap() {

		List<Employee> aEmployee = (List<Employee>) employeeRepository.findAll();
		Map<Integer, EmployeeResponseDto> aMaps = new TreeMap<>();
		for (Employee employee : aEmployee) {
			EmployeeResponseDto aEmployeeResponseDto = new EmployeeResponseDto();
			aEmployeeResponseDto.setAddress(employee.getAddress());
			aEmployeeResponseDto.setMobileNumber(employee.getMobileNumber());
			aEmployeeResponseDto.setName(employee.getName());
			aEmployeeResponseDto.setPincode(employee.getPincode());
			aEmployeeResponseDto.setRollnumber(employee.getRollnumber());
			aMaps.put(Integer.valueOf(aEmployeeResponseDto.getRollnumber()), aEmployeeResponseDto);
			// System.out.println(aArrayList.add(aEmployeeResponseDto));
			System.out.println(employee.getName());
		}
		return aMaps;

		/*
		 * Set<EmployeeResponseDto> aHashSet = new HashSet<>();
		 * 
		 * for (Employee employee : aEmployee) { EmployeeResponseDto
		 * aEmployeeResponseDto = new EmployeeResponseDto();
		 * aEmployeeResponseDto.setAddress(employee.getAddress());
		 * aEmployeeResponseDto.setMobileNumber(employee.getMobileNumber());
		 * aEmployeeResponseDto.setName(employee.getName());
		 * aEmployeeResponseDto.setPincode(employee.getPincode());
		 * aEmployeeResponseDto.setRollnumber(employee.getRollnumber()); }
		 * 
		 * System.out.println("count" + aHashSet.size()); return aHashSet;
		 */

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

	public String updateEmployee(EmployeeRequestDto employeeRequestDto) {

		System.out.println(employeeRequestDto);

		Boolean aEmployee = employeeRepository.findById(employeeRequestDto.getRollnumber()).isPresent();
		if (!aEmployee) {
			return "Unable to Locate Employee";
		}

		Employee employee = employeeRepository.findById(employeeRequestDto.getRollnumber()).get();
		employee.setAddress(employeeRequestDto.getAddress());
		employee.setMobileNumber(employeeRequestDto.getMobileNumber());
		employee.setName(employeeRequestDto.getName());
		employee.setPincode(employeeRequestDto.getPincode());
		employee.setRollnumber(employeeRequestDto.getRollnumber());
		employeeRepository.save(employee);
		return "Success";
	}

}