package com.rev.proone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class EmployeeAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empaddId;
	
	@Column(name="emp_current_address")
	private String CurrentAddress;
	
	@Column(name="emp_permanent_address")
	private String PermanentAddress;
	
	@OneToOne(mappedBy = "empaddress", fetch = FetchType.LAZY)
	@JsonBackReference
	private Employee employee;
	
	@OneToOne(mappedBy = "emp_address",fetch = FetchType.LAZY)
	@JsonBackReference
	private EmployeeLocation  employeeLocation;

	public EmployeeAddress(int empaddId, String currentAddress, String permanentAddress, Employee employee,
			EmployeeLocation employeeLocation) {
		super();
		this.empaddId = empaddId;
		CurrentAddress = currentAddress;
		PermanentAddress = permanentAddress;
		this.employee = employee;
		this.employeeLocation = employeeLocation;
	}

	public int getEmpaddId() {
		return empaddId;
	}

	public void setEmpaddId(int empaddId) {
		this.empaddId = empaddId;
	}

	public String getCurrentAddress() {
		return CurrentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		CurrentAddress = currentAddress;
	}

	public String getPermanentAddress() {
		return PermanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		PermanentAddress = permanentAddress;
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
