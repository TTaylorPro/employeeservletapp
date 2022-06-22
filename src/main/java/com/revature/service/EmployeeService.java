package com.revature.service;

import java.util.List;
import java.util.Optional;

import com.revature.dao.EmployeeDao;
import com.revature.models.Employee;

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
	
	public List<Employee> getAll(){
		return edao.findAll();
	}
	
	public int register(Employee e) {
		// the dao method returns the PK
		return edao.insert(e);
		
	}
}
