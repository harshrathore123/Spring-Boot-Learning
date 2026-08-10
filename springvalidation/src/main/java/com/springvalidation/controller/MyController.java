package com.springvalidation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springvalidation.entities.LoginForm;

import jakarta.validation.Valid;

@Controller
public class MyController {

	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("loginData1", new LoginForm());
		System.out.println("Going Inside the Form!");
		return "form";
	}

	@PostMapping("/process")
	public String sucess(@Valid @ModelAttribute("loginData1") LoginForm loginData, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println(result);
			return "form";		
		}
		
		System.out.println(loginData);
		return "sucess";
	}
}
