package com.niit.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
import com.niit.viewModel.CartItemModel;

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
	public String addToCart(@PathVariable("product_id") String product_id, Model model, Principal userName) {

		// System.out.println(name);

		// 1.Get the customer id by its user name
		String customerName = userName.getName();
		customer = customerDao.getCustomerByUserName(customerName);
		String customerId = customer.getCustomerId();

		// 2.Check whether his cart is present in the cart table
		// If cart is not present then make a cart for him

		if (cartDao.getCartByCustomerId(customerId) == null) {
			cart = new Cart();
			cart.setCustomerId(customerId);
			cartDao.saveOrUpdate(cart);

			// cartItem.setCartId(cart.getCartId());
		}

		// This statement changes the cart if cart is present and due to
		// unpresence of this there where errors
		else {
			cart = cartDao.getCartByCustomerId(customerId);
		}

		String cart_id = cart.getCart_id();

		// 3.get the product price

		product = productDao.get(product_id);
		
		
		if (addCartItem(customerId, product_id,cart_id, model) == null) {
			cartItem = new CartItem();
			cartItem.setCart_id(cart_id);
			cartItem.setCustomerId(customerId);
			cartItem.setProduct_id(product.getProduct_id());
			cartItem.setQuantity(1);
			cartItem.setTotalPrice(product.getUnit_price());
			cartItemDao.saveOrUpdate(cartItem);
			System.out.println("Insertion of cartItem");
			int noOfProducts = updateCartAgain(cart_id, customerId);
			model.addAttribute("noOfProducts", noOfProducts);
		}
		// Now navigate to the same page
		return "redirect:/productShow/{product_id}?addToCartSuccessMessage";
	}

	// This function will update the cart
	public int updateCartAgain(String cart_id, String customerId) {

		List<CartItem> listOfSelectedCartItems;
		// Now after getting the cartItem change grandTotal and No of Products
		listOfSelectedCartItems = cartItemDao.getCartItemsByCustomerId(customerId);
		double grandTotal = 0;
		for (CartItem item : listOfSelectedCartItems) {
			grandTotal = grandTotal + item.getTotalPrice();
		}
		cart.setGrandTotal(grandTotal);
		
		int noOfProducts = listOfSelectedCartItems.size();

		cart.setCart_id(cart_id);
		cart.setCustomerId(customerId);
		cart.setNoOfproduct(noOfProducts);
		cartDao.saveOrUpdate(cart); // This method updates the cart

		return noOfProducts;
		// =========== Completed Adding the item to cart =====

	}

	// This is the method which perform all the operations related to addition
	// of product cartItem
	public String addCartItem(String customerId, String product_id, String cart_id, Model model) {
		List<CartItem> listOfSelectedCartItems = cartItemDao.getCartItemsByCustomerId(customerId);
		Product product = productDao.get(product_id);
		for (CartItem item : listOfSelectedCartItems) {
			String itemProductId = item.getProduct_id();
			//System.out.println(itemProductId);
			if (itemProductId.equals(product.getProduct_id())) {
				//System.out.println(item.getCart_id());
				item.setCart_id(item.getCart_id());

			//	System.out.println(item.getQuantity());
				item.setQuantity(item.getQuantity() + 1);


			//	System.out.println(item.getTotalPrice());
				item.setTotalPrice(item.getTotalPrice() + product.getUnit_price());

			//	System.out.println(item.toString());
				cartItemDao.saveOrUpdate(item);
				int noOfProducts = updateCartAgain(cart_id, customerId);
				model.addAttribute("noOfProducts", noOfProducts);
				return "redirect:/productShow/{product_id}?addToCartSuccessMessage";

			}

		}

		return null;

	}
	
	@RequestMapping("/cart")
	public ModelAndView Cart(Model model, Principal userName,
			@RequestParam(value = "cartItemRemoved", required = false) String cartItemRemoved)

	{
		ModelAndView mv = new ModelAndView("index");
		String customerName = userName.getName();
		if (cartItemRemoved != null) {
			model.addAttribute("cartItemRemoved", "Cart item removed successfully");
		}

		customer = customerDao.getCustomerByUserName(customerName);
		String customerId = customer.getCustomerId();

		List<CartItemModel> cartItems = null;

		// When there are products in cart
		if (returnProductName(customerId) != null && !returnProductName(customerId).isEmpty()) {
			cartItems = returnProductName(customerId);

			mv.addObject("cartItems", cartItems);
			double grandTotal = cartDao.getCartByCustomerId(customerId).getGrandTotal();
			mv.addObject("grandTotal", grandTotal);

			mv.addObject("noOfProducts", cartItems.size());

		}
		// When there are no products in cart
		else {
			model.addAttribute("cartEmpty", "No items present in the cart");

			mv.addObject("noOfProducts", 0);
		}
		//mv.addObject("isCartClicked", true);
		mv.addObject("isCartClicked", "true");
		mv.addObject("active", "cart");

		return mv;
	}

	// Method to get name of product
	public List<CartItemModel> returnProductName(String customerId) {

		List<CartItem> cartItems = cartItemDao.getCartItemsByCustomerId(customerId);

		List<CartItemModel> cartItemModelList = new ArrayList<>();

		CartItemModel cartItemModel = null;

		for (CartItem item : cartItems) {
			cartItemModel = new CartItemModel();
			cartItemModel.setCartItem(item);
			if (item.getProduct_id() != null && !item.getProduct_id().isEmpty()) {
				product = productDao.get(item.getProduct_id());
				cartItemModel.setProductName(product.getProduct_name());
			} else {
				cartItemModel.setProductName("Currently not avilable");
			}
			cartItemModelList.add(cartItemModel);
		}
		return cartItemModelList;
	}
	@RequestMapping("/cart/remove/{cartItem_id}")
	public String removeCarItems(@PathVariable("cartItem_id") String cartItem_id, Model model) {
		cartItem = cartItemDao.get(cartItem_id);
		String customerId = cartItem.getCustomerId();
		String cart_id = cartItem.getCart_id();
		cartItemDao.delete(cartItem_id);
		int noOfProducts = updateCartAgain(cart_id, customerId);
		model.addAttribute("noOfProducts", noOfProducts);
		return "redirect:/cart/?cartItemRemoved";
	}
}
