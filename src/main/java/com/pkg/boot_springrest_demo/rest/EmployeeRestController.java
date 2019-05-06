package com.pkg.boot_springrest_demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkg.boot_springrest_demo.entity.Employee;
import com.pkg.boot_springrest_demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService empService;
	
	@Autowired
	public EmployeeRestController(EmployeeService empService) {
		this.empService= empService;
	}
	
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return empService.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Employee findById( @PathVariable int id) {
		
		Employee emp =  empService.findById(id);
		if(emp == null) {
			throw new RuntimeException("Employee doesn't exists. with id :" + id);
		}
		return emp;
	}
	
	
	@PostMapping("/employees")
	public Employee savev(@RequestBody Employee emp) {
		
		emp.setId(0);
		empService.save(emp);
		return emp;
	}
	
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee emp) {
		empService.save(emp);
		return emp;
	}
	
	
	@DeleteMapping("/employees/{id}")
	public String deleteByID( @PathVariable int id) {
		
		Employee emp = empService.findById(id);
		if(emp == null) {
			throw new RuntimeException("Employee doesn't exists. with id :" + id);
		}
		empService.deleteById(id);
		return "Deleted Employee id is : "+id;
	}
}
