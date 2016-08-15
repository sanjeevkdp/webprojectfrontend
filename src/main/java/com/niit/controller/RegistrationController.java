package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CustomerDao;
import com.niit.model.BillingAddress;
import com.niit.model.Customer;
import com.niit.model.ShippingAddress;

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

}
