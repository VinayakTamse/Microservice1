package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Employee;

@Component
@Service
public class EmployeeService {
	
	static HashMap<Integer, Employee> employeeMap;

	public EmployeeService() {
		
		Employee emp1 = new Employee(1,"Rahul", 29000);
		employeeMap = new HashMap<Integer,Employee>();
		employeeMap.put(1, emp1);
	}
	
	public List<Employee> getListOfEmployees()
	{
		List<Employee> lists = new ArrayList<Employee>(employeeMap.values());
		return lists;
	}
	
	public Employee getEmployeeById(int id)
	{
		Employee employee = employeeMap.get(id);
		return employee;
	}
	
	public Employee getEmployeeByName(String name)
	{
		Employee emp = null;
		for (int i : employeeMap.keySet())
		{
			if (employeeMap.get(i).getName().equals(name))
			{
				emp = employeeMap.get(i);
			}
		}
		return emp;
	}
	
	public Employee createEmployee(Employee emp)
	{
		emp.setId(generateId());
		employeeMap.put(emp.getId(), emp);
		return emp;
		
	}
	
	public Employee updateEmployee(Employee emp)
	{
		employeeMap.put(emp.getId(), emp);
		return emp;
	}
	
	public String deleteEmployee(int id)
	{
		employeeMap.remove(id);
		return "Deleted Employee";
	}
	public int generateId()
	{
		int max=0;
		for (int i : employeeMap.keySet())
		{
			if (i>=max)
			{
				max = i;
			}
		}
		return max+1;
	}
}
