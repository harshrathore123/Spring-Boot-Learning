package com.rev.proone.repository;

import org.springframework.data.repository.CrudRepository;

import com.rev.proone.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	public Employee findById(int id);
}
