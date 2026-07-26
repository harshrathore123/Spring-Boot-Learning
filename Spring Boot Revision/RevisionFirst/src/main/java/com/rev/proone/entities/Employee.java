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
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_detail")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="emp_name_id")
	private EmployeeName empname;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_address_id")
	@JsonManagedReference
	private EmployeeAddress empaddress;
	
	@Column(name="age")
	private int studentAge;
	
	private String dob;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EmployeeName getEmpname() {
		return empname;
	}

	public void setEmpname(EmployeeName empname) {
		this.empname = empname;
	}

	public EmployeeAddress getEmpaddress() {
		return empaddress;
	}

	public void setEmpaddress(EmployeeAddress empaddress) {
		this.empaddress = empaddress;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empname=" + empname + ", empaddress=" + empaddress + ", studentAge="
				+ studentAge + ", dob=" + dob + "]";
	}
	
}
