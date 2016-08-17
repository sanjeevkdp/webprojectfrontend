package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.AuthoritiesDao;
import com.niit.dao.CategoryDao;
import com.niit.dao.CustomerDao;
import com.niit.dao.UsersDao;
import com.niit.model.Authorities;
import com.niit.model.BillingAddress;
import com.niit.model.Category;
import com.niit.model.Customer;
import com.niit.model.ShippingAddress;
import com.niit.model.Users;

@Controller
public class RegistrationController {
@Autowired
private Customer customer;
@Autowired
private CustomerDao customerDao;
@Autowired
private ShippingAddress shippingAddress;
@Autowired
private BillingAddress billingAddress;
@Autowired
private Users users;
@Autowired
private UsersDao usersDao; 
@Autowired
private Authorities authorities;
@Autowired
private AuthoritiesDao authoritiesDao;
@Autowired
Category category;
@Autowired
CategoryDao categoryDao;


@RequestMapping("/registration")
public ModelAndView registration(Model model){
	ModelAndView mv =new ModelAndView("index");
	customer.setGender("male");
	customer.setEnabled(true);
	
	model.addAttribute("customer",customer);
	mv.addObject("isRegistrationClicked","true");
	mv.addObject("active","registration");
	
	//===========list Category in navBar=========//
			List<Category> listCategory = categoryDao.list();
			model.addAttribute("categories", listCategory);
			
	return mv;
	
}
@RequestMapping(value="/registration",method=RequestMethod.POST)
public ModelAndView registrationSuccess(@ModelAttribute("customer") Customer customer, Model model,HttpServletRequest request){
	ModelAndView mv =new ModelAndView("index");
	customer.setEnabled(true);
	//customerDao.saveOrUpdate(users);
	customerDao.saveOrUpdate(customer);
	List<Customer> listCustomer=customerDao.list();
	model.addAttribute("customer",listCustomer);
	
	 users.setUserName(customer.getUserName());
	users.setPassword(customer.getPassword());
	users.setEnabled(true);
	
	authorities.setUserName(customer.getUserName());
	authorities.setAuthority("ROLE_USER");
	usersDao.saveOrUpdate(users);
	authoritiesDao.saveOrUpdate(authorities);
	
	mv.addObject("isRegistrationSuccessClicked","true");
	mv.addObject("active","login");
      
	//===========list Category in navBar=========//
			List<Category> listCategory = categoryDao.list();
			model.addAttribute("categories", listCategory);
			
	return mv;
	
	
	
}

}
