package com.example.swagger.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger.pojo.Employee;

@RestController
public class MyController {

	private static List<Employee> employees = new ArrayList<Employee>();
	
	static {
		Employee emp1 = new Employee();
		emp1.setEid(101);
		emp1.setEname("Ram");
		Employee emp2= new Employee();
		emp2.setEid(102);
		emp2.setEname("Shyam");
		employees.add(emp1);
		employees.add(emp2);
	}
	
	
	@GetMapping("/")
	public String sayHello() {
		return "Hi Team ! Welcome to Web World.........!!!!!!!!!";
	}
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAll(){		
		return employees;
	}
	
	@RequestMapping(value = "/getEmpById/{id}" , method = RequestMethod.GET)
	@ResponseBody
	public Employee getUserById(@PathVariable int id) {
		try {		
		//Using Jdk1.8 Stream API
		Employee empObj = employees.stream().filter(data -> data.getEid() == id).findFirst().get();
		return empObj;
		}catch (Exception e) {
			System.out.println("Exception occur " + e);
		}
		return null;
	}
	
}
