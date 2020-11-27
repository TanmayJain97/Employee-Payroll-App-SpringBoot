package com.bridgelabz.emppayrollapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bridgelabz.emppayrollapp.model.Employee;
import com.bridgelabz.emppayrollapp.service.IEmployee;
import com.bridgelabz.emppayrollapp.util.Response;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployee empService;
	
	@PostMapping(value="/post")
	public ResponseEntity<Response> addEmployee(@RequestBody Employee emp) {
	//(@PathVariable(value="name") String name,@PathVariable(value="salary") Long salary){
		Response response=empService.addEmployee(emp);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getEmp")
	public void getEmployee(){
		empService.getEmployee();
	}
	
	@GetMapping("/getEmp/{id}")
	public Employee getEmployeeById(@PathVariable("id") long id) {
		return empService.getEmployeeByID(id);
	}
	
	@PutMapping("/update/{id}")
	public void update(@RequestBody Employee emp,@PathVariable("id") long id) {
		empService.update(emp,id);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		empService.deleteEmployee(id);
	}
}