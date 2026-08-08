package com.practice.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("/about")
	public String about() {
		System.out.println("Inside about handler....");
		return "about";
		// about.html
	}

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("name", "Harsh Rathore");
		return "home";
	}

	// Iteration
	@GetMapping("/example-iterable")
	public String iterableItem(Model model) {
		List<String> names = List.of("ankit", "karan", "piyush", "john");
		model.addAttribute("name", names);
		return "iterable";
	}

	// Conditonal Statement
	@GetMapping("/example-conditional")
	public String conditionalExample(Model model) {
		int age = 23;
		String name = "Harsh";

		model.addAttribute("age", 23);
		model.addAttribute("name", "");

		return "conditional";
	}
}
