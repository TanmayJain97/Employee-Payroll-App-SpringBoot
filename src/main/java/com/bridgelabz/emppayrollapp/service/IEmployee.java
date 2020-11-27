package com.bridgelabz.emppayrollapp.service;

import com.bridgelabz.emppayrollapp.dto.EmployeeDto;
import com.bridgelabz.emppayrollapp.util.Response;

public interface IEmployee {
	public Response addEmployee(EmployeeDto empDto);
	public Response getEmployee();
	public Response getEmployeeByID(Long id);
	public Response deleteEmployee(Long id);
	public Response update(EmployeeDto newEmpdto,Long id);
}
