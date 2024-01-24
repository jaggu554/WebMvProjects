package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class WelcomeController {

	@GetMapping("/wish")
	public String getWelcome(Model model) {
		
		int i=10/0;
		model.addAttribute("msg", "Hello,How are You?");
		return "index";
	}
}
