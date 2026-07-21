package com.crudoperation.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.crudoperation.test.entities.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Integer>{

}
