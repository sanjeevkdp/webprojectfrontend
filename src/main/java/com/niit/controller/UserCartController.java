package com.niit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CartDao;
import com.niit.dao.CartItemDao;
import com.niit.dao.CategoryDao;
import com.niit.dao.CustomerDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.Customer;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
public class UserCartController {

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
	@Autowired
	private Cart cart;
	@Autowired
	private CartItem cartItem;
	@Autowired
	private CartDao cartDao;
	@Autowired
	private CartItemDao cartItemDao;
	@Autowired
	private Customer customer;
	@Autowired
	private CustomerDao customerDao;

	@RequestMapping("/cart/addToCart/{product_id}")
	public ModelAndView addToCart(@PathVariable("product_id") String product_id, Model model, Principal userName)
			throws Exception {
		ModelAndView mv = new ModelAndView("index");

		String customerName = userName.getName();
		customer = customerDao.getCustomerByUserName(customerName);
		String customerId = customer.getCustomerId();
		if (cartDao.getCartByCustomerId(customerId) == null) {
			cart.setCustomerId(customerId);
			cartDao.saveOrUpdate(cart);

		}

		product = productDao.get(product_id);

		if (addCartItem(customerId, product_id, cart.getCart_id()) == null) {
			cartItem = new CartItem();
			cartItem.setCart_id(cart.getCart_id());
			cartItem.setCustomerId(customerId);
			cartItem.setProduct_id(product.getProduct_id());
			cartItem.setQuantity(1);
			cartItem.setTotalPrice(product.getUnit_price());
			cartItemDao.saveOrUpdate(cartItem);

			System.out.println("Insertion of cartItem");
		}
		List<CartItem> listOfSelectedCartItems;
		listOfSelectedCartItems = cartItemDao.getCartItemsByCustomerId(customerId);
		double grandTotal = 0;
		for (CartItem item : listOfSelectedCartItems) {
			grandTotal = grandTotal + item.getTotalPrice();
		}
		cart.setGrandTotal(grandTotal);

		int noOfProduct = listOfSelectedCartItems.size();
		cart.setCart_id(cart.getCart_id());
		cart.setNoOfproduct(noOfProduct);
		cartDao.saveOrUpdate(cart);

		mv.addObject("cartItems", noOfProduct);
		mv.addObject("addToCartSuccessMessage", true);

		// =========== Completed Adding the item to cart =====

		// Now navigate to the same page

		product = productDao.get(product_id);
		model.addAttribute("product", product);

		String categoryName;
		if (product.getCategory_id() != null && !product.getCategory_id().isEmpty()) {
			category = categoryDao.get(product.getCategory_id());
			categoryName = category.getCategory_name();
		} else {
			category.setCategory_name("'Not Available'");
			categoryName = category.getCategory_name();
		}
		mv.addObject("categoryName", categoryName);

		// gets supplier name
		String supplierName;
		if (product.getSupplier_id() != null && !product.getSupplier_id().isEmpty()) {
			supplier = supplierDao.get(product.getSupplier_id());
			supplierName = supplier.getSupplier_name();
		} else {
			supplier.setSupplier_name("'Not Available'");
			supplierName = supplier.getSupplier_name();
		}
		mv.addObject("supplierName", supplierName);

		mv.addObject("isProductShowClicked", "true");
		mv.addObject("active", "login");

		return mv;
	}

	public String addCartItem(String customerId, String product_id, String cart_id) {
		List<CartItem> listOfSelectedCartItems = cartItemDao.getCartItemsByCustomerId(customerId);

		Product product = productDao.get(product_id);

		for (CartItem item : listOfSelectedCartItems) {
			String itemProduct_id = item.getProduct_id();

			if (itemProduct_id.equals(product.getProduct_id())) {

				item.setCartItem_id(item.getCartItem_id());

				item.setQuantity(item.getQuantity() + 1);

				item.setTotalPrice(item.getTotalPrice() + product.getUnit_price());

				cartItemDao.saveOrUpdate(item);
				
				return "Updation Successful";
			}
		}

		return null;
	}
}
