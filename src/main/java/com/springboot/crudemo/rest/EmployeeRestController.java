package com.springboot.crudemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crudemo.dao.EmployeeDAO;
import com.springboot.crudemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	// INJECT EMPLOYEE DAO
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeRestController (EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	// EXPOSE "/EMPLOYESS" -> RETURN ALL EMPLOYESS
	@GetMapping("/employees")
	public List<Employee> findAll () {
		return employeeDAO.findAll();
	}
	
	
	
}
