package com.jpa.test;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entites.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);

		/** CREATE OPERATION FROM CRUD **/

//		Step 1: Create Operation
		/*
		 * User user = new User(); user.setName("Harsh"); user.setCity("Indore");
		 * user.setStatus("Rural");
		 * 
		 * User user1 = userRepository.save(user);
		 * System.out.println("Single Object Data Saved: "+user1);
		 */

//		Step 2: Create Operation but for Multiple Object
		/*
		 * User user2 = new User(); user2.setName("AKASH"); user2.setCity("Bhopal");
		 * user2.setStatus("Urban");
		 * 
		 * User user3 = new User(); user3.setName("Pawan"); user3.setCity("Manglore");
		 * user3.setStatus("Urban");
		 * 
		 * List<User> users = List.of(user2,user3); Iterable<User> result =
		 * userRepository.saveAll(users);
		 * 
		 * result.forEach(userdetail->{ System.out.println(userdetail); });
		 */

		/** UPDATE OPERATION FROM CRUD **/

//		Step 3: Update Operation
		/*
		 * Optional<User> optional = userRepository.findById(1); User user =
		 * optional.get();
		 * 
		 * System.out.println(user); user.setName("Pankaj Kumar Singh");
		 * 
		 * User result = userRepository.save(user); System.out.println(result);
		 */

		/** GET OPERATION FROM CRUD **/

//		Step 4: Get Operation using FindById for Single Entry
		/*
		 * try { Optional<User> result = userRepository.findById(1); User user =
		 * result.get(); System.out.println(user); } catch(Exception e) {
		 * System.out.println("No data Found"); }
		 */

//		Step 5: Get All Data using FindAll for multiple entries
		/*
		 * Iterable<User> iterate = userRepository.findAll(); iterate.forEach(user->{
		 * System.out.println(user); });
		 */

		/** DELETE OPERATION FROM CRUD **/

//		Step 6: Delete Operation for Single entry
		/*
		 * int n = 1; Optional<User> user = userRepository.findById(n);
		 * 
		 * if(user.isPresent()) { userRepository.delete(user.get());
		 * System.out.println("Delete Successfully!"); } else {
		 * System.out.println("Not Found!"); }
		 */

//		Step 7: Delete Operation for full table data
		/*
		 * try { userRepository.deleteAll(); System.out.println("Full Data is Deleted");
		 * } catch(Exception e) { System.out.println(e.getMessage()); }
		 */

	}

}
