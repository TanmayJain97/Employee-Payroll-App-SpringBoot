package com.bridgelabz.emppayrollapp.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bridgelabz.emppayrollapp.dto.EmployeeDto;
import com.bridgelabz.emppayrollapp.exception.EmployeeException;
import com.bridgelabz.emppayrollapp.model.Employee;
import com.bridgelabz.emppayrollapp.repo.EmpRepository;
import com.bridgelabz.emppayrollapp.service.IEmployee;
import com.bridgelabz.emppayrollapp.util.Response;

@Service
public class EmployeeImpl implements IEmployee {
	
	@Autowired
	private EmpRepository empRepository;
	
	@Autowired
	private ModelMapper modelMap;
	
	@Override
	public Response addEmployee(EmployeeDto empDto) {
		
		Employee employeeExist = empRepository.findByName(empDto.getName());
		if(employeeExist!=null) {
			throw new EmployeeException(HttpStatus.BAD_REQUEST.value(), "Record Already Exists!");
		}
		
		Employee emp = modelMap.map(empDto, Employee.class);
		empRepository.save(emp);
		System.out.println("Added to repo.");
		return new Response(200, "Added sucessfully.");
	}

	@Override
	public Response getEmployee() {
		List<Employee> empRecord=empRepository.findAll();
		if(empRecord.isEmpty()) {
			throw new EmployeeException(HttpStatus.NO_CONTENT.value(), "No record Exists");
		}
		System.out.println(empRecord);
		List<EmployeeDto> dtoRecord=new ArrayList<>();
		for (Employee emp : empRecord) {
			EmployeeDto empDto=modelMap.map(emp, EmployeeDto.class);
			dtoRecord.add(empDto);
		}
		return new Response(HttpStatus.OK.value(), dtoRecord.toString());
	}

	@Override
	public Response getEmployeeByID(Long id) {
		Employee emp=empRepository.findById(id).get();
		if (emp==null) throw new EmployeeException(HttpStatus.NO_CONTENT.value(), "Employee Doesnt Exist");
		else return new Response(HttpStatus.OK.value(), emp.toString());
	}

	@Override
	public Response deleteEmployee(Long id) {
		Employee emp=empRepository.findById(id).get();
		if (emp==null) throw new EmployeeException(HttpStatus.NO_CONTENT.value(), "Employee Doesnt Exist");
		else {
			empRepository.deleteById(id);
			System.out.println("Del from repository.");
		}
		return new Response(HttpStatus.OK.value(), "Daleted successfully!");
	}

	@Override
	public Response update(EmployeeDto newEmpdto,Long id) {
		
		Employee emp=empRepository.findById(id).get();
		if (emp==null) throw new EmployeeException(HttpStatus.NO_CONTENT.value(), "Employee Doesnt Exist");
		else {
			Employee newEmp=modelMap.map(newEmpdto, Employee.class);
			this.deleteEmployee(id);
			newEmp.setId(id);
			empRepository.save(newEmp);
			System.out.println("Updated to repository.");
		}
		return new Response(HttpStatus.OK.value(), "Updated successfully!");
	}
}