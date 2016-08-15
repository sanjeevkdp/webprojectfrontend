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
import com.niit.dao.CustomerDao;
import com.niit.dao.UsersDao;
import com.niit.model.Authorities;
import com.niit.model.BillingAddress;
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


@RequestMapping("/registration")
public ModelAndView registration(Model model){
	ModelAndView mv =new ModelAndView("index");
	customer.setGender("male");
	customer.setEnabled(true);
	
	model.addAttribute("customer",customer);
	mv.addObject("isRegistrationClicked","true");
	mv.addObject("active","registration");
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
	users.setUsername(customer.getUserName());
	users.setPassword(customer.getPassword());
	users.setEnabled(true);
	usersDao.saveOrUpdate(users);
	authorities.setUserName(users.getUsername());
	authorities.setAuthority("ROLE_USER");
	authoritiesDao.saveOrUpdate(authorities);
	
	mv.addObject("isRegistrationSuccessClicked","true");
	mv.addObject("active","registrationSuccess");

	return mv;
	
	
	
}

}
