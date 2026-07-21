package com.crudoperation.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.crudoperation.test.dao.RegistrationRepository;

@SpringBootApplication
public class CrudOperaitonPerformApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CrudOperaitonPerformApplication.class, args);

		RegistrationRepository register = context.getBean(RegistrationRepository.class);

//		Without Menu Driven:
//		Creation Operation

		/** Single Entry Create ***/
		/*
		 * Registration registration = new Registration();
		 * registration.setFirstName("Harsh"); registration.setLastName("Rathore");
		 * registration.setCity("Indore"); registration.setAge(23);
		 * 
		 * Registration registerd = register.save(registration);
		 * System.out.println(registerd);
		 */

		/** Multiple Entry Create ***/
		/*
		 * Registration registration1 = new Registration();
		 * registration1.setFirstName("Ayush"); registration1.setLastName("Pandey");
		 * registration1.setCity("Bhopal"); registration1.setAge(24);
		 * 
		 * Registration registration2 = new Registration();
		 * registration2.setFirstName("Pankaj"); registration2.setLastName("Sharma");
		 * registration2.setCity("Pune"); registration2.setAge(43);
		 * 
		 * List<Registration> register1 = List.of(registration1, registration2);
		 * register.saveAll(register1);
		 * 
		 * register1.forEach(r -> { System.out.println(r); });
		 */

//		Updation Operation
		/*
		 * Optional<Registration> optional = register.findById(1);
		 * 
		 * if(optional.isPresent()) { Registration registration = optional.get();
		 * System.out.println(registration);
		 * 
		 * registration.setFirstName("Mayank"); Registration r1 =
		 * register.save(registration); System.out.println(r1); } else {
		 * System.out.println("No Found!"); }
		 */

//		Getting Operation

		/** Single Read Data ***/
		/*
		 * Optional<Registration> optional = register.findById(1); Registration readdata
		 * = optional.get(); System.out.println(readdata);
		 */

		/** Multiple Read Data ***/
		/*
		 * Iterable<Registration> itr = register.findAll(); itr.forEach(data->{
		 * System.out.println(data); });
		 */

//		Deletion Operation

		/** Single Data Delete ***/
		/*
		 * Optional<Registration> optional = register.findById(1);
		 * 
		 * if(optional.isPresent()) { register.delete(optional.get());
		 * System.out.println("Delete Successfully!"); } else {
		 * System.out.println("No Found!"); }
		 */

		/** Full Data Delete ***/
		/*
		 * try { register.deleteAll(); System.out.println("Deleted All Data!"); }
		 * catch(Exception e) { System.out.println(e.getMessage()); }
		 */
	}

}
