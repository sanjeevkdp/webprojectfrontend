//package com.niit.controller;
//
//import java.security.Principal;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.niit.dao.CartDao;
//import com.niit.dao.CartItemDao;
//import com.niit.dao.CategoryDao;
//import com.niit.dao.CustomerDao;
//import com.niit.dao.ProductDao;
//import com.niit.dao.SupplierDao;
//import com.niit.model.Cart;
//import com.niit.model.CartItem;
//import com.niit.model.Category;
//import com.niit.model.Customer;
//import com.niit.model.Product;
//import com.niit.model.Supplier;
//import com.niit.viewModel.CartItemModel;
//
//@Controller
//
//public class cartItemController {
//	@Autowired
//	private ProductDao productDao;
//	@Autowired
//	private Product product;
//	@Autowired
//	private Category category;
//	@Autowired
//	private CategoryDao categoryDao;
//	@Autowired
//	private Supplier supplier;
//	@Autowired
//	private SupplierDao supplierDao;
//	@Autowired
//	private Cart cart;
//	@Autowired
//	private CartItem cartItem;
//	@Autowired
//	private CartDao cartDao;
//	@Autowired
//	private CartItemDao cartItemDao;
//	@Autowired
//	private Customer customer;
//	@Autowired
//	private CustomerDao customerDao;
//	
//	
//	 @RequestMapping("/cart")
//	 public String get(HttpServletRequest request){
//	 return "redirect:/cart/"+request.getSession(true).getId();
//	 }
//	 @RequestMapping(value="/{cart_id}",method=RequestMethod.GET)
//	 public String getCart(@PathVariable(value="cart_id") String cart_id,Model
//	 model){
//	 model.addAttribute("cart_id",cart_id);
//	 return "cart";
//	 }
//	 @RequestMapping("/cart")
//	 public ModelAndView getCart(Model model){
//	 ModelAndView mv=new ModelAndView("index");
//	 mv.addObject("isCartClicked","true");
//	 mv.addObject("active","cart");
//	 return mv;
//	
//	
//	 }
//}