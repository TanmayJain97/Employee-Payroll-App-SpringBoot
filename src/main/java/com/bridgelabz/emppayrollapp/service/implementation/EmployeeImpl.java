package com.bridgelabz.emppayrollapp.service.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.emppayrollapp.dto.EmployeeDto;
import com.bridgelabz.emppayrollapp.model.Employee;
import com.bridgelabz.emppayrollapp.repo.EmpRepository;
import com.bridgelabz.emppayrollapp.service.IEmployee;
import com.bridgelabz.emppayrollapp.util.Response;

@Service
public class EmployeeImpl implements IEmployee {
	
	@Autowired
	private EmpRepository empRepository;
	
//	@Autowired
//	private ModelMapper mappy;
	
//	@Override
//	public Response addEmployee(EmployeeDto empDto) {
//		Employee employee= mappy.map(empDto, Employee.class);
//		empRepository.save(employee);
//		System.out.println("Added to repo.");
//		return new Response(200, "Added sucessfully.");
//	}

	@Override
	public Response addEmployee(Employee emp) {
		empRepository.save(emp);
		System.out.println("Added to repository.");
		return new Response(200, "Added sucessfully.");
	}

	@Override
	public List<Employee> getEmployee() {
		System.out.println(empRepository.findAll());
		return empRepository.findAll();
	}

	@Override
	public Employee getEmployeeByID(Long id) {
		return empRepository.findById(id).get();
	}

	@Override
	public void deleteEmployee(Long id) {
		System.out.println("Del from repository.");
		empRepository.deleteById(id);
	}

	@Override
	public void update(Employee newEmp,Long id) {
		this.deleteEmployee(id);
		newEmp.setId(id);
		empRepository.save(newEmp);
		System.out.println("Updated to repository.");
	}
}