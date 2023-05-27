package com.example.icecreamfactory.service;

import java.util.List;

import com.example.icecreamfactory.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	public Employee saveEmployee(Employee employee);
}
