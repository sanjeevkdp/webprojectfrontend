package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;

@Controller
public class LoginController {
@Autowired
CategoryDao categoryDao;

	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(
			@RequestParam(value = "error",required = false) String error,
	        @RequestParam(value = "logout",	required = false) String logout ,Model model) {
		
		ModelAndView mod = new ModelAndView("index");
		if (error != null) {
			mod.addObject("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
			mod.addObject("message", "Logged out successfully.");
		}
        
		mod.addObject("isLoginClicked", "true");
		mod.addObject("active","login");
		
		//===========list Category in navBar=========//
		List<Category> listCategory = categoryDao.list();
		model.addAttribute("categories", listCategory);
		
		
		
		return mod;
	}
}
