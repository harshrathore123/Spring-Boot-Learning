package com.rev.proone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class EmployeeAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empaddId;
	
	@Column(name="emp_current_address")
	private String currentAddress;
	
	@Column(name="emp_permanent_address")
	private String permanentAddress;
	
	@OneToOne(mappedBy = "empaddress")
	@JsonBackReference
	private Employee employee;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id")
	@JsonBackReference("location-address")
	private EmployeeLocation employeeLocation;

	public int getEmpaddId() {
		return empaddId;
	}

	public void setEmpaddId(int empaddId) {
		this.empaddId = empaddId;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeLocation getEmployeeLocation() {
		return employeeLocation;
	}

	public void setEmployeeLocation(EmployeeLocation employeeLocation) {
		this.employeeLocation = employeeLocation;
	}

	public EmployeeAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
