package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MsgController {

	@GetMapping("/welcome")
	public ModelAndView getWelcome() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", "Hi,Welcome to Kandlapalle");
		mav.setViewName("index");
		return mav;
	}

	@GetMapping("/greet")
	public ModelAndView msgGreet() {

		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", "Happy Sankranthi have a good day");
		mav.setViewName("index");
		return mav;
	}

}
