//package com.niit.controller;
//
//import java.security.Principal;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
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
//
//@Controller
//public class CartController {
//
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
//	@RequestMapping("/cart/addToCart/{product_id}")
//	public String addToCart(@PathVariable("product_id") String product_id, Model model, Principal principal) {
//        customer=customerDao.getCustomerByUserName(principal.getName());
//        
//        cart=cartDao.getCartByCustomerId(customer.getCustomerId());
//        
//        product = productDao.get(product_id);
//        
//        List<CartItem> list=cartItemDao.getCartItemsByCustomerId(customer.getCustomerId());
//        double grandTotal=0;
//        for(CartItem item:list){
//        	if(item.getProduct_id().equals(item.getProduct_id())){
//        		//CartItem cartItem=cartItem.get(item);
//        	}
//        	
//        	grandTotal=grandTotal+item.getTotalPrice();
//        }
//        cart.setGrandTotal(grandTotal);
//        int noOfProduct=list.size();
//        cart.setCart_id(cart.getCart_id());
//        cart.setCustomerId(customer.getCustomerId());
//        cartDao.saveOrUpdate(cart);
//        
//        
//        
//        
//        
//        
//        
//		return "redirect:/productShow/{product_id}";
//	}
//}
