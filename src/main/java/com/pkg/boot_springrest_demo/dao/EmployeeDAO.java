package com.pkg.boot_springrest_demo.dao;

import java.util.List;

import com.pkg.boot_springrest_demo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee emp);
	
	public void deleteById(int id);
}
