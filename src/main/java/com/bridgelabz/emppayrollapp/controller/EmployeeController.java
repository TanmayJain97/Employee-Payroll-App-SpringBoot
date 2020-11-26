package com.bridgelabz.emppayrollapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bridgelabz.emppayrollapp.model.Employee;
import com.bridgelabz.emppayrollapp.service.IEmployee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployee empService;
	
	@PostMapping("/post/{name}/{salary}")
	public void addEmployee(@PathVariable(value="name") String name,@PathVariable(value="salary") Long salary){
	   empService.addEmployee(name,salary);	
	}
	
	@GetMapping("/getEmp")
	public List<Employee> getEmployee(){
		 return empService.getEmployee();
	}
	
	@GetMapping("/getEmp/{id}")
	public Employee getEmployeeById(@PathVariable("id") long id) {
		return empService.getEmployeeByID(id);
	}
	
	@PutMapping("/update/{id}/{salary}")
	public void update(@PathVariable("id") Long id,@PathVariable(value="salary") Long salary) {
		empService.update(id,salary);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") long empId) {
		empService.deleteEmployee(empId);
	}
}