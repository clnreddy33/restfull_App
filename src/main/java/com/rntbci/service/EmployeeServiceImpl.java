package com.rntbci.service;

import java.util.List;

import javax.inject.Inject;

import com.rntbci.dao.IEmployeeDao;
import com.rntbci.model.Employee;

public class EmployeeServiceImpl implements IEmployeeService{
	@Inject
	private IEmployeeDao dao;
	

	@Override
	public Integer saveEmployee(Employee s) {
		
		return dao.saveEmployee(s)	 ;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list=dao.getAllEmployees();

		return list;
	}

}
