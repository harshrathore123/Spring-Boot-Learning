package com.rev.proone.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class EmployeeLocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emplocationId;
	
	@Column(name="emp_city")
	private String empCity;
	
	@Column(name="emp_state")
	private String empState;
	
	@Column(name="emp_pincode")
	private int empPincode;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	@JoinColumn(name="emp_address_id")
	private EmployeeAddress emp_address;

	public EmployeeLocation(int emplocationId, String empCity, String empState, int empPincode,
			EmployeeAddress emp_address) {
		super();
		this.emplocationId = emplocationId;
		this.empCity = empCity;
		this.empState = empState;
		this.empPincode = empPincode;
		this.emp_address = emp_address;
	}

	public int getEmplocationId() {
		return emplocationId;
	}

	public void setEmplocationId(int emplocationId) {
		this.emplocationId = emplocationId;
	}

	public String getEmpCity() {
		return empCity;
	}

	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}

	public String getEmpState() {
		return empState;
	}

	public void setEmpState(String empState) {
		this.empState = empState;
	}

	public int getEmpPincode() {
		return empPincode;
	}

	public void setEmpPincode(int empPincode) {
		this.empPincode = empPincode;
	}

	public EmployeeAddress getEmp_address() {
		return emp_address;
	}

	public void setEmp_address(EmployeeAddress emp_address) {
		this.emp_address = emp_address;
	}

	public EmployeeLocation() {
		super();
		// TODO Auto-generated constructor stub
	}

}
