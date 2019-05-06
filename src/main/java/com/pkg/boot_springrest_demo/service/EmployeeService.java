package com.pkg.boot_springrest_demo.service;

import java.util.List;

import com.pkg.boot_springrest_demo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee emp);
	
	public void deleteById(int id);

}
