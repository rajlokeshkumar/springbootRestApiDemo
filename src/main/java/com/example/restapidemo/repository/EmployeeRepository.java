package com.example.restapidemo.repository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.example.restapidemo.entity.Employee;

@EnableJpaRepositories
public interface EmployeeRepository extends CrudRepository<Employee, String>   {

	
	
}
