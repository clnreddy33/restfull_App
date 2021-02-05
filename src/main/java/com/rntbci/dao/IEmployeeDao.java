package com.rntbci.dao;

import java.util.List;

import com.rntbci.model.Employee;

public interface IEmployeeDao {
	public Integer saveEmployee(Employee e);
	public List<Employee> getAllEmployees();
	

}
