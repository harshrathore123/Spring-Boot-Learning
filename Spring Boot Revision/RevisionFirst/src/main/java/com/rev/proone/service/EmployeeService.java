package com.rev.proone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rev.proone.entities.Employee;
import com.rev.proone.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
//	Adding Employee
	public Employee addEmployee(Employee employee) {
		Employee emp = this.employeeRepository.save(employee);
		return emp;
	}
	
//	Get By Id Employee
	public Employee getEmployeeById(int empid) {
		Employee emp = null;
		try {
			emp = this.employeeRepository.findById(empid);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	
//	Get All Employee
	public List<Employee> getAllEmployee(){
		List<Employee> list = (List<Employee>) this.employeeRepository.findAll();
		return list;		
	}
	
//	Update Employee
	public Employee updateEmployee(int id, Employee employee) {
		employee.setId(id);
		return this.employeeRepository.save(employee);
	}

//	Delete Employee
	public void deleteEmployee(int empid) {
		try {
			this.employeeRepository.deleteById(empid);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
