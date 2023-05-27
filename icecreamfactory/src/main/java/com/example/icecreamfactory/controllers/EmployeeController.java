package com.example.icecreamfactory.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.icecreamfactory.entity.Employee;
import com.example.icecreamfactory.repository.EmployeeRepository;
import com.example.icecreamfactory.service.EmployeeService;

@Controller
@RequestMapping
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}


	@GetMapping("/date")
	@ResponseBody
	public String getTime()
	{
		Date date=new Date();
		
		return String.valueOf(date);
	}
	
	
	@PostMapping("/saveEmployee")
	@ResponseBody
	public String saveEmployee(@ModelAttribute("saveEmployee") Employee employee) {
		System.out.println("Save Employee...");
		employeeService.saveEmployee(employee);
		return "saved";
	}
	
	@GetMapping("/getAllEmployee")
	@ResponseBody
	public List<Employee> getAllEmployee()
	{
		List<Employee> listOfEmployees=employeeService.getAllEmployees();
		
		return listOfEmployees;
		
	}
	
}
