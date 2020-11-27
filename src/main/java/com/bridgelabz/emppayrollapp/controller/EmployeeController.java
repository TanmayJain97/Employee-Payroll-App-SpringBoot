package com.bridgelabz.emppayrollapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bridgelabz.emppayrollapp.dto.EmployeeDto;
import com.bridgelabz.emppayrollapp.service.IEmployee;
import com.bridgelabz.emppayrollapp.util.Response;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployee empService;
	
	@PostMapping(value="/post")
	public ResponseEntity<Response> addEmployee(@Valid @RequestBody EmployeeDto empDto) {
	//(@PathVariable(value="name") String name,@PathVariable(value="salary") Long salary){
		Response response=empService.addEmployee(empDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getEmp")
	public ResponseEntity<Response> getEmployee(){
		Response response=empService.getEmployee();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getEmp/{id}")
	public ResponseEntity<Response> getEmployeeById(@PathVariable("id") long id) {
		Response response=empService.getEmployeeByID(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Response> update(@RequestBody EmployeeDto empDto,@PathVariable("id") long id) {
		Response response=empService.update(empDto,id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> delete(@PathVariable("id") long id) {
		Response response=empService.deleteEmployee(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}