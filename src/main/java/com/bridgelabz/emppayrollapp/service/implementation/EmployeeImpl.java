package com.bridgelabz.emppayrollapp.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.emppayrollapp.model.Employee;
import com.bridgelabz.emppayrollapp.repo.EmpRepository;
import com.bridgelabz.emppayrollapp.service.IEmployee;

@Service
public class EmployeeImpl implements IEmployee {
	
	@Autowired
	private EmpRepository empRepo;
	
	@Override
	public void addEmployee(Employee employee) {
		empRepo.save(employee);
		System.out.println("Added to repo.");
	}

	@Override
	public void addEmployee(String name, Long salary) {
		Employee employee = new Employee();
		employee.setSalary(salary);
		employee.setname(name);
		this.addEmployee(employee);

	}

	@Override
	public List<Employee> getEmployee() {
		return empRepo.findAll();
	}

	@Override
	public Employee getEmployeeByID(Long id) {
		return empRepo.findById(id).get();
	}

	@Override
	public void deleteEmployee(Long id) {
		empRepo.deleteById(id);
	}

	@Override
	public void update(Long id, Long salary) {
		Employee employee = empRepo.findById(id).get();
		employee.setSalary(salary);
		this.addEmployee(employee);
	}
}