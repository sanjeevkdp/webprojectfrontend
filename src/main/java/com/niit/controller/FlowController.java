package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.niit.dao.BillingAddressDao;
import com.niit.dao.CustomerDao;
import com.niit.dao.ShippingAddressDao;
import com.niit.model.BillingAddress;
import com.niit.model.Card;
import com.niit.model.Customer;
import com.niit.model.ShippingAddress;

@Controller
public class FlowController {
	@Autowired
	Customer customer;
	@Autowired
	CustomerDao customerDao;
	@Autowired
	ShippingAddress shippingAddress;
	@Autowired
	BillingAddress billingAddress;
	@Autowired
	Card card;
	@Autowired
	ShippingAddressDao shippingAddressDao;
	@Autowired
	BillingAddressDao billingAddressDao;
	
	
	
	public FlowController initFlow() {
		return new FlowController();
	}
	 
	public String addShippingAddress(ShippingAddress shippingAddress){
		
		customer=customerDao.getCustomerByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		this.shippingAddress.setCustomerId(customer.getCustomerId());
		this.shippingAddress.setApartmentNumber(shippingAddress.getApartmentNumber());
		this.shippingAddress.setCity(shippingAddress.getCity());
		this.shippingAddress.setCountry(shippingAddress.getCountry());
		this.shippingAddress.setState(shippingAddress.getState());
		this.shippingAddress.setStreetName(shippingAddress.getStreetName());
		this.shippingAddress.setZipCode(shippingAddress.getZipCode());
		
		return "success";
		
	}
	public String addBillingAddress(BillingAddress billingAddress){
		customer=customerDao.getCustomerByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		
		
		this.billingAddress.setCustomerId(customer.getCustomerId());
		this.billingAddress.setApartmentNumber(billingAddress.getApartmentNumber());
		this.billingAddress.setCity(billingAddress.getCity());
		this.billingAddress.setState(billingAddress.getState());
		this.billingAddress.setStreetName(billingAddress.getStreetName());
		this.billingAddress.setZipCode(billingAddress.getZipCode());
		this.billingAddress.setCountry(billingAddress.getCountry());
		
		return "success";
	}
	public String addCard(Card card){
		customer=customerDao.getCustomerByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		
		shippingAddressDao.saveOrUpdate(shippingAddress);
		billingAddressDao.saveOrUpdate(billingAddress);
		
		return "success";
	}

}
