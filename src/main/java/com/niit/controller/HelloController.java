package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Product;



@Controller
public class HelloController {
	@Autowired
	private Product productDao;
public void setProductDao(Product productDao) {
		this.productDao = productDao;
	}
	@RequestMapping({"/","/index"})
	public ModelAndView index(){
	  ModelAndView mv= new ModelAndView("index");
	  mv.addObject("isHomeClicked", "true");
	  mv.addObject("active", "Home");
		return mv;
	}
	@RequestMapping({"/Home"})
	public ModelAndView home(){
	  ModelAndView mv= new ModelAndView("index");
	  mv.addObject("isHomeClicked", "true");
	  mv.addObject("active", "Home");
		return mv;
	}
	
	
	@RequestMapping("/Product")
	public ModelAndView productPage(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isProductClicked","true");
		mv.addObject("active","Product");
		return mv;
		


	}
	@RequestMapping("/ProductItem")
	public ModelAndView productSingleItem(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isProductItemClicked","true");
		mv.addObject("active","ProductItem");
		return mv;
		


	}
	
	@RequestMapping("/Category")
	public ModelAndView productcPage(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isCategoryClicked","true");
		mv.addObject("active","Category");
		return mv;
		


	}
	
	
//	pages including
	@RequestMapping("/About")
	public ModelAndView About(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isAboutClicked","true");
		mv.addObject("active","About");
		return mv;
	}
	@RequestMapping("/Service")
	public ModelAndView Service(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isServiceClicked","true");
		mv.addObject("active","Service");
		return mv;
	}
	@RequestMapping("/FAQ")
	public ModelAndView FAQ(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isFAQClicked","true");
		mv.addObject("active","FAQ");
		return mv;
	}
	@RequestMapping("/AboutMe")
	public ModelAndView AboutMe(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isAboutMeClicked","true");
		mv.addObject("active","AboutMe");
		return mv;
	}
	
	@RequestMapping("/Login")
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isLoginClicked","true");
		mv.addObject("active","Login");
		return mv;
		
	}
	@RequestMapping("/Register")
	public ModelAndView Register(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isRegisterClicked","true");
		mv.addObject("active","Register");
		return mv;
	}
	@RequestMapping("/Error")
	public ModelAndView Error(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isErrorClicked","true");
		mv.addObject("active","Error");
		return mv;
	}
	
}
