package com.contact.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.contact.dao.UserRepository;
import com.contact.entities.Contact;
import com.contact.entities.User;
import com.contact.helper.Message;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/data")
	public String customer_dashboard(Model model, Principal principal) {

		// Getting Username
		String username = principal.getName();
		System.out.println("Username" + username);

		// Getting UserDetail
		User user = userRepository.getUserByEmail(username);
		System.out.println("User: " + user);

		model.addAttribute("user", user);
		model.addAttribute("title", "Customer Dashboard - Smart Contact Manager");
		return "customer/customer_dashboard";
	}

	// Open Add Contact Form
	@GetMapping("/addContact")
	public String addContact(Model model, Principal principal) {

		// Getting Username
		String username = principal.getName();
		System.out.println("Username" + username);

		// Getting UserDetail
		User user = userRepository.getUserByEmail(username);
		System.out.println("User: " + user);

		model.addAttribute("user", user);

		model.addAttribute("contact", new Contact());
		model.addAttribute("title", "Customer Add Contact - Smart Contact Manager");
		return "customer/customer_add_contact";
	}

	// Processing Add Contact Form
	@PostMapping("/process-contact")
	public String processContact(@Valid @ModelAttribute Contact contact, BindingResult result, Model model,
			Principal principal, RedirectAttributes redirectAttribute) {

		try {
			if (result.hasErrors()) {
				User user = userRepository.getUserByEmail(principal.getName());
				model.addAttribute("user", user);
				model.addAttribute("title", "Customer Add Contact - Smart Contact Manager");
				return "customer/customer_add_contact";
			}

			// Getting Username
			String username = principal.getName();
			System.out.println("Username" + username);

			User usern = this.userRepository.getUserByEmail(username);

			usern.getContact().add(contact);

			this.userRepository.save(usern);

			// Getting UserDetail
			model.addAttribute("user", usern);

			System.out.println(contact);
			System.out.println(contact.getNickName());
			redirectAttribute.addFlashAttribute("message", new Message("Successfully Registered !!", "alert-success"));
			return "redirect:/customer/customer_add_contact";

		} catch (Exception e) {
			e.printStackTrace();
			User user = userRepository.getUserByEmail(principal.getName());
			model.addAttribute("user", user);
			model.addAttribute("title", "Customer Add Contact - Smart Contact Manager");
			redirectAttribute.addFlashAttribute("message",
					new Message("Something went wrong !! " + e.getMessage(), "alert-danger"));
			return "customer/customer_add_contact";
		}
	}
}
