package com.bridgelabz.emppayrollapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.emppayrollapp.model.Employee;

public interface EmpRepository extends JpaRepository<Employee, Long> {
	public Employee findByName(String name);
}