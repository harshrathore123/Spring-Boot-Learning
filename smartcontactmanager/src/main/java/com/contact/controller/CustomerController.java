	package com.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@GetMapping("/data")
	public String customer_dashboard(Model model) {
		model.addAttribute("title", "Customer Dashboard - Smart Contact Manager");
		return "customer_dashboard";
	}
}
