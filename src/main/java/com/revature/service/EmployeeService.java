package com.revature.service;

import java.util.Optional;

import dao.EmployeeDao;
import models.Employee;

public class EmployeeService {
	private EmployeeDao edao;
	
	public EmployeeService(EmployeeDao edao) {
		this.edao = edao;
	}
	
	public Employee confirmLogin(String username, String password){
		Optional<Employee> possibleEmp = edao.findAll().stream()
				.filter(e -> (e.getUserName().equals(username) && e.getPassword().equals(password)))
				.findFirst();
		
		return (possibleEmp.isPresent() ? possibleEmp.get() : new Employee());
	}
}
