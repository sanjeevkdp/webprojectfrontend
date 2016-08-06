package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {


	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(
			@RequestParam(value = "error",required = false) String error,
	        @RequestParam(value = "logout",	required = false) String logout) {
		
		ModelAndView model = new ModelAndView("index");
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
			model.addObject("message", "Logged out successfully.");
		}
        
		model.addObject("isLoginClicked", "true");
		model.addObject("active","login");
		return model;
	}
}