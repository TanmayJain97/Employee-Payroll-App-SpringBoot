package com.bridgelabz.emppayrollapp.service;

import java.util.List;

import com.bridgelabz.emppayrollapp.dto.EmployeeDto;
import com.bridgelabz.emppayrollapp.model.Employee;
import com.bridgelabz.emppayrollapp.util.Response;

public interface IEmployee {
	public Response addEmployee(Employee employee);
//	public Response addEmployee(EmployeeDto empDto);
	public List<Employee> getEmployee();
	public Employee getEmployeeByID(Long id);
	public void deleteEmployee(Long id);
	public void update(Employee newEmp,Long id);
}
