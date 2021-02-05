package com.rntbci.service;

import java.util.List;

import com.rntbci.model.Employee;

public interface IEmployeeService {
	public Integer saveEmployee(Employee s);
	public List<Employee> getAllEmployees();
	

}
