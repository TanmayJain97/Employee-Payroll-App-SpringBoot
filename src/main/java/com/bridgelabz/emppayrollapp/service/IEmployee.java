package com.bridgelabz.emppayrollapp.service;

import java.util.List;
import com.bridgelabz.emppayrollapp.model.Employee;

public interface IEmployee {
	public void addEmployee(Employee employee);
	public void addEmployee(String name, Long salary);
	public List<Employee> getEmployee();
	public Employee getEmployeeByID(Long id);
	public void deleteEmployee(Long id);
	public void update(Long id, Long salary);
}
