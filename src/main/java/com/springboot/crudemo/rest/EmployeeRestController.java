package com.springboot.crudemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crudemo.dao.EmployeeDAO;
import com.springboot.crudemo.entity.Employee;
import com.springboot.crudemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController (EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	// EXPOSE "/EMPLOYESS" -> RETURN ALL EMPLOYESS
	@GetMapping("/employees")
	public List<Employee> findAll () {
		return employeeService.findAll();
	}
	
	
	
}
