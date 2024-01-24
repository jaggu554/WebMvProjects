package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Welcome {

	@GetMapping("/")
	public String getWelcome(Model model) {
		
		model.addAttribute("msg", "Good Evening Welcome to the Jetty");
		return "index";
	}
	
	@GetMapping("/send")
	@ResponseBody
	public String getGreet() {
		String msg="Hello,How are you?";
		return msg;
	}
	
}
