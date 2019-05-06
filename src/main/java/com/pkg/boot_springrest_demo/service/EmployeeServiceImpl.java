package com.pkg.boot_springrest_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pkg.boot_springrest_demo.dao.EmployeeDAO;
import com.pkg.boot_springrest_demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO empDAO;
	
	@Autowired
	EmployeeServiceImpl(EmployeeDAO empDAO){
		this.empDAO = empDAO;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return empDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		return empDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee emp) {
		empDAO.save(emp);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		empDAO.deleteById(id);
	}

}
