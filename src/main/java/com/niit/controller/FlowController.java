package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.niit.dao.BillingAddressDao;
import com.niit.dao.CardDao;
import com.niit.dao.CartDao;
import com.niit.dao.CartItemDao;
import com.niit.dao.CustomerDao;
import com.niit.dao.OrderItemsDao;
import com.niit.dao.ShippingAddressDao;
import com.niit.model.BillingAddress;
import com.niit.model.Card;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Customer;
import com.niit.model.Order;
import com.niit.model.OrderItems;
import com.niit.model.ShippingAddress;
import com.niit.temp.CheckOutDetails;

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
	CardDao cardDao;
	@Autowired
	Order order;
	@Autowired
	OrderItems orderItems;
	@Autowired
	OrderItemsDao orderItemsDao;
	@Autowired
	ShippingAddressDao shippingAddressDao;
	@Autowired
	CartDao cartDao;
	@Autowired
	CartItemDao cartItemDao;
	@Autowired
	BillingAddressDao billingAddressDao;
	@Autowired
	HttpSession httpSession;
	CheckOutDetails checkoutDetails = new CheckOutDetails();

	public CheckOutDetails initFlow() {

		customer = customerDao.getCustomerByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		checkoutDetails.setCart(cartDao.getCartByCustomerId(customer.getCustomerId()));
		checkoutDetails.setCustomer(customerDao.getCustomerByUserName(customer.getUserName()));
		return checkoutDetails;
	}

	public String addShippingAddress(CheckOutDetails checkoutDetails, ShippingAddress shippingAddress) {

		customer = customerDao.getCustomerByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		shippingAddress.setCustomerId(customer.getCustomerId());
		checkoutDetails.setShippingAddress(shippingAddress);

		// this.shippingAddress.setCustomerId(customer.getCustomerId());
		// this.shippingAddress.setApartmentNumber(shippingAddress.getApartmentNumber());
		// this.shippingAddress.setCity(shippingAddress.getCity());
		// this.shippingAddress.setCountry(shippingAddress.getCountry());
		// this.shippingAddress.setState(shippingAddress.getState());
		// this.shippingAddress.setStreetName(shippingAddress.getStreetName());
		// this.shippingAddress.setZipCode(shippingAddress.getZipCode());
		//
		return "success";

	}

	public String addBillingAddress(CheckOutDetails checkoutDetails, BillingAddress billingAddress) {
		customer = customerDao.getCustomerByUserName(SecurityContextHolder.getContext().getAuthentication().getName());

		billingAddress.setCustomerId(customer.getCustomerId());
		checkoutDetails.setBillingAddress(billingAddress);

		// this.billingAddress.setCustomerId(customer.getCustomerId());
		// this.billingAddress.setApartmentNumber(billingAddress.getApartmentNumber());
		// this.billingAddress.setCity(billingAddress.getCity());
		// this.billingAddress.setState(billingAddress.getState());
		// this.billingAddress.setStreetName(billingAddress.getStreetName());
		// this.billingAddress.setZipCode(billingAddress.getZipCode());
		// this.billingAddress.setCountry(billingAddress.getCountry());

		return "success";
	}

	public String addCard(CheckOutDetails checkoutDetails, Card card) {
		customer = customerDao.getCustomerByUserName(SecurityContextHolder.getContext().getAuthentication().getName());

		shippingAddressDao.saveOrUpdate(shippingAddress);
		billingAddressDao.saveOrUpdate(billingAddress);

		card.setCustomerId(customer.getCustomerId());
		card.setTotalCost(cartDao.getCartByCustomerId(customer.getCustomerId()).getGrandTotal());
		cardDao.saveOrUpdate(card);

		List<CartItem> listOfCartItems = cartItemDao.getCartItemsByCustomerId(customer.getCustomerId());
		for (CartItem item : listOfCartItems) {
			orderItems.setCustomerId(item.getCustomerId());
			orderItems.setProduct_id(item.getProduct_id());
			orderItems.setQuantity(item.getQuantity());
			orderItems.setTotalPrice(item.getTotalPrice());
			orderItemsDao.saveOrUpdate(orderItems);
			cartItemDao.delete(item.getCartItemId());
		}

		listOfCartItems = cartItemDao.getCartItemsByCustomerId(customer.getCustomerId());
		Cart cart = new Cart();
		double grandTotal = 0;
		for (CartItem item : listOfCartItems) {
			grandTotal = grandTotal + item.getTotalPrice();
		}
		cart = cartDao.getCartByCustomerId(customer.getCustomerId());
		cart.setGrandTotal(grandTotal);

		cart.setCartId(cart.getCartId());
		cart.setCustomerId(cart.getCustomerId());
		cart.setNoOfProducts(listOfCartItems.size());
		cartDao.saveOrUpdate(cart);

		return "success";
	}

}
