package com.jpa.test.dao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jpa.test.entites.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	//Creating Method For - Dervied Query Method
	List<User> findByName(String str);
	
	List<User> findByNameAndCity(String str1, String str2);
	
	List<User> findByNameOrCity(String str1, String str2);
	
	
	List<User> findByAgeGreaterThan(int age);
	
	List<User> findByAgeLessThan(int age);
	
	List<User> findByAgeBetween(int age1, int age2);
	
	
}