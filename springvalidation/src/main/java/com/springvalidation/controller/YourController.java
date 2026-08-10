package com.springvalidation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class YourController {

	@GetMapping
	private String start() {
		return "start";
	}
	
}
