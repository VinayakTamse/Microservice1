package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Employee;
import com.example.demo.service.EmployeeService;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeServ;
	
	
	@GetMapping("/all")
	public List<Employee> getAllEmployees()
	{
		return employeeServ.getListOfEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable(value="id") int id)
	{
		return employeeServ.getEmployeeById(id);
	}
	
	@GetMapping("/")
	public Employee getEmployeeByName(@RequestParam(value="name") String name)
	{
		return employeeServ.getEmployeeByName(name);
	}
	
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee emp)
	{
		return employeeServ.createEmployee(emp);
	}
	
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@PathVariable(value="id") int id, @RequestBody Employee emp)
	{
		Employee existEmp = employeeServ.getEmployeeById(id);
		existEmp.setName(emp.getName());
		existEmp.setSalary(emp.getSalary());
		employeeServ.updateEmployee(existEmp);
		return existEmp;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable(value="id") int id)
	{
		return employeeServ.deleteEmployee(id);
	}

}
