package com.niit.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.viewModel.ProductModel;

@Controller
public class HelloController {
	private Path path;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private Product product;
	@Autowired
	private Category category;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private Supplier supplier;
	@Autowired
	private SupplierDao supplierDao;

	@RequestMapping({ "/", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isHomeClicked", "true");
		mv.addObject("active", "home");
		return mv;
	}

	@RequestMapping("/admin")
	public String Admin() {
		return "admin";
	}

	
	
	

	
		
	// ============AdminMapping===================//
	

	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isHomeClicked", "true");
		mv.addObject("active", "home");
		return mv;
	}


	@RequestMapping("/productItem")
	public ModelAndView productSingleItem() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isProductItemClicked", "true");
		mv.addObject("active", "productItem");
		return mv;

	}

	// pages including
	@RequestMapping("/about")
	public ModelAndView About() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isAboutClicked", "true");
		mv.addObject("active", "about");
		return mv;
	}

	@RequestMapping("/service")
	public ModelAndView Service() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isServiceClicked", "true");
		mv.addObject("active", "service");
		return mv;
	}

	// @RequestMapping("/Admin")
	// public ModelAndView AdminByIndex(){
	// ModelAndView mv = new ModelAndView("index");
	// mv.addObject("isAdminClicked","true");
	// mv.addObject("active","Admin");
	// return mv;
	// }
	@RequestMapping("/aboutMe")
	public ModelAndView AboutMe() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isAboutMeClicked", "true");
		mv.addObject("active", "aboutMe");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isLoginClicked", "true");
		mv.addObject("active", "login");
		return mv;

	}

	@RequestMapping("/register")
	public ModelAndView Register() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isRegisterClicked", "true");
		mv.addObject("active", "register");
		return mv;
	}

	@RequestMapping("/error")
	public ModelAndView Error() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isErrorClicked", "true");
		mv.addObject("active", "error");
		return mv;
	}

	@RequestMapping("/contact")
	public ModelAndView Contactr() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isContactClicked", "true");
		mv.addObject("active", "contact");
		return mv;
	}

}
