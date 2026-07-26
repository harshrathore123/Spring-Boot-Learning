package com.rev.proone.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeName {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empnameId;
	
	@Column(name="emp_first_name")
	private String firstName;
	
	@Column(name="emp_last_name")
	private String lastName;
	
	public EmployeeName(int empnameId, String firstName, String lastName) {
		super();
		this.empnameId = empnameId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getEmpnameId() {
		return empnameId;
	}

	public void setEmpnameId(int empnameId) {
		this.empnameId = empnameId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public EmployeeName() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmployeeName [empnameId=" + empnameId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	
}
