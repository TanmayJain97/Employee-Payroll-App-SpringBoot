package com.bridgelabz.emppayrollapp.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeDto {
	
	private Long id;
	private Date startDate=new Date();
	
	@NotNull
	@Size(min = 3, message = "Enter more than 3 characters")
	private String name;
	
	@NotNull
	private Long salary;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the salary
	 */
	public Long getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", name=" + name + ", salary=" + salary + ", startDate=" + startDate + "]";
	}
}