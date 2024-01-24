package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	private Logger logger = LoggerFactory.getLogger(DemoController.class);

	@GetMapping("/greet")
	public String getGreet(Model model) {
		String s=null;
		s.length();
		model.addAttribute("msg", "Hello,Good Evening...");
		return "index";
	}

	
}
